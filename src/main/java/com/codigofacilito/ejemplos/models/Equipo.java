package com.codigofacilito.ejemplos.models;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

	private String nombreEquipo;
	private List<Jugador> listJugadores;
	
	
	//Método constructor por defecto para inicializar la lista
	public Equipo() {		
		listJugadores = new ArrayList();
	}
	
	//Método público que no retorna nada para agregar jugadores a la lista 
	public void addJugador(Jugador jugador) {
		listJugadores.add(jugador);
	}

	public String getNombreEquipo() {
		return nombreEquipo;
	}

	public void setNombreEquipo(String nombreEquipo) {
		this.nombreEquipo = nombreEquipo;
	}

	public List<Jugador> getListJugadores() {
		return listJugadores;
	}

	public void setListJugadores(List<Jugador> listJugadores) {
		this.listJugadores = listJugadores;
	}

}
