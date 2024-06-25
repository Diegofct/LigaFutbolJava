package com.ligafutbol;

import java.util.Hashtable;

import com.ligafutbol.entidades.Doctor;
import com.ligafutbol.entidades.Entrenador;
import com.ligafutbol.entidades.Equipo;
import com.ligafutbol.entidades.Jugador;

public class Controller {
    public Hashtable <String,Equipo> equipos = new Hashtable<>();
    public Hashtable <Integer,Jugador> jugadores = new Hashtable<>();
    public Hashtable <Integer,Doctor> masajistas = new Hashtable<>();
    public Hashtable <Integer,Entrenador> entrenadores = new Hashtable<>();
}
