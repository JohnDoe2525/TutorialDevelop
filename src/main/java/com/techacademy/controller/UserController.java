package com.techacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techacademy.entity.User;
import com.techacademy.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    /**一覧画面を表示*/
    @GetMapping("/list")
    public String getlist(Model model) {
        model.addAttribute("userlist", service.getUserList());
        return "user/list";
    }

    @GetMapping("/register")
    public String getRegister(@ModelAttribute User user) {
        return "user/register";
    }

    @PostMapping("/register")
    //引数にエンティティを指定することで、HTMLのFormの項目値が、引数のuserの属性としてセットされた状態で受け取る
    public String postRegister(User user) {
        service.saveUser(user);
        return "redirect:/user/list";
    }
}
