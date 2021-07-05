package org.sy.fiar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.sy.fiar.bean.User;
import org.sy.fiar.mapper.RolesUserMapper;
import org.sy.fiar.mapper.UserMapper;
import org.sy.fiar.pub.constants.UserConstant;

/**
 * 用户Service
 *
 * @since 2021-07-04
 * @author sy
 */
@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RolesUserMapper rolesUserMapper;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    /**
     * @Description 注册 1表示用户名重复 2表示失败
     * @Author sy
     * @Date 19:29 2021/7/4
     * @Param [user]
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
        String[] roles = new String[]{"2"};
        int addRolesNum = rolesUserMapper.addRoles(roles, user.getId());

        boolean regResult = addRolesNum == roles.length && result == 1;
        if (regResult) {
            return UserConstant.RegisterResult.SUCCESS;
        }

        return UserConstant.RegisterResult.FAILED;
    }
}
