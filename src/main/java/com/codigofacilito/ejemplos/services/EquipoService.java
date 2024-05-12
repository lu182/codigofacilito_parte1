package com.codigofacilito.ejemplos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.codigofacilito.ejemplos.models.Equipo;
import com.codigofacilito.ejemplos.models.Jugador;

@Service("equiposItalia") //Alias para llamar este Servicio en la anotación @Qualifier de ParametroController
public class EquipoService implements IService{

	public List<Equipo> getAllEquipos(){ //Este método podria haber ido a algún archivo a buscar la misma info, se puede traer desde 
		//una Api, desde una BD, podria tener lógica combinada: parte de un archivo y parte de una Api, etc.
		Equipo interDeMilan = new Equipo();
		interDeMilan.setNombreEquipo("InterDeMilan"); // http://localhost:8080/equipos/InterDeMilan/10
		interDeMilan.addJugador(new Jugador("MARTINEZ", 10)); //acá usamos el constructor de Jugador que ya recibe un nombre y un número
		interDeMilan.addJugador(new Jugador("SÁNCHEZ", 70));
		interDeMilan.addJugador(new Jugador("THURAM", 9));
		interDeMilan.addJugador(new Jugador("ACERBI", 15));
		interDeMilan.addJugador(new Jugador("PAVARD", 28));
		
		Equipo juventus = new Equipo();
		juventus.setNombreEquipo("Juventus"); // http://localhost:8080/equipos/JUVENTUS/10
		juventus.addJugador(new Jugador("CHIELLINI", 3)); //acá usamos el constructor de Jugador que ya recibe un nombre y un número
		juventus.addJugador(new Jugador("POGBA", 6));
		juventus.addJugador(new Jugador("DYBALA", 10));
		juventus.addJugador(new Jugador("BARZAGLI", 15));
		juventus.addJugador(new Jugador("BONUCCI", 19));
				
		
		return List.of(interDeMilan, juventus);
	}
}
