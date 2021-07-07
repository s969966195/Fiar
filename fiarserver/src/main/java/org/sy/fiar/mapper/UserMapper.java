package org.sy.fiar.mapper;

import org.apache.ibatis.annotations.Param;
import org.sy.fiar.bean.Role;
import org.sy.fiar.bean.User;

import java.util.List;

/**
 * @Description 用户Dao
 * @Author sy
 * @Date 2021/7/4 19:47
 * @Version 1.0
 */
public interface UserMapper {

    User loadUserByUsername(@Param("username") String username);

    long register(User user);

    int updateUserEmail(@Param("email") String email, @Param("id") Long id);

    List<User> getUserByNickname(@Param("nickname") String nickname);

    User getUserById(@Param("id") Long id);

    List<Role> getAllRole();

    int updateUserEnabled(@Param("enabled") Boolean enabled, @Param("uid") Long uid);

    int deleteUserById(Long uid);

    int deleteUserRolesByUid(Long id);

    int setUserRoles(@Param("rids") Long[] rids, @Param("id") Long id);

}
