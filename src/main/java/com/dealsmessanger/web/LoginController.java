package com.dealsmessanger.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(method = RequestMethod.GET)
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
		return "index";

	}
	
	@RequestMapping(value = "/denied", method = RequestMethod.GET)
	public String denied() {

		return "denied";

	}
	
	@RequestMapping(value = "/loginProcessing")
	public String processingUrl(HttpServletRequest request) {
		String name = SecurityContextHolder.getContext().getAuthentication().getName();
		if (request.getParameter("username").equalsIgnoreCase(name)) {
			return "/merchant/dashboard";
		}
		return "/login";
	}
}
