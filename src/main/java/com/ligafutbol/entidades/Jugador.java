package com.ligafutbol.entidades;

public class Jugador extends Persona {
    private int dorsal;
    private String posicion;
    
    public Jugador(int id, String nombre, String apellido, int edad, int dorsal, String posicion) {
        super(id, nombre, apellido, edad);
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    public Jugador(int dorsal, String posicion) {
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    public Jugador() {};

    public int getDorsal() {
        return dorsal;
    }

    public void setDorsal(int dorsal) {
        this.dorsal = dorsal;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }
}
