package org.sy.fiar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sy.fiar.bean.Role;
import org.sy.fiar.bean.User;
import org.sy.fiar.dao.RolesUserMapper;
import org.sy.fiar.dao.UserMapper;
import org.sy.fiar.pub.constants.UserConstant;
import org.sy.fiar.pub.utils.ContextUtil;

import java.util.List;

/**
 * 用户Service
 *
 * @since 2021-07-04
 * @author sy
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired UserMapper userMapper;

    @Autowired RolesUserMapper rolesUserMapper;

    @Autowired PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.loadUserByUsername(s);
        if (user == null) {
            // 避免返回null，这里返回一个不含有任何值的User对象，在后期的密码比对过程中一样会验证失败
            return new User();
        }
        // 查询用户的角色信息，并返回存入user中
        List<Role> roles = rolesUserMapper.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;
    }

    /**
     * @Description 注册 1表示用户名重复 2表示失败 @Author sy @Date 19:29 2021/7/4 @Param [user]
     *
     * @return int
     */
    public int register(User user) {
        User loadUserByUsername = userMapper.loadUserByUsername(user.getUsername());
        if (loadUserByUsername != null) {
            return UserConstant.RegisterResult.DUPLICATE_USERNAME;
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEnabled(true);

        long result = userMapper.register(user);

        // 配置用户角色，默认普通用户
        String[] roles = new String[] {"2"};
        int addRolesNum = rolesUserMapper.addRoles(roles, user.getId());

        boolean regResult = addRolesNum == roles.length && result == 1;
        if (regResult) {
            return UserConstant.RegisterResult.SUCCESS;
        }

        return UserConstant.RegisterResult.FAILED;
    }

    public int updateUserEmail(String email) {
        return userMapper.updateUserEmail(email, ContextUtil.getCurrentUser().getId());
    }

    public List<User> getUserByNickname(String nickname) {
        return userMapper.getUserByNickname(nickname);
    }

    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    public List<Role> getAllRole() {
        return userMapper.getAllRole();
    }

    public int updateUserEnabled(Boolean enabled, Long uid) {
        return userMapper.updateUserEnabled(enabled, uid);
    }

    public int deleteUserById(Long uid) {
        return userMapper.deleteUserById(uid);
    }

    public int updateUserRoles(Long[] rids, Long id) {
        int i = userMapper.deleteUserRolesByUid(id);
        return userMapper.setUserRoles(rids, id);
    }
}
