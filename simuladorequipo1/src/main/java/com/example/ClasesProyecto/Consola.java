package com.example.ClasesProyecto;

import java.util.Scanner;

import com.example.lista.impl.TDAListaEnlazada;

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
                
                //Comienza la secuencia de creación de objetos
                //Se crea la división
                System.out.println("¿Cuántas divisiones quieres que tenga (Ingrese dígitos)?");
                int cantDivisiones=scanner.nextInt();scanner.nextLine();
                for (int i=0;i < cantDivisiones;i++){
                    System.out.println("¿Cómo quieres que se llame tu división?");
                    String nombreDivision=scanner.nextLine();scanner.nextLine();
                    System.out.println("¿Cuántos equipos quieres que tenga?");
                    int cantEquipos = scanner.nextInt();scanner.nextLine();
                    Division division = new Division(nombreDivision,cantEquipos);
                    nuevaLiga.agregarDivision(division);

                    //Se agregan los equipos a la división
                    for (int x=0;x < cantEquipos;x++){
                        System.out.println("Ingresa el nombre de un equipo");
                        String nombreEquipo=scanner.nextLine();scanner.nextLine();
                        System.out.println("Ingresa su ID de caracteres");
                        String idEquipo=scanner.nextLine();scanner.nextLine();
                        Equipo nuevoEquipo = new Equipo(idEquipo, nombreLiga, division);
                        division.agregarEquipo(nuevoEquipo);

                        //Se agregan los jugadores al equipo
                        System.out.println("¿Cuántos jugadores le gustaría agregar al equipo? (Digite un número)");
                        int cantJugadores = scanner.nextInt();scanner.nextLine();
                        for (int y=0; y<cantJugadores;y++){
                            System.out.println("A continuación crearemos los jugadores");
                            System.out.println("¿Como quiere que se llame este jugador?");
                            String nombreJugador=scanner.nextLine();scanner.nextLine();
                            System.out.println("¿Qué edad tiene? (Digite un número)");
                            int edadJugador=scanner.nextInt();scanner.nextLine();
                            System.out.println("¿Cuál es su posición?");
                            String posicionJugador=scanner.nextLine();scanner.nextLine();
                            Jugador jugador = new Jugador(nombreJugador, edadJugador, posicionJugador);
                            nuevoEquipo.agregarJugador(jugador);
                        }                  
                    }
                }

                /*Ya creada la liga se autogeneran los partidos*/
                System.out.println("Los partidos serán autogenerados");
                Division divisionActual = nuevaLiga.divisiones.obtenerPorIndice(0);
                int contadorDivisiones = 0;
                while (divisionActual!=null) {
                    nuevaLiga.programarPartidos(divisionActual);
                    contadorDivisiones +=1;
                    divisionActual = nuevaLiga.divisiones.obtenerPorIndice(contadorDivisiones);
                }
            } 
                
                
                
                
            
            else if (entrada==2) {
                Liga liga = LigaPrecargada.crearLiga(); 
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
                System.out.println("11- Crear equipo.");
                System.out.println("12- Crear jugador.");
                int entrada2 = scanner.nextInt();
                scanner.nextLine();
                
                switch (entrada2) {
                    case 1:
                        System.out.println("Ingrese el id: ");
                        String id = scanner.nextLine();
                        System.out.println("Ingrese el nombre del equipo: ");
                        String nombreEq = scanner.nextLine();
                        System.out.println("Ingrese la division: ");
                        String div = scanner.nextLine();
                        Division division = liga.buscarDivision(div);
                        Equipo equipo = new Equipo(id, nombreEq, division);
                        liga.agregarEquipoADivision(division, equipo);
                        
                        break;
                    case 2:
                        System.out.println("Ingrese el nombre del jugador: ");
                        String nombre = scanner.nextLine();scanner.nextLine();
                        System.out.println("Ingrese la edad: ");
                        int edad = scanner.nextInt();
                        System.out.println("Ingrese la posicion: ");
                        String posicion = scanner.nextLine();
                        System.out.println("Ingrese el equipo: ");
                        String equipoJ = scanner.nextLine();
                        Equipo equipoJ = liga.buscarEquipo(equipoJ);
                        Jugador jugador = new Jugador(nombre, edad, posicion);
                        liga.agregarJugadorAEquipo(equipoJ, jugador);

                        
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
                    case 11:
                        
                        break;
                    case 12:
                        
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


