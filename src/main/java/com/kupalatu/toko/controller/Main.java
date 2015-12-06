package com.kupalatu.toko.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Main {

	private static Logger logger = LoggerFactory.getLogger(Main.class);

	@RequestMapping
	public String home() {
		logger.info("home page");
		return "home";
	}
}
