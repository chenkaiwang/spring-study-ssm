package com.study.smm.controller;

import com.study.smm.dao.UserMapper;
import com.study.smm.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String test(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println("userId:" + userId);
        User user = null;
        if (userId == 1) {
            user = new User();
            user.setAge(11);
            user.setId(1);
            user.setPassword("123");
            user.setUserName("ssm");
        }
        LOGGER.debug(user.toString());
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/showUser", method = RequestMethod.GET)
    public String showUser(@RequestParam("id") String id, Model model) {
        int userId = Integer.parseInt(id);
        System.out.println("userId:" + userId);
        List<User> userList = this.userMapper.findAll();
        model.addAttribute("user", userList.get(0));
        return "showUser";
    }
}
