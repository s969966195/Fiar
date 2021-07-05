package org.sy.fiar.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.sy.fiar.bean.User;

/**
 * @Description 用户Dao
 * @Author sy
 * @Date 2021/7/4 19:47
 * @Version 1.0
 */
public interface UserMapper {

    User loadUserByUsername(@Param("username") String username);

    long register(User user);

}
