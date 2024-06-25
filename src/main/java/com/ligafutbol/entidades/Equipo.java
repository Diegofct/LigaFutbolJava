package com.ligafutbol.entidades;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    private String nombre;
    private String ciudad;
    private List<Jugador> lstJugadores;
    private List<Doctor> lstMasajistas;
    private List<Entrenador> lstEntrenadores;
    
    public Equipo() {
        lstEntrenadores = new ArrayList<Entrenador>();
        lstJugadores = new ArrayList<Jugador>();
        lstMasajistas = new ArrayList<Doctor>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public List<Jugador> getLstJugadores() {
        return lstJugadores;
    }

    public void setLstJugadores(Jugador jugador ) {
        this.lstJugadores.add(jugador);
    }

    public List<Doctor> getLstMasajistas() {
        return lstMasajistas;
    }

    public void setLstMasajistas(List<Doctor> lstMasajistas) {
        this.lstMasajistas = lstMasajistas;
    }

    public List<Entrenador> getLstEntrenadores() {
        return lstEntrenadores;
    }

    public void setLstEntrenadores(List<Entrenador> lstEntrenadores) {
        this.lstEntrenadores = lstEntrenadores;
    }
}
