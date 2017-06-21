package edu.mum.onlineshoping.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@GetMapping({"/", "/home"})
	public String homePage() {
		return "home";
	}
	@GetMapping({ "/index"})
	public String indexPage() {
		return "index";
	}
	

	@GetMapping({"/secure"})
	public String securePage() {
		return "secure";
	}
	@RequestMapping("/user")
	public String toUserPage(){
		return "userPage";
	}
	@RequestMapping("/admin")
	public String toAdminPage(){
		return "adminPage";
	}
	
	@RequestMapping("/login")
	public String toLoginPage(){
		return "login";
	}
	
	@RequestMapping("/register")
	public String register(){
		System.out.println("11111111111");
		return "register";
	}
	
	
//	@Autowired
//	public PersonService personService;
//	@GetMapping({ "/regist" })
//	public ModelAndView toRegistPage() {
//		ModelAndView modelAndView = new ModelAndView("regist");
//		Person person = new Person();
//		modelAndView.addObject(person);
//		return modelAndView;
//	}
//
//	@RequestMapping("/savePerson")
//	public String saveProductPage(@ModelAttribute(value = "person") Person person) {
//		System.out.println(person);
//		personService.savePerson(person);
//		return "redirect:/login";
//	}
	
}
