package edu.ucaldas.model;

import java.time.LocalDate;
import java.util.Objects;

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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Album other = (Album) obj;

        return nombre.equals(other.nombre) && fechaLanzamiento.equals(other.fechaLanzamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaLanzamiento);
    }

    @Override
    public String toString() {
        return "Album [nombre=" + nombre + ", fechaLanzamiento=" + fechaLanzamiento + "]";
    }

}
