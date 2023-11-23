package edu.ucaldas.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

/**
 * Clase Concierto, representa un concierto de una banda.
 */
public class Concierto {

    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private LocalTime hora;
    private int capacidad;
    private int boletasVendidas;

    public Concierto(String nombre, LocalDate fecha, String lugar, LocalTime hora, int capacidad,
            int boletasVendidas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.lugar = lugar;
        this.hora = hora;
        this.capacidad = capacidad;
        this.boletasVendidas = boletasVendidas;
    }

    public Concierto() {
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public LocalTime getHora() {
        return hora;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public int getBoletasVendidas() {
        return boletasVendidas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public void setBoletasVendidas(int boletasVendidas) {
        this.boletasVendidas = boletasVendidas;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Concierto other = (Concierto) obj;

        return nombre.equals(other.nombre)
                && fecha.equals(other.fecha)
                && lugar.equals(other.lugar)
                && hora.equals(other.hora)
                && capacidad == other.capacidad
                && boletasVendidas == other.boletasVendidas;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fecha, lugar, hora, capacidad, boletasVendidas);
    }

    @Override
    public String toString() {
        return "Concierto [nombre=" + nombre + ", fecha=" + fecha + ", lugar=" + lugar + ", hora=" + hora
                + ", capacidad=" + capacidad + ", boletasVendidas=" + boletasVendidas + "]";
    }
}
