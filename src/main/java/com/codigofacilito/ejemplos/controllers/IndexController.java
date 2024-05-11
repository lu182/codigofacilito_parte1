package com.codigofacilito.ejemplos.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IndexController {
	
	//Creamos un método de acción/handler para ejecutar nuestra Vista
	@GetMapping(value="/") //definimos a qué ruta va a ir nuestro navegador
	public String index(Model model) {
		model.addAttribute("titulo", "soy el titulo desde indexController");
		model.addAttribute("saludo", "Holaaaa! desde indexController");
		model.addAttribute("show", false); //para mostrar o no el div en el index
		
		//Creamos una lista de series:
		//List<String> series = List.of("Dexter", "Breaking Bad", "Vikings");
		//model.addAttribute("series", series);		
		
		return "index"; //va a ir a nuestra vista
	}	
	
	@GetMapping(value="/index-mv")
	public ModelAndView indexModelAndView(ModelAndView mv) {
		mv.addObject("titulo", "titulo desde MV");
		mv.addObject("saludo", "Holaaaa desde MV!");
		mv.addObject("show", true);
		//List<String> series = List.of("Dexter", "Breaking Bad", "Vikings");
		//mv.addObject("series", series);
		
		mv.setViewName("index"); //este index seria el reemplazo del original
		
		return mv;
	}
	
	//Método con una lista de más series :
	@ModelAttribute("series") //este objeto lo llamamos en <ul th:each="serie: ${series}">
	public List<String> getSeries(){
		return List.of("Dexter", "Breaking Bad", "Vikings", "The Last Of Us", "Walking Dead");
	}
	
	//Método Post:
	@PostMapping(value = "/index-post")
	public String indexPostMapping() {
		return "index"; //va a ir a nuestra vista
	}

}
