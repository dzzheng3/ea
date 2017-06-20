package edu.mum.onlineshoping.controller;

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
		model.addAttribute("customer",new Customer());
		return "user/register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String afterSignUp(@ModelAttribute("user") @Valid Customer customer, BindingResult result,
			RedirectAttributes redirectAttributes) {
		System.out.println("112222222222222");
		customer.getUser().setHasRole(Role.ROLE_CUSTOMER);
		if (result.hasErrors())
			return "register";
		userService.save(customer);
		redirectAttributes.addFlashAttribute("customer", customer);
		return "redirect:/index";

	}
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String allUser(Model model){
		model.addAttribute("users", userService.findAll());
		return "users";
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id){
		userService.delete(id);
		return "users";
	}
	
	@RequestMapping(value = "/updateUser/{id}", method = RequestMethod.GET)
	public String edit(@PathVariable Long id, Model model)
	{
		Customer customer= userService.findOne(id);
		model.addAttribute("user", customer);
		return "updateUser";
	}
	
	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public String afterEdit(@ModelAttribute("user") @Valid Customer customer, BindingResult result,
			RedirectAttributes redirectAttributes){
		customer.getUser().setHasRole(Role.ROLE_CUSTOMER);
		if (result.hasErrors())
			return "updateUser";
		customer.setId(customer.getId());
		userService.edit(customer);
		redirectAttributes.addFlashAttribute("customer", customer);
		return "redirect:/index";
	}
	
	
	
	
}

