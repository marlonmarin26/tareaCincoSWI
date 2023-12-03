package edu.ucaldas.controllers;

import java.util.List;
import java.util.Scanner;

import edu.ucaldas.model.Banda;
import edu.ucaldas.model.Foto;
import edu.ucaldas.model.Miembro;

import java.util.ArrayList;
import java.time.LocalDate;

/**
 * Controlador para realizar operaciones referidas a la banda ROCK&CODE.
 * 
 * @author MJP
 * @version 1.0
 */
public class ControlBanda {
    private Banda banda = new Banda();
    private static List<Foto> listaFotos = new ArrayList<>();

    /**
     * Obtiene la lista de fotos disponibles para agregar a la banda.
     * 
     * @return Lista de fotos disponibles.
     */
    public static List<Foto> getListaFotos() {
        return listaFotos;
    }

    /**
     * Crea fotos por defecto para luego añadirlas a la banda.
     */
    public void crearFotos() {
        Foto foto = new Foto("foto_1.jpg");
        Foto foto2 = new Foto("foto_2.jpg");
        Foto foto3 = new Foto("foto_3.jpg");

        listaFotos.add(foto);
        listaFotos.add(foto2);
        listaFotos.add(foto3);
    }

    /**
     * Registra la banda ROCK&CODE con datos de prueba.
     */
    public void registrarBanda() {
        // Datos de la banda (género, fecha de creación, fotos)
        String genero = "Rock";
        LocalDate fechaCreacion = LocalDate.of(2020, 1, 1);

        crearFotos();
        // Lista de fotos
        List<Foto> fotos = new ArrayList<>();
        fotos.add(new Foto("ruta_foto_1.jpg"));
        fotos.add(new Foto("ruta_foto_2.jpg"));

        // Crear o actualizar banda sin miembros
        if (banda == null) {
            banda = new Banda(genero, fechaCreacion, fotos);
        } else {
            banda.setGenero(genero);
            banda.setFechaCreacion(fechaCreacion);
            banda.setFotos(fotos);
        }

        System.out.println("Banda ROCK&CODE registrada exitosamente.");
    }

    /**
     * Muestra la información de la banda ROCK&CODE.
     */
    public void mostrarBanda() {
        if (banda != null) {
            System.out.println("Información de la banda ROCK&CODE:");
            System.out.println("Género: " + banda.getGenero());
            System.out.println("Fecha de creación: " + banda.getFechaCreacion());

            List<Foto> fotos = banda.getFotos();
            if (!fotos.isEmpty()) {
                System.out.println("Fotos de la banda:");
                for (Foto foto : fotos) {
                    System.out.println("- " + foto.getUrl());
                }
            } else {
                System.out.println("La banda no tiene fotos registradas.");
            }

            List<Miembro> miembros = banda.getMiembros();
            if (!miembros.isEmpty()) {
                System.out.println("Miembros de la banda:");
                for (Miembro miembro : miembros) {
                    System.out.println("- " + miembro.getNombre() + " (Rol: " + miembro.getRol() + ")");
                }
            } else {
                System.out.println("La banda no tiene miembros registrados.");
            }
        } else {
            System.out.println("No hay información de la banda para mostrar.");
        }
    }

    /**
     * Permite actualizar la información de la banda ROCK&CODE, incluyendo su
     * género,
     * fecha de creación y fotos. Solicita al usuario ingresar los nuevos datos y
     * los
     * asigna a la banda si existe. En caso de no existir una banda, muestra un
     * mensaje
     * indicando que primero se debe registrar una banda.
     */
    public void actualizarBanda() {
        // Verificar si la banda ya ha sido registrada
        if (banda != null) {
            Scanner scanner = new Scanner(System.in);

            // Mostrar información actual de la banda
            System.out.println("Información actual de la banda:");
            System.out.println("Género: " + banda.getGenero());
            System.out.println("Fecha de creación: " + banda.getFechaCreacion());
            System.out.println("Fotos: " + banda.getFotos());

            // Actualizar el género de la banda
            System.out.print("\nIngrese el nuevo género de la banda: ");
            String nuevoGenero = scanner.nextLine();
            banda.setGenero(nuevoGenero);

            // Actualizar la fecha de creación de la banda
            System.out.print("Ingrese la nueva fecha de creación de la banda (formato YYYY-MM-DD): ");
            String nuevaFechaString = scanner.nextLine();
            LocalDate nuevaFechaCreacion = LocalDate.parse(nuevaFechaString);
            banda.setFechaCreacion(nuevaFechaCreacion);

            // Actualizar las fotos de la banda
            agregarFotoBanda();

            System.out.println("Banda actualizada exitosamente.");
        } else {
            // Mostrar mensaje si no hay una banda registrada
            System.out.println("No hay una banda para actualizar. Registre una banda primero.");
        }
    }

    /**
     * Permite al usuario seleccionar una o varias fotos mediante una lista de
     * de fotos.
     */
    public void agregarFotoBanda() {
        if (banda.getGenero() != null) {
            Scanner scanner = new Scanner(System.in);

            // Mostrar la lista de miembros disponibles
            System.out.println("Lista de fotos disponibles:");
            for (int i = 0; i < ControlBanda.getListaFotos().size(); i++) {
                System.out.println((i + 1) + ". " + ControlBanda.getListaFotos().get(i).getUrl());
            }

            boolean deseaAgregarMas = true;

            do {
                // Solicitar al usuario que seleccione un miembro
                System.out.print("Seleccione el número de la foto que desea agregar a la banda (o 0 para salir): ");
                int indiceFotoSeleccionado = scanner.nextInt();

                // Verificar si el índice seleccionado es válido
                if (indiceFotoSeleccionado >= 1
                        && indiceFotoSeleccionado <= ControlBanda.getListaFotos().size()) {
                    Foto fotoSeleccionado = ControlBanda.getListaFotos().get(indiceFotoSeleccionado - 1);

                    // Verificar si la foto ya está en la banda
                    if (!banda.getFotos().contains(fotoSeleccionado)) {
                        banda.getFotos().add(fotoSeleccionado);
                        System.out.println("Foto agregada a la banda exitosamente.");
                    } else {
                        System.out.println("La foto ya está en la banda.");
                    }
                } else if (indiceFotoSeleccionado != 0) {
                    System.out.println("Número de foto no válido.");
                }

                // Preguntar si desea agregar más fotos
                System.out.print("¿Desea agregar más fotos a la banda? (Sí/No): ");
                String respuesta = scanner.next().toLowerCase();
                deseaAgregarMas = respuesta.equals("si") || respuesta.equals("sí");
            } while (deseaAgregarMas);

            System.out.println("Operación de agregar fotos a la banda completada.");
        } else {
            System.out.println("No hay una banda registrada. Registre una primero");
        }
    }

    /**
     * Permite agregar miembros a la banda seleccionada, mostrando y seleccionando
     * de una lista de miembros disponibles.
     * La operación es repetida según la decisión del usuario. Se
     * valida la existencia de la banda antes de proceder.
     */
    public void agregarMiembroBanda() {
        if (banda.getGenero() != null) {
            Scanner scanner = new Scanner(System.in);

            // Mostrar la lista de miembros disponibles
            System.out.println("Lista de miembros disponibles:");
            for (int i = 0; i < ControlMiembro.getListaMiembros().size(); i++) {
                System.out.println((i + 1) + ". " + ControlMiembro.getListaMiembros().get(i).getNombre());
            }

            boolean deseaAgregarMas = true;

            do {
                // Solicitar al usuario que seleccione un miembro
                System.out.print("Seleccione el número del miembro que desea agregar a la banda (o 0 para salir): ");
                int indiceMiembroSeleccionado = scanner.nextInt();

                // Verificar si el índice seleccionado es válido
                if (indiceMiembroSeleccionado >= 1
                        && indiceMiembroSeleccionado <= ControlMiembro.getListaMiembros().size()) {
                    Miembro miembroSeleccionado = ControlMiembro.getListaMiembros().get(indiceMiembroSeleccionado - 1);

                    // Verificar si el miembro ya está en la banda
                    if (!banda.getMiembros().contains(miembroSeleccionado)) {
                        banda.getMiembros().add(miembroSeleccionado);
                        System.out.println("Miembro agregado a la banda exitosamente.");
                    } else {
                        System.out.println("El miembro ya está en la banda.");
                    }
                } else if (indiceMiembroSeleccionado != 0) {
                    System.out.println("Número de miembro no válido.");
                }

                // Preguntar si desea agregar más miembros
                System.out.print("¿Desea agregar más miembros a la banda? (Sí/No): ");
                String respuesta = scanner.next().toLowerCase();
                deseaAgregarMas = respuesta.equals("si") || respuesta.equals("sí");
            } while (deseaAgregarMas);

            System.out.println("Operación de agregar miembros a la banda completada.");
        } else {
            System.out.println("No hay una banda registrada. Registre una banda primero.");
        }
    }

    /**
     * Permite al usuario eliminar miembros de la banda seleccionada. Muestra la
     * lista de miembros en la banda, permite seleccionar miembros para eliminar y
     * solicita confirmación después de cada eliminación.
     * La operación se repite hasta que el usuario elige no eliminar más miembros.
     * Muestra un mensaje si la banda no está registrada.
     */
    public void eliminarMiembroBanda() {
        if (banda != null) {
            Scanner scanner = new Scanner(System.in);

            // Mostrar la lista de miembros en la banda
            System.out.println("Lista de miembros en la banda:");
            List<Miembro> miembrosBanda = banda.getMiembros();
            for (int i = 0; i < miembrosBanda.size(); i++) {
                System.out.println((i + 1) + ". " + miembrosBanda.get(i).getNombre());
            }

            boolean deseaEliminarMas = true;

            do {
                // Solicitar al usuario que seleccione un miembro para eliminar
                System.out.print("Seleccione el número del miembro que desea eliminar de la banda (o 0 para salir): ");
                int indiceMiembroSeleccionado = scanner.nextInt();

                // Verificar si el índice seleccionado es válido
                if (indiceMiembroSeleccionado >= 1 && indiceMiembroSeleccionado <= miembrosBanda.size()) {
                    Miembro miembroSeleccionado = miembrosBanda.get(indiceMiembroSeleccionado - 1);

                    // Verificar si el miembro está en la banda
                    if (banda.getMiembros().contains(miembroSeleccionado)) {
                        banda.getMiembros().remove(miembroSeleccionado);
                        System.out.println("Miembro eliminado de la banda exitosamente.");
                    } else {
                        System.out.println("El miembro no está en la banda.");
                    }
                } else if (indiceMiembroSeleccionado != 0) {
                    System.out.println("Número de miembro no válido.");
                }

                // Preguntar si desea eliminar más miembros
                System.out.print("¿Desea eliminar más miembros de la banda? (Sí/No): ");
                String respuesta = scanner.next().toLowerCase();
                deseaEliminarMas = respuesta.equals("si") || respuesta.equals("sí");
            } while (deseaEliminarMas);

            System.out.println("Operación de eliminar miembros de la banda completada.");
        } else {
            System.out.println("No hay una banda registrada. Registre una banda primero.");
        }
    }

}