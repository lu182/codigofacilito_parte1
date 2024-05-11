package com.codigofacilito.ejemplos.services;

import java.util.List;

import com.codigofacilito.ejemplos.models.Equipo;
import com.codigofacilito.ejemplos.models.Jugador;

public class EquipoService {

	public List<Equipo> getAllEquipos(){ //Este método podria haber ido a algún archivo a buscar la misma info, se puede traer desde 
		//una Api, desde una BD, podria tener lógica combinada: parte de un archivo y parte de una Api, etc.
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
	}
}
