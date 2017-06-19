package edu.mum.onlineshoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("/admin/manageCatagory")
public class ManageCatagoryController {
	@RequestMapping("/addCatagory")
	public String addProduct(){
		System.out.println("/addCatagory");
		return "/admin/addCatagory";
	}
	@RequestMapping("/listCatogory")
	public String listProduct(){
		System.out.println("/listCatogory");
		return "/admin/listCatogory";
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
