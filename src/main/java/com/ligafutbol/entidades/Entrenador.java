package com.ligafutbol.entidades;

public class Entrenador extends Persona {
    private int idFedaracion;

    public Entrenador(){
        super();
    }

    public Entrenador(int idFedaracion) {
        this.idFedaracion = idFedaracion;
    }

    public Entrenador(int id, String nombre, String apellido, int edad, int idFedaracion) {
        super(id, nombre, apellido, edad);
        this.idFedaracion = idFedaracion;
    }

    public int getIdFedaracion() {
        return idFedaracion;
    }

    public void setIdFedaracion(int idFedaracion) {
        this.idFedaracion = idFedaracion;
    }
}
