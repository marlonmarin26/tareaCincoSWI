package edu.ucaldas.model;


/**
 * Clase Miembro, representa a un miembro de la banda.
 */
public class Miembro {

    private String nombre;
    private String rol;
    private String instrumentos;

    public Miembro(String nombre, String rol, String instrumentos) {
        this.nombre = nombre;
        this.rol = rol;
        this.instrumentos = instrumentos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRol() {
        return rol;
    }

    public String getInstrumentos() {
        return instrumentos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void setInstrumentos(String instrumentos) {
        this.instrumentos = instrumentos;
    }

    @Override
    public String toString() {
        return "Miembro [nombre=" + nombre + ", rol=" + rol + ", instrumentos=" + instrumentos + "]";
    }

}
