package com.codigofacilito.ejemplos.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.codigofacilito.ejemplos.models.Equipo;
import com.codigofacilito.ejemplos.models.Jugador;
import com.codigofacilito.ejemplos.services.EquipoService;
import com.codigofacilito.ejemplos.services.IService;

@Controller
public class ParametrosController {
	
	@Autowired
	IService equipoService; //Reemplazamos el EquipoService equipoService (concreto) por la interfaz (IService)
	
	/*Generamos una instancia de EquipoService:	
	EquipoService equipoService = new EquipoService(); //si en un futuro necesito realizar una implementación diferente de EquipoService,
	//por ej: puedo llegar a necesitar los equipos de otra liga, en todos los lugares donde haya utilizado EquipoService tendria que modificar
	//EquipoService por EquipoInglesaService. Esto nos genera un problema de mantenimiento y queda muy acoplado al código.
	*/
	
	@GetMapping(value="/parametros")
	public String parametros(@RequestParam(defaultValue = "valor default") String valor, 
			@RequestParam(defaultValue = "", name = "valor_dos") String otroValor, Model model) {
		//http://localhost:8080/parametros --> va a tomar el default value
		//http://localhost:8080/parametros?valor=este%20es%20mi%20parametro
		//http://localhost:8080/parametros?valor=este%20es%20mi%20parametro&valor_dos=este%20es%20mi%20otro%20par%C3%A1metro
		model.addAttribute("titulo", "Parámetros"); //barra de titulo
		model.addAttribute("parametro_uno", valor); //se lo enviamos a la etiqueta <span th:text="${parametro_uno}"></span>
		model.addAttribute("parametro_dos", otroValor); //se lo enviamos a la etiqueta <span th:text="${parametro_dos}"></span>
		return "parametros"; //nombre de la vista que se renderizará, utilizando los atributos del modelo para influir en su presentación.
	}
	
	//http://localhost:8080/equipos/JUVENTUS/10
	//http://localhost:8080/equipos/BARCELONA/4
	@GetMapping(value="/equipos/{nombre_equipo}/{numero_jugador}")
	public String parametrosPorPath(@PathVariable String nombre_equipo, 
									@PathVariable("numero_jugador") Integer numero_jugador, Model model ) {
		
		//Realizamos la búsqueda del equipo a partir de los parámetros recibidos por path:
		Optional<Equipo> equipoOptional = equipoService.getAllEquipos().stream()
				.filter(equipo -> nombre_equipo.toLowerCase().equals(equipo.getNombreEquipo().toLowerCase())) //filtramos por equipo, donde-> nombre_equipo.equals(equipo.getNombreEquipo())
				.findFirst(); //de este filtrado solamente obteneme el primero
		
		//En este punto ya sabemos que existe el Equipo y ahora necesitamos saber si existe un jugador en la lista filtrada "equipoOptional" con el número que pasemos por url
		if(equipoOptional.isPresent()) { //validamos que no haya equipos nulos
			Optional<Jugador> jugadorOptional = equipoOptional.get().getListJugadores().stream()
					.filter(jugador -> numero_jugador == jugador.getNumero()) //donde jugador-> tenga el mismo numero_jugador que jugador.getNumero()..para encontrar el jugador en la lista filtrada "equipoOptional"
					.findFirst(); //de este filtrado solamente obteneme el primero
			
			model.addAttribute("equipo", equipoOptional.get()); //Le seteamos al objeto Model el objeto Equipo.
			
			//Chequeamos como antes que la lista filtrada "jugadorOptional" no venga nula
			//y en este punto ya sabemos que existe el Jugador:
			if(jugadorOptional.isPresent()) {
				//Por lo tanto al objeto Model ya le podemos setear el objeto Jugador:
				model.addAttribute("jugador", jugadorOptional.get());
			}
		} 
		
		return "parametros"; //devolvemos la vista parametros.html
	}
		
	
	//Método auxiliar para generar una lista de equipos con algunos jugadores dentro para luego utilizarlo p/realzar la búsqueda
	//Lo pasamos a la clase EquipoSerivce
	/*private List<Equipo> getEquipos(){
		Equipo barcelona = new Equipo();
		barcelona.setNombreEquipo("Barcelona");
		barcelona.addJugador(new Jugador("TER STEGEN", 1)); //acá usamos el constructor de Jugador que ya recibe un nombre y un número
		barcelona.addJugador(new Jugador("ARAUJO", 4));
		barcelona.addJugador(new Jugador("BUSQUETS", 5));
		barcelona.addJugador(new Jugador("LEWANDOSKI", 9));
		barcelona.addJugador(new Jugador("DEMBELE", 7));
		
		Equipo juventus = new Equipo();
		juventus.setNombreEquipo("Juventus");
		juventus.addJugador(new Jugador("CHIELLINI", 3)); //acá usamos el constructor de Jugador que ya recibe un nombre y un número
		juventus.addJugador(new Jugador("POGBA", 6));
		juventus.addJugador(new Jugador("DYBALA", 10));
		juventus.addJugador(new Jugador("BARZAGLI", 15));
		juventus.addJugador(new Jugador("BONUCCI", 19));
				
		
		return List.of(barcelona, juventus);
	}*/
	
}
