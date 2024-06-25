package com.ligafutbol.vistas;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;

import com.ligafutbol.Controller;
import com.ligafutbol.entidades.Entrenador;

public class VistaEntrenador {
    public static Controller controlador;
    private Scanner scanner;

    public VistaEntrenador (Scanner scanner){
        this.scanner = scanner;
    }

    private void limpiarPantalla(){
        System.out.print("\033[H\033[2J"); 
        System.out.flush();
    }

    public void start() {

        while (true) {
            limpiarPantalla();
            System.out.println("---------------------------------[Gestión de Entrenadores]---------------------------------");
            System.out.println("---------------------------------[Seleccione una opcion]----------------------------------");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("[1] ->                               Crear entrenador                                   <-");
            System.out.println("[2] ->                             Actualizar entrenador                                <-");
            System.out.println("[3] ->                               Buscar entrenador                                  <-");
            System.out.println("[4] ->                              Eliminar entrenador                                 <-");
            System.out.println("[5] ->                          Listar todos los entrenadores                           <-");
            System.out.println("[6] ->                                      Salir                                       <-");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.print(  "[Tu eleccion] -> ");

            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    limpiarPantalla();
                    Entrenador entrenador = new Entrenador();
                    int idEntrenador;

                    System.out.print("Ingrese el id del entrenador :");
                    idEntrenador = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese Nombre del entrenador :");
                    entrenador.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el apellido del entrenador: ");
                    entrenador.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la edad del entrenador: ");
                    entrenador.setEdad(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese el id de la federacion del entrenador :");
                    entrenador.setIdFedaracion(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println();


                    controlador.entrenadores.put(idEntrenador, entrenador);
                    System.out.println("Entrenador creado exitosamente");
                    break;

                case 2:
                    limpiarPantalla();
                    Entrenador entrenadorAct = new Entrenador();
                    int idEntrenador2;

                    System.out.print("Ingrese el id del entrenador: ");
                    idEntrenador2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese nuevo nombre del entrenador: ");
                    entrenadorAct.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el nuevo apellido del entrenador: ");
                    entrenadorAct.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la nueva edad del entrenador: ");
                    entrenadorAct.setEdad(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese el nuevo id de la federacion del entrenador: ");
                    entrenadorAct.setIdFedaracion(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println();            

                    controlador.entrenadores.replace(idEntrenador2, entrenadorAct);
                    System.out.println("Entrenador actualizado con exito");

                    break;

                case 3:
                    limpiarPantalla();
                    int idEntrenador3;
                    System.out.print("Ingrese el id del entrenador: ");
                    idEntrenador3 = scanner.nextInt();
                    if (controlador.entrenadores.containsKey(idEntrenador3)) {
                        limpiarPantalla();
                        Entrenador entrenadorEncontrado = controlador.entrenadores.get(idEntrenador3);
                        System.out.println("+------------|---------------[ENTRENADOR ENCONTRADO]-------------------------");
                        System.out.println(  "| Entrenador + " + entrenadorEncontrado.getNombre() +" "+ entrenadorEncontrado.getApellido());
                        System.out.println("+------------|---------------------------------------------------------------");
                    } else {
                        limpiarPantalla();
                        System.out.println("No se encontró al jugador");
                    }
                    break;
                case 4:
                    limpiarPantalla();
                    int idEntrenador4;
                    System.out.print("Ingrese el id del masajista que quiere eliminar: ");
                    idEntrenador4 = scanner.nextInt();
                    if (controlador.entrenadores.containsKey(idEntrenador4)) {
                        controlador.entrenadores.remove(idEntrenador4);
                        System.out.println("Entrenador eliminado con exito");
                    } else {
                        System.out.println("No se encontró al entrenador");
                    }
                    break;
                case 5:
                    limpiarPantalla();
                    System.out.println("---------------------------------[ENTRENADORES]--------------------------------- ");
                    int i = 0;
                    for (Map.Entry<Integer, Entrenador> entry : controlador.entrenadores.entrySet()) {
                        int idsEntrenadores = entry.getKey();
                        Entrenador entrenadores = entry.getValue();
                        System.out.println(MessageFormat.format("| Entrenador {0} | Id: {1} | Nombre_ {2} | Apellido: {3} | Federacion: {4} |" , i, idsEntrenadores, entrenadores.getNombre(), entrenadores.getApellido(), entrenadores.getIdFedaracion()));
                        i++;
                    }
                    break;
                case 6:
                    return;

                default:
                    System.out.println("Opción incorrecta, elija una de las seis opciones");
            }
        }
    }
}
