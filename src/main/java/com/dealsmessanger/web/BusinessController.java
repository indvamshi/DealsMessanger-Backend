package com.dealsmessanger.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/merchant")
@PreAuthorize("hasRole('ROLE_MERCHANT')")
public class BusinessController {

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String showDashboard() {
		return "merchantdb";
	}
}
