package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getListAllUsers(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "users";
    }

    @GetMapping("/addUser")
    public String getFormAddNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("/saveUser")
    public String saveNewUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:users";
    }

    @GetMapping("/{id}/editUser")
    public String getFormEditUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "updateUser";
    }


    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:users";
    }

    @GetMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:users";
    }
}
