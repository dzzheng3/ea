package edu.mum.onlineshoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/admin")
public class AdminNaviController {
	@RequestMapping("/manageProduct")
	public String manageProduct(){
		return "admin/manageProduct";
	}
	@RequestMapping("/manageCatagory")
	public String manageCatagory(){
		return "admin/manageCatagory";
	}
	@RequestMapping("/manageUser")
	public String manageUser(){
		return "admin/manageUser";
	}
	
}
