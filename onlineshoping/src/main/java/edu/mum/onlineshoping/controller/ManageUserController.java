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

import edu.mum.onlineshoping.model.Customer;
import edu.mum.onlineshoping.service.UserService;

@Controller("/admin/manageUser")
public class ManageUserController {
	@Autowired
	private UserService UserService;

	@RequestMapping("/addUser")
	public String addUser(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		System.out.println("/addUser");
		return "/admin/addUser";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public String addUser(@Valid Customer customer, BindingResult result,Model model) {
		model.addAttribute("customer",customer);
		System.out.println("/addUser1111");
		
		if (result.hasErrors()) {
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError error : list) {
//				System.out.println(error.getCode() + "---" + error.getArguments() + "---" + error.getDefaultMessage());
//			}
			return "admin/addUser";
		}
		UserService.save(customer);
		return "redirect:listUser";
	}

	@RequestMapping("/listUser")
	public String listUser(Model model) {
		List<Customer> customers = UserService.findAll();
		model.addAttribute("customers",customers);
		System.out.println("/listUser");
		return "/admin/listUser";
	}
	@RequestMapping("/deleteUser/{id}")
	public String deleteUserPage(@PathVariable Long id) {
		UserService.delete(id);
		return "redirect:/listUser";
	}

	@RequestMapping("/updateUser/{id}")
	public String updateUsersPage(@PathVariable("id") Long id, Map<String, Object> map) {
		Customer customer = UserService.findOne(id);
		map.put("customer", customer);
		return "/admin/updateUser";
	}

//	@ModelAttribute
//	public void getUser(@RequestParam(value = "id", required = false) Integer id, Map<String, Object> map) {
//		if (id != null) {
//			map.put("User", UserService.getUser(id));
//			System.out.println("111111");
//		}
//		System.out.println("2222222222");
//	}

	@RequestMapping(value="/updateUser/{id}",method=RequestMethod.POST)
	public String updateUsersPage(@PathVariable("id") Long id,Customer customer) {
		UserService.save(customer);
		System.out.println(customer);
		return "redirect:/listUser";
	}
}
