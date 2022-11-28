package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import web.model.User;
import web.service.userService;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping()
public class UserController {

	private final userService US;

	public UserController(userService us) {
		this.US = us;
	}

	@GetMapping(value = "/")
	public String printWelcome(ModelMap model) {
		model.addAttribute("messages", US.getAllUsers());
		return "index";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam(value = "id", required = true, defaultValue = "") long id,Model model) {
		User user = US.deleteUser(id);
		model.addAttribute("flashMessage",user.getName());
		return "redirect:/";
	}
	@GetMapping("/new")
	public String newUser(Model model){
		model.addAttribute("user",new User());
		return "form";
	}

	@PostMapping()
	public String create(@ModelAttribute("user") User user){
		US.createUser(user);
		return "redirect:/";
	}

	@GetMapping("/edit/{id}")
	public String edit(Model model,@PathVariable("id") long id){
		model.addAttribute("user",US.readUser(id));
		return "edit";
	}
	@PatchMapping("/{id}")
	public String update(@ModelAttribute("user")User user,@PathVariable("id") long id){
		US.updateUser(user);
		return "redirect:/";
	}

}