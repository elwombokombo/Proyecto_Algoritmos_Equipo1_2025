package com.example.ClasesProyecto;

import com.example.ClasesProyecto.Liga;
import java.util.Scanner;
public class Consola {

    private Scanner scanner;

    public Consola() {
        scanner = new Scanner(System.in);
        externo:
        while(true){
            System.out.println("¿Desea crear su propia Liga o analizar la precargada? \n Ingrese 1 para nueva o 2 para la opción precargada");
            int entrada = scanner.nextInt();
            scanner.nextLine();
            if (entrada==1){
                //Se crea la liga
                System.out.println("¿Cómo quieres que se llame la liga?");
                String nombreLiga=scanner.nextLine();scanner.nextLine();
                Liga nuevaLiga= new Liga(nombreLiga);
                //Se crea la division
                System.out.println("¿Cuántas divisiones quieres que tenga (Ingrese dígitos)?");
                int cantDivisiones=scanner.nextInt();scanner.nextLine();
                for (int i=0;i < cantDivisiones;i++){
                    System.out.println("¿Cómo quieres que se llame tu división?");
                    String nombreDivision=scanner.nextLine();scanner.nextLine();
                    System.out.println("¿Cuántos equipos quieres que tenga?");
                    int cantEquipos = scanner.nextInt();scanner.nextLine();
                    Division division = new Division(nombreDivision,cantEquipos);
                    nuevaLiga.agregarDivision(division);
                    for (int x=0;x < cantEquipos;x++){
                        System.out.println("Ingresa el nombre de un equipo");
                        String nombreEquipo=scanner.nextLine();scanner.nextLine();
                        System.out.println("Ingresa su ID de caracteres");
                        String idEquipo=scanner.nextLine();scanner.nextLine();
                        Equipo nuevoEquipo = new Equipo(idEquipo, nombreLiga, division);
                        division.agregarEquipo(nuevoEquipo);

                    }
                }
                
                
                
                
            }
            else if (entrada==2) {
                System.out.println("Elija una de estás siguientes opciones: ");
                System.out.println("1- Agregar equipo.");
                System.out.println("2- Agregar jugador.");
                System.out.println("3- Buscar equipo.");
                System.out.println("4- Buscar jugador.");
                System.out.println("5- Eliminar equipo.");
                System.out.println("6- Eliminar jugador.");
                System.out.println("7- Mostrar equipo.");
                System.out.println("8- Mostrar jugador.");
                System.out.println("9- Consultar proximos partidos.");
                System.out.println("10- Consultar partidos jugados.");
                int entrada2 = scanner.nextInt();
                scanner.nextLine();
                
                switch (entrada2) {
                    case 1:
                        System.out.println("Ingrese el nombre de la division:");
                        liga.agregarEquipoADivision(nombreDivision = scanner.nextLine()) 
                        
                        break;
                    case 2:
                        
                        break;
                    case 3:
                        
                        break;
                    case 4:
                        
                        break;
                    case 5:
                        
                        break;
                    case 6:
                        
                        break;
                    case 7:
                        
                        break;
                    case 8:
                        
                        break;
                    case 9:
                        
                        break;
                    case 10:
                        
                        break;
                    default:
                        throw new AssertionError();
                }
            }

            else{
                System.out.println("Por favor elija una opción válida");
                continue externo;
            }
        }
    }
}

