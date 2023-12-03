package edu.ucaldas.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * Clase Album, representa un album de una banda.
 * 
 * @author MJP
 * @version 1.0
 */
public class Album {

    private String nombre;
    private LocalDate fechaLanzamiento;
    private List<Cancion> cancionesAlbum;

    public Album(String nombre, LocalDate fechaLanzamiento) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Album(String nombre, LocalDate fechaLanzamiento, List<Cancion> cancionesAlbum) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.cancionesAlbum = cancionesAlbum;
    }

    public Album() {
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public List<Cancion> getCancionesAlbum() {
        return cancionesAlbum;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setCancionesAlbum(List<Cancion> cancionesAlbum) {
        this.cancionesAlbum = cancionesAlbum;
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

        return nombre.equals(other.nombre) && fechaLanzamiento.equals(other.fechaLanzamiento)
                && cancionesAlbum.equals(other.cancionesAlbum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaLanzamiento, cancionesAlbum);
    }

    @Override
    public String toString() {
        return "Album [nombre=" + nombre + ", fechaLanzamiento=" + fechaLanzamiento + ", cancionesAlbum="
                + cancionesAlbum + "]";
    }

}
