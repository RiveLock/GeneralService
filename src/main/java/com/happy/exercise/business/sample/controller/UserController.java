package com.happy.exercise.business.sample.controller;

import com.happy.exercise.business.sample.entity.User;
import com.happy.exercise.business.sample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author John J
 * @since 2021-03-03
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String list(ModelMap map) {
        map.addAttribute("userList", userService.list());
        return "userList";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.removeById(id);
        return "redirect:/user/list";
    }

    // 进入添加界面
    @GetMapping("/intoAdd")
    public String intoAdd(){
        return "addUser";
    }

    // 进入添加界面
    @GetMapping("/intoUpdate/{id}")
    public String intoUpdate(@PathVariable Integer id, ModelMap map){
        map.addAttribute("user", userService.getById(id));
        return "updateUser";
    }

    @PostMapping("/add")
    public String addUser(User user) {
        user.setCreatedTime(LocalDateTime.now());
        userService.save(user);
        return "redirect:/user/list";
    }

    @PostMapping("update")
    public String updateUser(User user) {
        user.setUpdatedTime(LocalDateTime.now());
        userService.updateById(user);
        return "redirect:/user/list";
    }

    @GetMapping("/greeting")
    public String greeting(Model model) {
        model.addAttribute("name", "啦啦啦");
        return "greeting";
    }

}
