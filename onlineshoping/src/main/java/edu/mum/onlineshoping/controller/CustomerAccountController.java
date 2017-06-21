package edu.mum.onlineshoping.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	model.addAttribute("customer", new Customer());
	return "register";
}

@RequestMapping(value = "/register", method = RequestMethod.POST)
public String register(@Valid Customer customer, BindingResult result, RedirectAttributes redirectAttributes,
		Model model) {
	
	model.addAttribute("customer", customer);
	customer.getUser().setHasRole(Role.ROLE_CUSTOMER);
	if (result.hasErrors()) {
		return "register";
	}
	userService.save(customer);
	redirectAttributes.addFlashAttribute("customer", customer);
	return "redirect:/login";

}


}
