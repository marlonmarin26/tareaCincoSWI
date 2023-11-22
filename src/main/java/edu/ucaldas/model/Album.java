package edu.ucaldas.model;

import java.time.LocalDate;

/**
 * Clase Album, representa un album de una banda.
 */
public class Album {

    private String nombre;
    private LocalDate fechaLanzamiento;

    public Album(String nombre, LocalDate fechaLanzamiento) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Album() {
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    @Override
    public String toString() {
        return "Album [nombre=" + nombre + ", fechaLanzamiento=" + fechaLanzamiento + "]";
    }

}
