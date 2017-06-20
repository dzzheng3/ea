package edu.mum.onlineshoping.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.onlineshoping.model.Customer;
import edu.mum.onlineshoping.model.Role;
import edu.mum.onlineshoping.service.UserService;

@Controller
@SessionAttributes("userSession")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String signUp(Model model) {
		model.addAttribute("customer", new Customer());
		return "user/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String afterSignUp(@Valid Customer customer, BindingResult result, RedirectAttributes redirectAttributes,
			Model model) {
		model.addAttribute("customer", customer);
		customer.getUser().setHasRole(Role.ROLE_CUSTOMER);
		if (result.hasErrors()) {
			return "user/register";
		}
		userService.save(customer);
		redirectAttributes.addFlashAttribute("customer", customer);
		return "redirect:/login";

	}

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String allUser(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id) {
		userService.delete(id);
		return "users";
	}

	@RequestMapping(value = "/editProfile/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model) {
		Customer customer = userService.findOne(id);
		model.addAttribute("customer", customer);
		return "editProfile";
	}

	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public String afterEdit(@ModelAttribute("customer") @Valid Customer customer, BindingResult result,
			RedirectAttributes redirectAttributes) {
		customer.getUser().setHasRole(Role.ROLE_CUSTOMER);
		if (result.hasErrors())
			return "editProfile";
		customer.setId(customer.getId());
		userService.edit(customer);
		redirectAttributes.addFlashAttribute("customer", customer);
		return "redirect:/profile";
	}

	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		Customer customer = userService.findOneWithName(name);
		model.addAttribute("user", customer);
		return "profile";

	}

}
