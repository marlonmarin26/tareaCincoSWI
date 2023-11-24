package edu.ucaldas.controllers;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import edu.ucaldas.model.Banda;
import edu.ucaldas.model.Foto;
import java.util.List;

import edu.ucaldas.model.Banda;
import edu.ucaldas.model.Miembro;
import edu.ucaldas.model.Rol;

public class ControlBanda {
    private Banda banda;
    
    public ControlBanda(Banda banda) {
        this.banda = banda;
    }
    public ControlBanda (){
        this.banda = new Banda("", null, null, null);
    }
    /*
     * método para agregar miembros a la banda
     */
    public void agregarMiembro(Miembro miembrp) {
        try {
            Miembro miembro = new Miembro();
            Miembro miembroAgregar = miembro.buscarMiembro(miembro);
            Banda banda = new Banda();
            banda.adicionarMiembro(miembroAgregar);
            
        } catch (MiembroExcepcion e) {

        }

    }

    public void eliminarMiembro(Miembro miembro) {
        try {
            Miembro miembroEliminar = new Miembro();
            Miembro miembroEliminado = miembroEliminar.buscarMiembro(miembro);
            Banda banda = new Banda();
            miembroEliminado.eliminarMiembro(miembroEliminado);
            banda.eliminarMiembro(miembroEliminado);
        } catch (MiembroExcepcion e) {
        // code for removing a member from the band
    }

    public void crearActualizarBanda(String genero, LocalDate fechaCreacion, List<Foto> fotos, List<Miembro> miembros) {
        if (banda == null) {
            banda = new Banda(genero, fechaCreacion, fotos, miembros);
        } else {
            banda.setGenero(genero);
            banda.setFechaCreacion(fechaCreacion);
            banda.setFotos(fotos);
            banda.setMiembros(miembros);
        }
    }

    public void datosCrearBanda(){
        Scanner scanner = new Scanner(System.in);

        //crear o actualizar banda
        System.out.print("Ingrese el genero de la banda: ");
        String genero = scanner.nextLine();
        LocalDate fechaCreacion = LocalDate.now();
        List<Foto> fotos = new ArrayList<Foto>();
        JFrame frame = new JFrame(); // Crear un objeto JFrame (ventana)
        JFileChooser fileChooser = new JFileChooser(); // Crear un objeto JFileChooser
        fileChooser.setMultiSelectionEnabled(true); // Permitir selección múltiple
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivos de texto", "txt"); // Filtro para mostrar solo archivos de texto
        fileChooser.setFileFilter(filter);
        int result = fileChooser.showOpenDialog(frame); // Mostrar el cuadro de diálogo de selección de archivos
        if (result == JFileChooser.APPROVE_OPTION) {
            File[] selectedFiles = fileChooser.getSelectedFiles(); // Obtener los archivos seleccionados
            for (File file : selectedFiles) {
                Foto foto = new Foto(file.toURI().toString());
                fotos.add(foto);
            }
        } else {
            System.out.println("Operación cancelada por el usuario.");
        }
        List<Miembro> miembros = new ArrayList<Miembro>();
        boolean continuarIngresando = true;

        while (continuarIngresando) {
            System.out.print("Ingresa un string: ");
            System.out.print("Ingrese el nombre del miembro: ");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese el rol del miembro: ");
            String rolMiembro = scanner.nextLine().toUpperCase();
            Rol rol = Rol.valueOf(rolMiembro);
            System.out.println("Ingrese el instrumento que utiliza el miembro: ");
            String instrumentos = scanner.nextLine();
            Miembro miembro = new Miembro(nombre, rol, instrumentos);
            miembros.add(miembro);
            System.out.print("¿Quieres ingresar otro miembro? (Si/No): "); // Preguntar al usuario si desea ingresar más miembros
            String respuesta = scanner.nextLine().toLowerCase();
            continuarIngresando = respuesta.equals("si"); // Si la respuesta no es "sí" sale del bucle
        }
        scanner.close();
        crearActualizarBanda(genero, fechaCreacion, fotos, miembros);
        }
    }

}
