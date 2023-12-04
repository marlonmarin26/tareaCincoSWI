package edu.ucaldas.controllers;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalTime;

import org.junit.jupiter.api.Test;

public class ControlConciertoTest {
    @Test
    void testProgramarConcierto() {
        String input = "Concierto de prueba\n2021-10-10\nLugar de prueba\n20:00\n100\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ControlConcierto controlConcierto = new ControlConcierto();
        controlConcierto.programarConcierto();
        assert controlConcierto.getConciertos().size() == 1;
        assert controlConcierto.getConciertos().get(0).getNombre().equals("Concierto de prueba");
        assert controlConcierto.getConciertos().get(0).getFecha().equals(LocalDate.parse("2021-10-10"));
        assert controlConcierto.getConciertos().get(0).getLugar().equals("Lugar de prueba");
        assert controlConcierto.getConciertos().get(0).getHora().equals(LocalTime.parse("20:00"));
        assert controlConcierto.getConciertos().get(0).getCapacidad() == 100;
    }

    @Test
    void testBuscarConciertoPorNombre(){
        String input = "Concierto de prueba\n2021-10-10\nLugar de prueba\n20:00\n100\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        ControlConcierto controlConcierto = new ControlConcierto();
        controlConcierto.programarConcierto();
        assert controlConcierto.buscarConciertoPorNombre("Concierto de prueba").getNombre().equals("Concierto de prueba");
    }
}
