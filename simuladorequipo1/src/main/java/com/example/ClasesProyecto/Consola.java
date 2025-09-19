package com.example.ClasesProyecto;

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

                //Se le da la opción al usuario como con la liga precargada de hacer operaciones o terminar el programa
                interno:
                while(true){
                    System.out.println("Elija una de las siguientes opciones");
                    System.out.println("1- Agregar equipo.");
                    System.out.println("2- Agregar jugador.");
                    System.out.println("3- Buscar equipo.");
                    System.out.println("4- Buscar jugador.");
                    System.out.println("5- Eliminar equipo.");
                    System.out.println("6- Eliminar jugador.");
                    System.out.println("7- Mostrar equipos.");
                    System.out.println("8- Mostrar jugadores.");
                    System.out.println("9- Mostrar divisiones.");
                    System.out.println("10- Consultar partidos jugados.");
                    //System.out.println("11- Crear equipo.");
                    //System.out.println("12- Crear jugador.");
                    System.out.println("13- Para mostrar la tabla de posiciones.");
                    System.out.println("14- Para volver a elegir entre liga nueva o precargada.");
                    System.out.println("15- Para salir de la aplicación.");
                    int entrada2 = scanner.nextInt();scanner.nextLine();

                    switch(entrada2){
                        case 1:
                            System.out.println("Ingrese el id: ");
                            String id1 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese el nombre del equipo: ");
                            String nombreEq1 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese la division: ");
                            String div1 = scanner.nextLine();scanner.nextLine();
                            Division division = nuevaLiga.buscarDivision(div1);
                            Equipo equipo = new Equipo(id1, nombreEq1, division);
                            nuevaLiga.agregarEquipoADivision(division, equipo);
                            System.out.println("Su equipo ha sido agregado");

                            continue interno;
                        case 2:
                            System.out.println("Ingrese el nombre del jugador: ");
                            String nombreJug = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese la edad: ");
                            int edad = scanner.nextInt();scanner.nextLine();
                            System.out.println("Ingrese la posicion: ");
                            String posicion = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese el nombre del equipo: ");
                            String nombreEq = scanner.nextLine();scanner.nextLine();
                            Equipo equipo1 = nuevaLiga.buscarEquipo(nombreEq);
                            Jugador jugador = new Jugador(nombreJug, edad, posicion);
                            nuevaLiga.agregarJugadorAEquipo(equipo1, jugador);
                            System.out.println("Su jugador ha sido agregado");

                            continue interno;
                        case 3:
                            System.out.println("Ingrese el nombre del equipo a buscar: ");
                            String nombreEq3 = scanner.nextLine();scanner.nextLine();
                            Equipo equipoBuscado3 = nuevaLiga.buscarEquipo(nombreEq3);

                            System.out.println("Estas son las estadísticas del equipo: ");
                            System.out.println("Nombre: " + equipoBuscado3.getNombre());
                            System.out.println("Division: " + equipoBuscado3.getDivision().getNombre());
                            System.out.println("Puntos obtenidos: " + equipoBuscado3.getPuntos());
                            System.out.println("Partidos terminados: " + equipoBuscado3.getPartidosTerminados());
                            System.out.println("Partidos ganados: " + equipoBuscado3.getGanados());
                            System.out.println("Partidos empatados: " + equipoBuscado3.getEmpatados());
                            System.out.println("Partidos perdidos: " + equipoBuscado3.getPerdidos());
                            System.out.println("Diferencia de goles: " + equipoBuscado3.getDiferenciaDeGol());
                            System.out.println("Goles a favor: " + equipoBuscado3.getGolesAFavor());
                            System.out.println("Goles en contra: " + equipoBuscado3.getGolesEnContra());

                            continue interno;
                        case 4:
                            System.out.println("Ingrese el nombre del jugador a buscar: ");
                            String nombreJ4 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese el nombre del equipo al que pertenece: ");
                            String nombreEq4 = scanner.nextLine();scanner.nextLine();
                            Jugador jugBuscado4 = nuevaLiga.buscarJugador(nombreJ4, nombreEq4);
                            
                            System.out.println("Estas son las estadísticas del jugador: ");
                            System.out.println("Nombre: " + jugBuscado4.getNombre());
                            System.out.println("Equipo: " + jugBuscado4.getEquipo());
                            System.out.println("Edad: " + jugBuscado4.getEdad());
                            System.out.println("Posición: " + jugBuscado4.getPosicion());
                            System.out.println("Goles convertidos: " + jugBuscado4.getGolesConvertidos());
                            System.out.println("Tarjetas recibidas: " + jugBuscado4.getTarjetasRecibidas());
                            System.out.println("Partidos disputados: " + jugBuscado4.getPartidosDisputados());
                            System.out.println("ID: " + jugBuscado4.getId());

                            continue interno;
                        case 5:
                            System.out.println("Ingrese el nombre del equipo a eliminar: ");
                            String nombreEq5 = scanner.nextLine();scanner.nextLine();
                            nuevaLiga.eliminarEquipo(nombreEq5);
                            System.out.println("El equipo ha sido eliminado");

                            continue interno;
                        case 6:
                            System.out.println("Ingrese el nombre del jugador a eliminar: ");
                            String nombreJ6 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese el nombre del equipo: ");
                            String nombreEq6 = scanner.nextLine();scanner.nextLine();
                            nuevaLiga.eliminarJugador(nombreJ6, nombreEq6);
                            System.out.println("El jugador ha sido eliminado");
                            
                            continue interno;
                        case 7:
                            System.out.println("Ingrese el nombre de la división cuyos equipos desea ver: ");
                            String nombreDiv7 = scanner.nextLine();scanner.nextLine();
                            Division div7 = nuevaLiga.buscarDivision(nombreDiv7);
                            div7.mostrarEquipos();

                            continue interno;
                        case 8:

                            continue interno;
                        case 9:
                            nuevaLiga.listarDivisiones();

                            continue interno;
                        case 10:
                            continue interno;
                        case 11:
                            System.out.println("Ingrese el nombre del equipo");
                            String nombreEq11 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese el ID con caracteres del equipo");
                            String nombreDiv11 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese la división del nuevo equipo");
                            String nombreEqID11 = scanner.nextLine();scanner.nextLine();
                            Equipo equipo11 = new Equipo(nombreEqID11, nombreEq11, nuevaLiga.buscarDivision(nombreDiv11));
                            nuevaLiga.buscarDivision(nombreDiv11).agregarEquipo(equipo11);
                            System.out.println("Su equipo " + equipo11.getNombre() + "ha quedado ingresado a la división " + nuevaLiga.buscarDivision(nombreDiv11).getNombre());
                            
                            continue interno;
                        case 12:
                            System.out.println("Ingrese el nombre del jugador");
                            String nombreJug12 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese la edad del jugador");
                            int edadJug12 = scanner.nextInt();scanner.nextLine();
                            System.out.println("Ingrese la posición del jugador");
                            String posJug12 = scanner.nextLine();scanner.nextLine();
                            Jugador jugador12 = new Jugador(nombreJug12, edadJug12, posJug12);
                            System.out.println("Ingrese el equipo de su jugador");
                            String eqJug12 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese la division de su jugador");
                            String divJug12 = scanner.nextLine();scanner.nextLine();
                            nuevaLiga.buscarDivision(divJug12).buscarEquipoPorNombre(eqJug12).agregarJugador(jugador12);

                            continue interno;
                        case 13:

                            continue interno;
                        case 14:
                            //Regresa a la pregunta inicial del programa
                            break interno;
                        case 15:
                            //Cierra la aplicación
                            break externo;
                    }
                }
            } 
                
                
                
                
            
            else if (entrada==2) {
                Liga liga = LigaPrecargada.crearLiga();
                interno:
                while (true){
                    System.out.println("Elija una de estás siguientes opciones: ");
                    System.out.println("1- Agregar equipo.");
                    System.out.println("2- Agregar jugador.");
                    System.out.println("3- Buscar equipo.");
                    System.out.println("4- Buscar jugador.");
                    System.out.println("5- Eliminar equipo.");
                    System.out.println("6- Eliminar jugador.");
                    System.out.println("7- Mostrar equipos.");
                    System.out.println("8- Mostrar jugadores.");
                    System.out.println("9- Mostrar divisiones.");
                    System.out.println("10- Consultar partidos jugados.");
                    //System.out.println("11- Crear equipo.");
                    //System.out.println("12- Crear jugador.");
                    System.out.println("13- Para mostrar la tabla de posiciones.");
                    System.out.println("14- Para volver a elegir entre liga nueva o precargada.");
                    System.out.println("15- Para salir de la aplicación.");
                    int entrada2 = scanner.nextInt();
                    scanner.nextLine();
                    
                    switch (entrada2) {
                        case 1:
                            System.out.println("Ingrese el id: ");
                            String id1 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese el nombre del equipo: ");
                            String nombreEq1 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese la division: ");
                            String div1 = scanner.nextLine();scanner.nextLine();
                            Division division = liga.buscarDivision(div1);
                            Equipo equipo = new Equipo(id1, nombreEq1, division);
                            liga.agregarEquipoADivision(division, equipo);
                            System.out.println("Su equipo ha sido agregado");
                            
                            continue interno;
                        case 2:
                            System.out.println("Ingrese el nombre del jugador: ");
                            String nombreJ2 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese la edad: ");
                            int edad = scanner.nextInt();scanner.nextLine();
                            System.out.println("Ingrese la posicion: ");
                            String posicion = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese el nombre del equipo: ");
                            String nombreEq2 = scanner.nextLine();scanner.nextLine();
                            Equipo e1 = liga.buscarEquipo(nombreEq2);
                            Jugador jugador = new Jugador(nombreJ2, edad, posicion);
                            liga.agregarJugadorAEquipo(e1, jugador);
                            System.out.println("Su jugador ha sido agregado");
                            
                            continue interno;
                        case 3:
                            System.out.println("Ingrese el nombre del equipo a buscar: ");
                            String nombreEq3 = scanner.nextLine();scanner.nextLine();
                            Equipo equipoBuscado3 = liga.buscarEquipo(nombreEq3);

                            System.out.println("Estas son las estadísticas del equipo: ");
                            System.out.println("Nombre: " + equipoBuscado3.getNombre());
                            System.out.println("Division: " + equipoBuscado3.getDivision().getNombre());
                            System.out.println("Puntos obtenidos: " + equipoBuscado3.getPuntos());
                            System.out.println("Partidos terminados: " + equipoBuscado3.getPartidosTerminados());
                            System.out.println("Partidos ganados: " + equipoBuscado3.getGanados());
                            System.out.println("Partidos empatados: " + equipoBuscado3.getEmpatados());
                            System.out.println("Partidos perdidos: " + equipoBuscado3.getPerdidos());
                            System.out.println("Diferencia de goles: " + equipoBuscado3.getDiferenciaDeGol());
                            System.out.println("Goles a favor: " + equipoBuscado3.getGolesAFavor());
                            System.out.println("Goles en contra: " + equipoBuscado3.getGolesEnContra());

                            continue interno;
                        case 4:
                            System.out.println("Ingrese el nombre del jugador a buscar: ");
                            String nombreJ4 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese el nombre del equipo al que pertenece: ");
                            String nombreEq4 = scanner.nextLine();scanner.nextLine();
                            Jugador jugBuscado = liga.buscarJugador(nombreJ4, nombreEq4);

                            System.out.println("Estas son las estadísticas del jugador: ");
                            System.out.println("Nombre: " + jugBuscado.getNombre());
                            System.out.println("Equipo: " + jugBuscado.getEquipo());
                            System.out.println("Edad: " + jugBuscado.getEdad());
                            System.out.println("Posición: " + jugBuscado.getPosicion());
                            System.out.println("Goles convertidos: " + jugBuscado.getGolesConvertidos());
                            System.out.println("Tarjetas recibidas: " + jugBuscado.getTarjetasRecibidas());
                            System.out.println("Partidos disputados: " + jugBuscado.getPartidosDisputados());
                            System.out.println("ID: " + jugBuscado.getId());

                            continue interno;
                        case 5:
                            System.out.println("Ingrese el nombre del equipo a eliminar: ");
                            String nombreEq5 = scanner.nextLine();scanner.nextLine();
                            liga.eliminarEquipo(nombreEq5);
                            System.out.println("El equipo ha sido eliminado");
                            
                            continue interno;
                        case 6:
                            System.out.println("Ingrese el nombre del jugador a eliminar: ");
                            String nombreJ6 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese el nombre del equipo: ");
                            String nombreEq6 = scanner.nextLine();scanner.nextLine();
                            liga.eliminarJugador(nombreJ6, nombreEq6);
                            System.out.println("El jugador ha sido eliminado");

                            continue interno;
                        case 7:
                            System.out.println("Ingrese el nombre de la división cuyos equipos desea ver: ");
                            String nombreDiv7 = scanner.nextLine();scanner.nextLine();
                            Division div7 = liga.buscarDivision(nombreDiv7);
                            div7.mostrarEquipos();

                            continue interno;
                        case 8:
                            System.out.println(liga.mostrarJugadores());
                            continue interno;
                        case 9:
                            liga.listarDivisiones();

                            continue interno;
                        case 10:
                            System.out.println("Ingrese la division que desea ver los partidos jugados: ");
                            String div10 = scanner.nextLine();scanner.nextLine();
                            Division div101 = liga.buscarDivision(div10);
                            System.out.println(div101.mostrarHistorialString());

                            continue interno;
                        case 11://Capaz eliminar
                            System.out.println("Ingrese el nombre del equipo");
                            String nombreEq11 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese el ID con caracteres del equipo");
                            String nombreDiv11 = scanner.nextLine();scanner.nextLine();
                            System.out.println("Ingrese la división del nuevo equipo");
                            String nombreEqID11 = scanner.nextLine();scanner.nextLine();
                            Equipo equipo11 = new Equipo(nombreEqID11, nombreEq11, liga.buscarDivision(nombreDiv11));
                            liga.buscarDivision(nombreDiv11).agregarEquipo(equipo11);
                            System.out.println("Su equipo " + equipo11.getNombre() + "ha quedado ingresado a la división " + liga.buscarDivision(nombreDiv11).getNombre());

                            continue interno;
                        case 12://Capaz eliminar
                            System.out.println("Ingrese");
                            
                            continue interno;
                        case 13:
                            System.out.println("Ingrese el nombre de la división:");
                            String nombreDivision = scanner.nextLine();
                            Division divisionTP = liga.buscarDivision(nombreDivision);
                            System.out.println(divisionTP.tablaDePosiciones());
                            continue interno;
                        case 14:
                            //Regresa a la pregunta inicial del programa 
                            break interno;
                        case 15:
                            //Cierra la aplicación
                            break externo;
                        default:
                            System.out.println("ingrese una opción válida");
                            continue interno;
                    }
                } 
            }

            else{
                System.out.println("Por favor elija una opción válida");
                continue externo;
            }
        }
    }
}


