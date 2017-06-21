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
public class HomeController implements CommandLineRunner {
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
		run("");
		return "userPage";
	}

	@RequestMapping("/admin")
	public String toAdminPage() throws Exception {
		run("1");
		return "adminPage";
	}

	@RequestMapping("/login")
	public String toLoginPage() {
		return "login";
	}

	@Override
	public void run(String... strings) throws Exception {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			// httpSession.setAttribute("msg", ""+userDetails.getUsername()+"
			// login!!");
			jmsTemplate.send("my-destination", new MsgSender(userDetails.getUsername() + " login!!"));
		}
	}

	@JmsListener(destination = "my-destination")
	public void receiveMessage(String message) {
		System.out.println("receive message：" + message);
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
