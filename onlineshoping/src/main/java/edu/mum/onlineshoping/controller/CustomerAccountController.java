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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.mum.onlineshoping.model.Customer;
import edu.mum.onlineshoping.model.Product;
import edu.mum.onlineshoping.model.Role;
import edu.mum.onlineshoping.service.ProductService;
import edu.mum.onlineshoping.service.UserService;

@Controller
public class CustomerAccountController {
@Autowired
private UserService userService;


@RequestMapping(value = "/register", method = RequestMethod.GET)
public String signUp(Model model) {
	model.addAttribute("role", Role.values());
	model.addAttribute("customer", new Customer());
	return "register";
}

@RequestMapping(value = "/register", method = RequestMethod.POST)
public String register(@Valid Customer customer, BindingResult result, RedirectAttributes redirectAttributes,
		Model model) {
	
	model.addAttribute("customer", customer);
//	customer.getUser().setHasRole(Role.ROLE_CUSTOMER);
	if (result.hasErrors()) {
		model.addAttribute("role", Role.values());
		return "register";
	}
	userService.save(customer);
	redirectAttributes.addFlashAttribute("customer", customer);
	return "redirect:/login";

}

/*@RequestMapping(value = "/editProfile/{id}", method = RequestMethod.GET)
public String edit(@PathVariable Long id, Model model) {
	Customer customer = userService.findOne(id);
	model.addAttribute("customer", customer);
	return "editProfile";
}*/

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

@RequestMapping(value = "/profile", method = RequestMethod.GET)
public String account(Model model, Principal principal) {
	String name = principal.getName();
	System.out.println(name);
	Customer customer = userService.findOneWithName(name);
	System.out.println(customer);
	model.addAttribute("customer", customer);
	return "profile";

}


}
