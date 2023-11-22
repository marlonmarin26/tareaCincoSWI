package edu.ucaldas.model;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Clase Concierto, representa un concierto de una banda.
 */
public class Concierto {

    private String nombre;
    private LocalDate fecha;
    private String lugar;
    private LocalTime hora;
    private int capacidad;
    private String boletasVendidas;

    public Concierto(String nombre, LocalDate fecha, String lugar, LocalTime hora, int capacidad,
            String boletasVendidas) {
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

    public String getBoletasVendidas() {
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

    public void setBoletasVendidas(String boletasVendidas) {
        this.boletasVendidas = boletasVendidas;
    }

    @Override
    public String toString() {
        return "Concierto [nombre=" + nombre + ", fecha=" + fecha + ", lugar=" + lugar + ", hora=" + hora
                + ", capacidad=" + capacidad + ", boletasVendidas=" + boletasVendidas + "]";
    }

    
}
