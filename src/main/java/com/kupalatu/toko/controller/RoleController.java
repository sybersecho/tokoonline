package com.kupalatu.toko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// @RequestMapping("/roles*")
public class RoleController {

	private static Logger logger = LoggerFactory
			.getLogger(RoleController.class);

	@RequestMapping(value = "/roles*", method = RequestMethod.GET)
	public String showRoles(Model model) {
		logger.info("show role page");

		return "role/roles";
	}

	@RequestMapping(value = "/roleform", method = RequestMethod.GET)
	public String showRoleForm(Model model) {
		logger.info("show role form");

		return "role/roleform";
	}

	@RequestMapping(value = "/roleform*", method = RequestMethod.POST)
	public String onSubmit(Model model) {
		logger.info("on submit");
		return "role/roles";
	}
}
