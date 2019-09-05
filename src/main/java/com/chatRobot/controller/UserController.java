package com.chatRobot.controller;

import com.chatRobot.model.User;
import com.chatRobot.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

        @Autowired
        private UserService userService;

        @RequestMapping(value = "/showUser.do",method = RequestMethod.POST)
        public void selectUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
            System.out.println("================================");
            request.setCharacterEncoding("UTF-8");
            response.setCharacterEncoding("UTF-8");
            long userId = Long.parseLong(request.getParameter("id"));
            User user = this.userService.selectUser(userId);
            ObjectMapper mapper = new ObjectMapper();
            response.getWriter().write(mapper.writeValueAsString(user));
            response.getWriter().close();
        }


        @RequestMapping(value = "/login.do")
        public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
            System.out.println("login-------------------------");
            //response.sendRedirect("/webapp/Modules/Default.jsp");
            return "Default";
        }


    @RequestMapping(value = "/manage.do")
    public String manager(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("manage-------------------------");
        //response.sendRedirect("/webapp/Modules/Default.jsp");
        return "User/UserManage";
    }


    @RequestMapping(value = "/userinfo.do")
    public String userinfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("manage-------------------------");
        //response.sendRedirect("/webapp/Modules/Default.jsp");
        return "User/UserInfo";
    }



    @RequestMapping(value = "/useredit.do")
    public String useredit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("manage-------------------------");
        //response.sendRedirect("/webapp/Modules/Default.jsp");
        return "User/UserEdit";
    }

}
