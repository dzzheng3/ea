package edu.mum.onlineshoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/user")
public class CustomerNaviController {
	@RequestMapping("/profile")
	public String editProfile(){
		return "profile";
	}
	@RequestMapping("/viewProducts")
	public String manageCatagory(){
		return "user/viewProducts";
	}
	@RequestMapping("/cartList")
	public String manageUser(){
		return "shoppingCart/cartList";
	}

}
