package com.zking.controller;

import com.zking.model.User;
import com.zking.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("userList")
    @RequiresRoles("管理员")
    public String list(HttpSession session){
        List<User> users = userService.list();
        session.setAttribute("users",users);
        return "userList";
    }

    @RequestMapping("doEdit")
    public String editUser(User user){
        int n=-1;
        if(null!=user.getUserid()&&user.getUserid()!=0){
            //修改
           n = userService.updateByPrimaryKey(user);
        }else{
            n = userService.insert(user);
        }
        if(n>0){
            return "redirect:userList";
        }else{
            return "editUser";

        }
    }

    @RequestMapping("/deluser")
    public String del(Integer userId){

        int n = userService.deleteByPrimaryKey(userId);
        return "redirect:userList";
    }
}
