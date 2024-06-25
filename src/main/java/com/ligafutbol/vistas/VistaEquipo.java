package com.ligafutbol.vistas;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;

import com.ligafutbol.Controller;
import com.ligafutbol.entidades.Equipo;

public class VistaEquipo {
    public static Controller controlador;
    private Scanner scanner;

    public VistaEquipo(Scanner scanner) {
        this.scanner = scanner;
    }

    private void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void start() {
        while (true) {
            limpiarPantalla();
            System.out.println("---------------------------------[Gestión de Equipos]---------------------------------");
            System.out.println("---------------------------------[Seleccione una opcion]----------------------------------");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("[1] ->                               Crear Equipo                                       <-");
            System.out.println("[2] ->                             Actualizar Equipo                                    <-");
            System.out.println("[3] ->                               Buscar Equipo                                      <-");
            System.out.println("[4] ->                              Eliminar Equipo                                     <-");
            System.out.println("[5] ->                          Listar todos los Equipos                                <-");
            System.out.println("[6] ->                                   Salir                                          <-");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.print("[Tu eleccion] -> ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    limpiarPantalla();
                    Equipo equipo = new Equipo();
                    String codigoEquipo;

                    System.out.print("Ingrese el codigo del equipo: ");
                    codigoEquipo = scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese Nombre del equipo: ");
                    equipo.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la ciudad: ");
                    equipo.setCiudad(scanner.nextLine());
                    System.out.println();

                    controlador.equipos.put(codigoEquipo, equipo);
                    System.out.println("Equipo creado exitosamente 🎉");
                    break;

                case 2:
                    limpiarPantalla();
                    Equipo equipoAct = new Equipo();
                    String codEquipo2;

                    System.out.print("Ingrese el codigo del equipo: ");
                    codEquipo2 = scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese el nuevo nombre del equipo: ");
                    equipoAct.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la nueva ciudad del equipo: ");
                    equipoAct.setCiudad(scanner.nextLine());
                    System.out.println();

                    controlador.equipos.replace(codEquipo2, equipoAct);
                    System.out.println("Equipo actualizado exitosamente");
                    break;

                case 3:
                    limpiarPantalla();
                    String codEquipo3;
                    System.out.print("Ingrese el codigo del equipo: ");
                    codEquipo3 = scanner.nextLine();
                    if (controlador.equipos.containsKey(codEquipo3)) {
                        limpiarPantalla();
                        Equipo equipoEncontrado = controlador.equipos.get(codEquipo3);
                        System.out.println("+------------+---------------[EQUIPO ENCONTRADO]-------------------------");
                        System.out.println("| Equipo       | " + equipoEncontrado.getNombre() + " | Ciudad: " + equipoEncontrado.getCiudad());
                        System.out.println("+------------+---------------------------------------------------------------");
                    } else {
                        limpiarPantalla();
                        System.out.println("No se encuentra el equipo");
                    }
                    break;

                case 4:
                    limpiarPantalla();
                    String codEquipo4;
                    System.out.print("Ingrese el codigo del equipo que quiere eliminar: ");
                    codEquipo4 = scanner.nextLine();
                    if (controlador.equipos.containsKey(codEquipo4)) {
                        controlador.equipos.remove(codEquipo4);
                        System.out.println("Equipo eliminador exitosamente");
                    } else {
                        System.out.println("No se encontró el equipo");
                    }
                    break;

                case 5:
                    limpiarPantalla();
                    System.out.println("---------------------------------[EQUIPOS]--------------------------------- ");
                    int i = 0;
                    for (Map.Entry<String, Equipo> entry : controlador.equipos.entrySet()) {
                        String codEquipo5 = entry.getKey();
                        Equipo eq = entry.getValue();
                        System.out.println(MessageFormat.format("| Equipo {0} | Codigo: {1} | Nombre: {2} | Ciudad: {3} |", i, codEquipo5, eq.getNombre(), eq.getCiudad()));
                        i++;
                    }
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Opción inválida, intentelo nuevamente");
            }
        }
    }

}
