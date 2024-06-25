package com.ligafutbol.vistas;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;

import com.ligafutbol.Controller;
import com.ligafutbol.entidades.Doctor;

public class VistaDoctor {
     public static Controller controlador;
    private Scanner scanner;

    public VistaDoctor(Scanner scanner) {
        this.scanner = scanner;
    }

    private void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

     public void start() {
        while (true) {
            limpiarPantalla();
            System.out.println("---------------------------------[Gestión de Masajistas]---------------------------------");
            System.out.println("---------------------------------[Seleccione una opcion]----------------------------------");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("[1] ->                               Crear masajista                                    <-");
            System.out.println("[2] ->                             Actualizar masajista                                 <-");
            System.out.println("[3] ->                               Buscar masajista                                   <-");
            System.out.println("[4] ->                              Eliminar masajista                                  <-");
            System.out.println("[5] ->                          Listar todos los masajistas                             <-");
            System.out.println("[6] ->                                      Salir                                       <-");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.print("[Tu eleccion] -> ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    limpiarPantalla();
                    Doctor masajista = new Doctor();
                    int idMasajista;

                    System.out.print("Ingrese el id del masajista :");
                    idMasajista = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese Nombre del masajista :");
                    masajista.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el apellido del masajista: ");
                    masajista.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la edad del masajista: ");
                    masajista.setEdad(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese el titulo del masajista :");
                    masajista.setTitulo(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la experiencia del masajista :");
                    masajista.setExpYear(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println();

                    controlador.masajistas.put(idMasajista, masajista);
                    System.out.println("Masajista creado con exito");
                    break;

                case 2:
                    limpiarPantalla();
                    Doctor masajistaAct = new Doctor();
                    int idMasajista2;

                    System.out.print("Ingrese el id del masajista: ");
                    idMasajista2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese nuevo nombre del masajista :");
                    masajistaAct.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el nuevo apellido del masajista: ");
                    masajistaAct.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la nueva edad del masajista: ");
                    masajistaAct.setEdad(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese el nuevo titulo del masajista :");
                    masajistaAct.setTitulo(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la nueva experiencia del masajista :");
                    masajistaAct.setExpYear(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println();

                    controlador.masajistas.replace(idMasajista2, masajistaAct);
                    System.out.println("Masajista actualizado con exito");
                    break;

                case 3:
                    limpiarPantalla();
                    int idMasajista3;
                    System.out.print("Ingrese el id del masajista: ");
                    idMasajista3 = scanner.nextInt();
                    if (controlador.masajistas.containsKey(idMasajista3)) {
                        limpiarPantalla();
                        Doctor masajistaEncontrado = controlador.masajistas.get(idMasajista3);
                        System.out.println("+------------|---------------[MASAJISTA ENCONTRADO]-------------------------");
                        System.out.println("| Masajista + " + masajistaEncontrado.getNombre() + " " + masajistaEncontrado.getApellido());
                        System.out.println("+------------|---------------------------------------------------------------");
                    } else {
                        limpiarPantalla();
                        System.out.println("Masajista no encontrado");
                    }
                    break;

                case 4:
                    limpiarPantalla();
                    int idMasajista4;
                    System.out.print("Ingrese el id del masajista que quiere eliminar: ");
                    idMasajista4 = scanner.nextInt();
                    if (controlador.masajistas.containsKey(idMasajista4)) {
                        controlador.masajistas.remove(idMasajista4);
                        System.out.println("Masajista eliminado con exito");
                    } else {
                        System.out.println("No se encontró masajista");
                    }
                    break;

                case 5:
                    limpiarPantalla();
                    System.out.println("---------------------------------[MASAJISTAS]--------------------------------- ");
                    int i = 0;
                    for (Map.Entry<Integer, Doctor> entry : controlador.masajistas.entrySet()) {
                        int idsMasajistas = entry.getKey();
                        Doctor masajistas = entry.getValue();
                        System.out.println(MessageFormat.format("| Masajista {0} | Id: {1} | Nombre: {2} | Apellido: {3} | Titulo: {4} |", i, idsMasajistas, masajistas.getNombre(), masajistas.getApellido(), masajistas.getTitulo()));
                        i++;
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Opción no válida, seleccione una de las 6 opciones");
            }
        }
    }
}
