package com.dealsmessanger.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class AdminController {

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String showDashboardForAdmin() {
		return "admindb";
	}
	
}
