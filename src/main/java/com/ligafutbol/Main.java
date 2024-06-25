package com.ligafutbol;

import java.util.Scanner;

import com.ligafutbol.vistas.VistaDoctor;
import com.ligafutbol.vistas.VistaEntrenador;
import com.ligafutbol.vistas.VistaEquipo;
import com.ligafutbol.vistas.VistaJugador;

public class Main {
    public static void main(String[] args) {
        Controller ctrlTeams = new Controller();
        VistaEquipo.controlador = ctrlTeams;
        VistaJugador.controlador = ctrlTeams;
        VistaDoctor.controlador = ctrlTeams;
        VistaEntrenador.controlador = ctrlTeams;
        
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("\033[H\033[2J"); 
            System.out.flush();
            System.out.println("        ______          _    ______   _                 \n"+
                               "        | ___ \\        | |   | ___ \\ | |                \n"+
                               "        | |_/ /   ___  | |_  | |_/ / | |   __ _   _   _ \n"+
                               "        | ___ \\  / _ \\ | __| |  __/  | |  / _` | | | | |\n"+
                               "        | |_/ / |  __/ | |_  | |     | | | (_| | | |_| |\n"+
                               "        \\____/   \\___|  \\__| \\_|     |_|  \\__,_|  \\__, |\n"+
                               "                                                   __/ |\n"+
                               "                                                  |___/ \n");
            System.out.println("--------------------[Seleccione una opcion]---------------------");
            System.out.println("----------------------------------------------------------------");            
            System.out.println(" [1] ->                 Entrenadores                          <-");
            System.out.println(" [2] ->                  Masajistas                           <-");
            System.out.println(" [3] ->                   Jugadores                           <-");
            System.out.println(" [4] ->                    Equipos                            <-");
            System.out.println(" [5] ->                     Salir                             <-");
            System.out.println("----------------------------------------------------------------");
            System.out.print(  "[Tu eleccion] -> ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush(); 
                    VistaEntrenador vc = new VistaEntrenador(scanner);
                    vc.start();
                    break;
                
                case 2:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush(); 
                    VistaDoctor vd = new VistaDoctor(scanner);
                    vd.start();
                    break;
                
                case 3:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush();
                    VistaJugador vp = new VistaJugador(scanner);
                    vp.start();
                    break;

                case 4:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush();
                    VistaEquipo vt = new VistaEquipo(scanner);
                    vt.start();
                    break;

                case 5:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush();
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.print("\033[H\033[2J"); 
                    System.out.flush();
                    System.out.println("Opcion incorrecta");
                    break;

            }
        }
    }
}