package com.niupi.jesa;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/gestorDeApuestas")
public class ApuestasController {
	
	@RequestMapping(value = "/generarApuesta/{juego}", method = RequestMethod.GET)
	public String generarApuesta(@PathVariable String juego, ModelMap model){
		Juego j = new Juego();
		String apuesta = j.generarApuesta(juego.toUpperCase());
		model.addAttribute("apuesta", apuesta);
		return "/gestorDeApuestas";
	}
}
