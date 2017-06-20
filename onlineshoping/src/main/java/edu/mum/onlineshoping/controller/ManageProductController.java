package edu.mum.onlineshoping.controller;


import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.onlineshoping.model.Product;
import edu.mum.onlineshoping.service.ProductService;

@Controller("/admin/manageProduct")
public class ManageProductController {
	@Autowired
	private ProductService productService;

	@RequestMapping("/addProduct")
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		System.out.println("/addProduct");
		return "/admin/addProduct";
	}

	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct(@Valid Product product, BindingResult result,Model model) {
		model.addAttribute("product",product);
		System.out.println("/addProduct1111");
		
		if (result.hasErrors()) {
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError error : list) {
//				System.out.println(error.getCode() + "---" + error.getArguments() + "---" + error.getDefaultMessage());
//			}
			return "admin/addProduct";
		}
		productService.addProduct(product);
		return "redirect:listProduct";
	}

	@RequestMapping("/listProduct")
	public String listProduct(Model model) {
		List<Product> products = productService.getAll();
		model.addAttribute("products",products);
		System.out.println("/listProduct");
		return "/admin/listProduct";
	}
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProductPage(@PathVariable Long id) {
		productService.delete(id);
		return "redirect:/listProduct";
	}

	@RequestMapping("/updateProduct/{id}")
	public String updateProductsPage(@PathVariable("id") Long id, Map<String, Object> map) {
		Product product = productService.getProductById(id);
		map.put("product", product);
		return "/admin/updateProduct";
	}

//	@ModelAttribute
//	public void getProduct(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
//		if (id != null) {
//			map.put("product", productService.getProduct(id));
//			System.out.println("111111");
//		}
//		System.out.println("2222222222");
//	}

	@RequestMapping(value="/updateProduct/{id}",method=RequestMethod.POST)
	public String updateProductsPage(@PathVariable("id") Long id,Product product) {
		productService.addProduct(product);
		System.out.println(product);
		return "redirect:/listProduct";
	}

}
