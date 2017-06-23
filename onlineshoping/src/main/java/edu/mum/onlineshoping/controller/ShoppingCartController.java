package edu.mum.onlineshoping.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import edu.mum.onlineshoping.model.Customer;
import edu.mum.onlineshoping.model.Role;
import edu.mum.onlineshoping.model.ShoppingCart;
import edu.mum.onlineshoping.service.ShoppingCartService;
import edu.mum.onlineshoping.service.UserService;

@Controller
public class ShoppingCartController {
	@Autowired
	private ShoppingCartService shoppingCartService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/cartList", method = RequestMethod.GET)
	public String getCartList(Model model) {
		List<ShoppingCart> shoppingCart = shoppingCartService.getAll();
		System.out.println("shoppingCart size" + shoppingCart.size());
		model.addAttribute("shoppingCart", shoppingCart);
		double totalPrice = shoppingCartService.findTotalCartCost(shoppingCart);
		model.addAttribute("totalPrice", totalPrice);
		return "shoppingCart/cartList";
	}

	@RequestMapping(value = "/addShoppingCart/{productId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public void addCart(@PathVariable Long productId) {

		shoppingCartService.saveShoppingCart(productId);
		System.out.println("addCart");
	}

	@RequestMapping(value = "/removeShoppingCart/{shoppingCartId}", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	public String removeCart(@PathVariable Long shoppingCartId) {
//		System.out.println("shoppingCartId" + shoppingCartId);
		ShoppingCart shoppingCart = shoppingCartService.getById(shoppingCartId);
		if (shoppingCart != null)
			shoppingCartService.deletShoppingCart(shoppingCart);
		return "redirect:cartList";
	}

	@RequestMapping(value = "/removeAllShoppingCart", method = RequestMethod.GET)
	// @ResponseStatus(value = HttpStatus.NO_CONTENT)
	public String removeAllCart() {
		shoppingCartService.deletAllCart();
		return "redirect:cartList";
	}

	// mapping the user for check out
	@RequestMapping(value = "/editinfo/{username}", method = RequestMethod.GET)
	public String editInfo(@PathVariable("username") String username, Model model) {
		Customer customer = userService.findOneWithName(username).get(0);
		model.addAttribute("user", customer);
		return "editinfo";
	}

	// place order
	@RequestMapping(value = "/editinfo", method = RequestMethod.POST)
	public String afteredit(@ModelAttribute("user") @Valid Customer customer, BindingResult result, Model model) {
		customer.getUser().setHasRole(Role.ROLE_USER);
		if (result.hasErrors()) {
			return "editinfo";
		}
		customer.setId(customer.getId());
		userService.edit(customer);
		model.addAttribute("customer", customer);
		List<ShoppingCart> shoppingCarts = shoppingCartService.getAll();
		double totalPrice = shoppingCartService.findTotalCartCost(shoppingCarts);

		model.addAttribute("billingInfo", shoppingCarts);
		model.addAttribute("totalPrice", totalPrice);
		return "billing";
	}
}
