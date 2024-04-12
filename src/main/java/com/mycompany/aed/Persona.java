package com.mycompany.aed;

public class Persona {
    private String dni;
    private String nombre;
    private String celular;

    public Persona(String dni, String nombre, String celular) {
        this.dni = dni;
        this.nombre = nombre;
        this.celular = celular;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", celular='" + celular + '\'' +
                '}';
    }
}
