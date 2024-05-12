package com.codigofacilito.ejemplos.services;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.codigofacilito.ejemplos.models.Equipo;
import com.codigofacilito.ejemplos.models.Jugador;

@Service
@Primary
public class EquipoInglaterraService implements IService {

	@Override
	public List<Equipo> getAllEquipos() {
		
		Equipo manchesterUnited = new Equipo();
		manchesterUnited.setNombreEquipo("ManchesterUnited"); // http://localhost:8080/equipos/ManchesterUnited/49
		manchesterUnited.addJugador(new Jugador("GARNACHO", 49)); 		
		
		Equipo manchesterCity = new Equipo();
		manchesterCity.setNombreEquipo("ManchesterCity"); // http://localhost:8080/equipos/MANCHESTERCITY/9
		manchesterCity.addJugador(new Jugador("J ALVAREZ", 9)); 	
						
		return List.of(manchesterUnited, manchesterCity);
	}

}
