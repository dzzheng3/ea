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

import edu.mum.onlineshoping.model.Category;
import edu.mum.onlineshoping.service.CategoryService;

@Controller("/admin/manageCategory")
public class ManageCatagoryController {
	@Autowired
	private CategoryService categoryService;

	@RequestMapping("/addCategory")
	public String addCategory(Model model) {
		Category category = new Category();
		model.addAttribute("category", category);
		System.out.println("/addCategory");
		return "/admin/addCategory";
	}

	@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
	public String addCategory(@Valid Category category, BindingResult result,Model model) {
		model.addAttribute("category",category);
		System.out.println("/ccc");
		
		if (result.hasErrors()) {
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError error : list) {
//				System.out.println(error.getCode() + "---" + error.getArguments() + "---" + error.getDefaultMessage());
//			}
			return "admin/addCategory";
		}
		categoryService.add(category);
		return "redirect:listCategory";
	}

	@RequestMapping("/listCategory")
	public String listCategory(Model model) {
		List<Category> categorys = categoryService.getAll();
		model.addAttribute("categorys",categorys);
		System.out.println("/listCategory");
		return "/admin/listCategory";
	}
	@RequestMapping("/deleteCategory/{id}")
	public String deleteCategoryPage(@PathVariable Long id) {
		System.out.println("deleteCategoryPage");
		categoryService.delete(id);
		return "redirect:/listCategory";
	}

	@RequestMapping("/updateCategory/{id}")
	public String updateCategorysPage(@PathVariable("id") Long id, Map<String, Object> map) {
		Category category = categoryService.getCategoryById(id);
		map.put("category", category);
		return "/admin/updateCategory";
	}

//	@ModelAttribute
//	public void getCategory(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
//		if (id != null) {
//			map.put("Category", categoryService.getCategory(id));
//			System.out.println("111111");
//		}
//		System.out.println("2222222222");
//	}

	@RequestMapping(value="/updateCategory/{id}",method=RequestMethod.POST)
	public String updateCategorysPage(@PathVariable("id") Long id,Category category) {
		categoryService.add(category);
		System.out.println(category);
		return "redirect:/listCategory";
	}
	
	
}
