package org.sy.fiar.mapper;

import org.apache.ibatis.annotations.Param;
import org.sy.fiar.bean.Role;

import java.util.List;

/**
 * @Description 用户角色对应
 * @Author sy
 * @Date 2021/7/4 20:15
 * @Version 1.0
 */
public interface RolesUserMapper {

    int addRoles(@Param("roles") String[] roles, @Param("uid") long uid);

    List<Role> getRolesByUid(long uid);

}
