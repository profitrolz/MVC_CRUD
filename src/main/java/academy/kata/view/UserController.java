package academy.kata.view;

import academy.kata.dao.Crud;
import academy.kata.model.User;
import academy.kata.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService crud) {
        this.userService = crud;
    }

    @GetMapping(value = "/")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/";
    }

    @RequestMapping("/user")
    public String showForm(Map<String, Object> model) {
        model.put("user", new User());
        return "user";
    }

    @RequestMapping("/delete")
    public String deleteUser(@RequestParam Optional<Integer> id, Map<String, Object> model) {
        id.ifPresent(userService::deleteById);
        return "redirect:/";
    }

    @RequestMapping("/update")
    public String updateUser(@RequestParam Optional<Integer> id, Model model) {
        model.addAttribute("user", userService.findById(id.orElseThrow(IllegalArgumentException::new)));
        return "user_update";
    }
}
