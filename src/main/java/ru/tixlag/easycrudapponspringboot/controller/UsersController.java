package ru.tixlag.easycrudapponspringboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.tixlag.easycrudapponspringboot.service.UserService;
import ru.tixlag.easycrudapponspringboot.model.User;

@Controller
//@RequestMapping("/users")
public class UsersController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String users(ModelMap model) {
        model.addAttribute("users", userService.getAll());

        return "users";
    }

    // ??? @RequestBody не работает у меня никак

    @PostMapping("/new")
    public String addUser(@RequestParam("name") String name,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("age") byte age, ModelMap model) {
        // ??? Это плохо, что я здесь из модели юзера создаю?
        userService.add(new User(name, lastName, age));
        return "redirect:/";
    }

    @PatchMapping("/edit/")
    public String editUser(@RequestParam("user_id") Long id, @RequestParam("name") String name,
                           @RequestParam("last_name") String lastName,
                           @RequestParam("age") Byte age) {
        userService.edit(id, name, lastName, age);
        return "redirect:/";
    }

    @DeleteMapping("/edit/")
    public String deleteUser(@RequestParam("user_id") Long id) {
        userService.delete(id);
        return "users";
    }

}
