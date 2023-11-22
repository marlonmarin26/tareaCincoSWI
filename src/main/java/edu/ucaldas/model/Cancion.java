package edu.ucaldas.model;

/**
 * Clase Cancion, representa una cancion de un album.
 */
public class Cancion {

    private String nombre;
    private String duracion;

    public Cancion(String nombre, String duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }

    public Cancion() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    @Override
    public String toString() {
        return "Cancion [nombre=" + nombre + ", duracion=" + duracion + "]";
    }

}
