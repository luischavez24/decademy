package com.guis.decademy.controllers;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;

@Controller
@RequestMapping("/retos")
public class RetosController {
	private static final Log LOG = LogFactory.getLog(RetosController.class);
	
	@GetMapping("/")
	public String retos(Model model) {
		LOG.info("[retos]: Pagina devuelta => /retos/");
		return ViewConstants.RETOS_1;
	}

}
