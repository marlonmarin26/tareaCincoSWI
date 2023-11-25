package edu.ucaldas.controllers;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CountDownLatch;
import javax.swing.SwingWorker;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import edu.ucaldas.model.Banda;
import edu.ucaldas.model.Foto;
import edu.ucaldas.model.Miembro;

import java.util.ArrayList;
import java.io.File;
import java.time.LocalDate;

public class ControlBanda {
    private static CountDownLatch latch = new CountDownLatch(1);
    private static Banda banda = new Banda();

    /**
     * Registra la banda ROCK&CODE con datos de prueba.
     */
    public void registrarBanda() {
        // Datos de la banda (género, fecha de creación, fotos)
        String genero = "Rock";
        LocalDate fechaCreacion = LocalDate.of(2020, 1, 1);

        // Lista de fotos
        List<Foto> fotos = new ArrayList<>();
        fotos.add(new Foto("ruta_foto_1.jpg"));
        fotos.add(new Foto("ruta_foto_2.jpg"));
        // Agrega más fotos según sea necesario

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
            List<Foto> nuevasFotos = seleccionarFotos();
            banda.setFotos(nuevasFotos);

            System.out.println("Banda actualizada exitosamente.");
        } else {
            // Mostrar mensaje si no hay una banda registrada
            System.out.println("No hay una banda para actualizar. Registre una banda primero.");
        }
    }

    /**
     * Permite al usuario seleccionar una o varias fotos mediante un cuadro de
     * diálogo de selección
     * de archivos. Las fotos seleccionadas se devuelven como una lista de objetos
     * de la clase Foto.
     * Utiliza un hilo de ejecución SwingWorker para realizar la operación de
     * selección de fotos de
     * forma asíncrona y evita bloquear la interfaz de usuario durante la selección.
     *
     * @return Lista de fotos seleccionadas por el usuario.
     */
    public List<Foto> seleccionarFotos() {
        List<Foto> fotosSeleccionadas = new ArrayList<>();

        // Crear un SwingWorker para manejar la operación asíncrona
        SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                JFrame frame = new JFrame();
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setMultiSelectionEnabled(true);
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de imagen", "jpg", "png",
                        "jpeg");
                fileChooser.setFileFilter(filter);
                int result = fileChooser.showOpenDialog(frame);

                // Procesar los archivos seleccionados
                if (result == JFileChooser.APPROVE_OPTION) {
                    File[] selectedFiles = fileChooser.getSelectedFiles();
                    for (File file : selectedFiles) {
                        // Crear un objeto Foto con la URL del archivo seleccionado
                        Foto foto = new Foto(file.toURI().toString());
                        fotosSeleccionadas.add(foto);
                    }
                } else {
                    System.out.println("Operación cancelada por el usuario.");
                }

                // Cerrar el frame después de seleccionar las fotos
                frame.dispose();

                return null;
            }

            @Override
            protected void done() {
                // Contar el latch para indicar que la operación está completa
                latch.countDown();
            }
        };

        // Ejecutar el SwingWorker
        worker.execute();

        // Esperar a que la operación asíncrona se complete
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return fotosSeleccionadas;
    }

    /**
     * Permite agregar miembros a la banda seleccionada, mostrando y seleccionando
     * de una lista de miembros
     * disponibles. La operación es repetida según la decisión del usuario. Se
     * valida la existencia de la banda
     * antes de proceder.
     */
    public void agregarMiembroBanda() {
        if (banda != null) {
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
     * lista de miembros en la
     * banda, permite seleccionar miembros para eliminar y solicita confirmación
     * después de cada eliminación.
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
