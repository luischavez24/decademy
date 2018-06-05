package com.guis.decademy.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewNames;

@Controller
@RequestMapping("")
public class HomeController {
	
	private static final Log LOG = LogFactory.getLog(HomeController.class);
	
	@GetMapping("")
	public String index (Model model) {
		LOG.info("[index]: Pagina devuelta => /index");
		return ViewNames.HOME_INDEX;
	}
}
