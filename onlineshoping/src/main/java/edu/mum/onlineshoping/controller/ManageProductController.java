package edu.mum.onlineshoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.onlineshoping.model.Product;

@Controller("/admin/manageProduct")
public class ManageProductController {
	@RequestMapping("/addProduct")
	public String addProduct(Model model){
		Product product = new Product();
		model.addAttribute("product",product);
		System.out.println("/addProduct");
		return "/admin/addProduct";
	}
	@RequestMapping("/saveProduct")
	public String addProduct(@ModelAttribute Product product){
//		model.addAttribute("product",product);
		System.out.println("/addProduct");
		return "/admin/addProduct";
	}
	@RequestMapping("/listProduct")
	public String listProduct(){
		System.out.println("/addProduct");
		return "/admin/listProduct";
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
