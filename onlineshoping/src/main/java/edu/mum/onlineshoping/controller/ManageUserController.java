package edu.mum.onlineshoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/admin/manageUser")
public class ManageUserController {
	@RequestMapping("/addUser")
	public String addProduct(){
		System.out.println("/addUser");
		return "/admin/addUser";
	}
	@RequestMapping("/listUser")
	public String listProduct(){
		System.out.println("/listUser");
		return "/admin/listUser";
	}
//	@RequestMapping("/addProduct")
//	public void test1(){
//		System.out.println("/addProduct");
////		return "manageProduct";
//	}
//	@RequestMapping("/addProduct")
//	public String test(){
//		System.out.println("addProduct");
//		return "addProduct";
//	}
//	@RequestMapping("/saveProduct")
//	public String saveProduct(){
//		System.out.println("add");
//		return "saveProduct";
//	}
	
	
}
