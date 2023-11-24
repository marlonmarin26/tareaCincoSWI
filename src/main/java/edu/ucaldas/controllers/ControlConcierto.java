package edu.ucaldas.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import edu.ucaldas.model.Concierto;

public class ControlConcierto {

    private List<Concierto> conciertos;

    public ControlConcierto() {
        this.conciertos = new ArrayList<>();
    }

    public void agregarConcierto(String nombre, LocalDate fecha, String lugar, LocalTime hora,
            int capacidad, int boletasVendidas) {

        Concierto nuevoConcierto = new Concierto(nombre, fecha, lugar, hora, capacidad, boletasVendidas, null);

        conciertos.add(nuevoConcierto);
    }

    



}
