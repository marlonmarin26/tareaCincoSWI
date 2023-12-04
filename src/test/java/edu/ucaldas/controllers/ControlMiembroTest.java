package edu.ucaldas.controllers;

import org.junit.jupiter.api.Test;

public class ControlMiembroTest {
    @Test
    void testCrearMiembros() {
        ControlMiembro controlMiembro = new ControlMiembro();
        controlMiembro.crearMiembros();
        assert controlMiembro.getListaMiembros().size() == 12;
    }
}
