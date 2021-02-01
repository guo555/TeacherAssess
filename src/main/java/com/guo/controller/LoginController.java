package com.guo.controller;

import com.guo.mapper.UserMapper;
import com.guo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    private UserMapper usermapper;


    //用户登录
    @PostMapping("/userlogin")
    public String login(@RequestParam("number") String stu_num,
                        @RequestParam("password") String tel,
                        Model model, HttpSession session){


        User user = usermapper.findByUsernameAndPassword(stu_num,tel);

        if(user!=null){
            session.setAttribute("loginId",user.getId());
            session.setAttribute("loginUser",user.getUsername());
            session.setAttribute("loginNum",user.getStu_num());
            session.setAttribute("loginTel",user.getTel());
            session.setAttribute("loginChoice",user.getChoice());
            session.setAttribute("loginAssess",user.getStu_assess());
            return "redirect:/main.html";
        }else {
            //登录失败
            model.addAttribute("msg","学号或手机号错误");
            return "login";
        }

    }

    //用户注销
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login.html";
    }
    //添加评价分数
    @RequestMapping("/addassess")
    @ResponseBody
    public String addassess(int stu_assess ,int id,String stu_sg){
        User user = usermapper.findbyname(id);
        user.setStu_assess(stu_assess);
        user.setStu_sg(stu_sg);
        usermapper.updateUser(user);
        return "true";

    }

}
