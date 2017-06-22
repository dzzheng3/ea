package edu.mum.onlineshoping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.onlineshoping.jms.MsgSender;

@Controller
public class HomeController  {
	@Autowired
	JmsTemplate jmsTemplate;

	@GetMapping({ "/", "/home" })
	public String homePage() {
		return "home";
	}

	@GetMapping({ "/index" })
	public String indexPage() {
		return "index";
	}

	@GetMapping({ "/secure" })
	public String securePage() {
		return "secure";
	}

	@RequestMapping("/user")
	public String toUserPage(HttpSession httpSession) throws Exception {
		return "userPage";
	}

	@RequestMapping("/admin")
	public String toAdminPage() throws Exception {
		return "adminPage";
	}

	@RequestMapping("/login")
	public String toLoginPage() {
		return "login";
	}


	// @Autowired
	// public PersonService personService;
	// @GetMapping({ "/regist" })
	// public ModelAndView toRegistPage() {
	// ModelAndView modelAndView = new ModelAndView("regist");
	// Person person = new Person();
	// modelAndView.addObject(person);
	// return modelAndView;
	// }
	//
	// @RequestMapping("/savePerson")
	// public String saveProductPage(@ModelAttribute(value = "person") Person
	// person) {
	// System.out.println(person);
	// personService.savePerson(person);
	// return "redirect:/login";
	// }

}
