package com.guis.decademy.controllers;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.guis.decademy.constants.ViewConstants;
import com.guis.decademy.entity.Usuario;

@Controller
@RequestMapping("")
public class HomeController {
	
	private static final Log LOG = LogFactory.getLog(HomeController.class);
	
	@Autowired
	@Qualifier("usuarioActual")
	private Usuario usuarioActual;
	
	
	@Autowired
	@Qualifier("usuarios")
	private List<Usuario> usuarios;
	
	@GetMapping("")
	public String index (Model model) {
		model.addAttribute("notLogin", "");
		model.addAttribute("usuario", new Usuario());
		LOG.info("[index]: Pagina devuelta => /index");
		return ViewConstants.HOME_INDEX;
	}
	
	@PostMapping("/login")
	public String login(@ModelAttribute("usuario") Usuario usuario, HttpServletResponse response) {
		
		Optional<Usuario> busq = usuarios.stream().filter(u -> u.getUsername().equals(usuario.getUsername())).findFirst();
		
		if(busq.isPresent()) {
			usuarioActual.setUsername(busq.get().getUsername());
			usuarioActual.setNombres(busq.get().getNombres());
			usuarioActual.setApellidos(busq.get().getApellidos());
			usuarioActual.setPerfil(busq.get().getPerfil());
			response.addCookie(new Cookie("username", usuario.getUsername()));
			return "redirect:/cursos";
		} else {
			return "redirect:/";
		}
		
		
		
	}
}
