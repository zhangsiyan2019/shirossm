package com.zking.mapper;

import com.zking.model.User;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据用户输入的账号获取到用户的个人信息
     * @param username
     * @return
     */
    public User selectByUserName(String username);

    /**
     * 根据用户名获取到用户的角色信息
     * @param username
     * @return
     */
    public Set<String> getRoleByUserName(String username);

    /**
     * 根据用户名获取到用户的权限信息
     * @param username
     * @return
     */
    public Set<String> getPermissionByUserName(String username);

    /**
     * 获取所有用户信息
     * @return
     */
    List<User> list();




}