package com.ligafutbol.vistas;

import java.text.MessageFormat;
import java.util.Map;
import java.util.Scanner;

import com.ligafutbol.Controller;
import com.ligafutbol.entidades.Jugador;

public class VistaJugador {
    public static Controller controlador;
    private Scanner scanner;

    public VistaJugador(Scanner scanner) {
        this.scanner = scanner;
    }

    private void limpiarPantalla() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

     public void start() {
        while (true) {
            limpiarPantalla();
            System.out.println("---------------------------------[Gestión de Jugadores]---------------------------------");
            System.out.println("---------------------------------[Seleccione una opcion]----------------------------------");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("[1] ->                               Crear jugador                                      <-");
            System.out.println("[2] ->                             Actualizar jugador                                   <-");
            System.out.println("[3] ->                               Buscar jugador                                     <-");
            System.out.println("[4] ->                              Eliminar jugador                                    <-");
            System.out.println("[5] ->                          Listar todos los jugadores                              <-");
            System.out.println("[6] ->                                    Salir                                         <-");
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.print("[Tu eleccion] -> ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    limpiarPantalla();
                    Jugador jugador = new Jugador();
                    int idJugador;

                    System.out.print("Ingrese el id del jugador :");
                    idJugador = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese Nombre del jugador :");
                    jugador.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el apellido del jugador: ");
                    jugador.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la edad del jugador: ");
                    jugador.setEdad(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese posicion del jugador :");
                    jugador.setPosicion(scanner.nextLine());
                    System.out.println();

                    controlador.jugadores.put(idJugador, jugador);
                    System.out.println("Jugador creado exitosamente");
                    break;

                case 2:
                    limpiarPantalla();
                    Jugador jugadorAct = new Jugador();
                    int idJugador2;

                    System.out.print("Ingrese el id del jugador: ");
                    idJugador2 = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese nuevo nombre del jugador: ");
                    jugadorAct.setNombre(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese el nuevo apellido del jugador: ");
                    jugadorAct.setApellido(scanner.nextLine());
                    System.out.println();

                    System.out.print("Ingrese la nueva edad del jugador: ");
                    jugadorAct.setEdad(scanner.nextInt());
                    scanner.nextLine();
                    System.out.println();

                    System.out.print("Ingrese nueva posicion del jugador: ");
                    jugadorAct.setPosicion(scanner.nextLine());
                    System.out.println();

                    controlador.jugadores.replace(idJugador2, jugadorAct);
                    System.out.println("Jugador actualizado exitosamente");
                    break;

                case 3:
                    limpiarPantalla();
                    int idJugador3;
                    System.out.print("Ingrese el id del jugador: ");
                    idJugador3 = scanner.nextInt();
                    if (controlador.jugadores.containsKey(idJugador3)) {
                        limpiarPantalla();
                        Jugador jugadorEncontrado = controlador.jugadores.get(idJugador3);
                        System.out.println("+------------|---------------[JUGADOR ENCONTRADO]-------------------------");
                        System.out.println("| Jugador + " + jugadorEncontrado.getNombre() + " " + jugadorEncontrado.getApellido());
                        System.out.println("+------------|-------------------------------------------------------------");
                    } else {
                        limpiarPantalla();
                        System.out.println("Juagador no encontrado");
                    }
                    break;
                case 4:
                    limpiarPantalla();
                    int idJugador4;
                    System.out.print("Ingrese el id del jugador que quiere eliminar: ");
                    idJugador4 = scanner.nextInt();
                    if (controlador.jugadores.containsKey(idJugador4)) {
                        controlador.jugadores.remove(idJugador4);
                        System.out.println("Jugador eliminado exitosamente");
                    } else {
                        System.out.println("Jugador no encontrado");
                    }
                    break;
                case 5:
                    limpiarPantalla();
                    System.out.println("---------------------------------[JUGADORES]--------------------------------- ");
                    int i = 0;
                    for (Map.Entry<Integer, Jugador> entry : controlador.jugadores.entrySet()) {
                        int idsJugadores = entry.getKey();
                        Jugador jugadores = entry.getValue();
                        System.out.println(MessageFormat.format("| Jugador {0} | Id: {1} | Nombre: {2} | Apellido: {3} | Posicion: {4} |", i, idsJugadores, jugadores.getNombre(), jugadores.getApellido(), jugadores.getPosicion()));
                        i++;
                    }
                    break;
                case 6:
                    return;

                default:
                    System.out.println("Opción incorrecta, elige una de las 6 opciones");
            }
        }
    }

}
