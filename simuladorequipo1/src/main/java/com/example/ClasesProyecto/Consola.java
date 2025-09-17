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
                System.out.println("¿Cómo quieres que se llame la liga?");
                String nombreLiga=scanner.nextLine();scanner.nextLine();
                System.out.println("¿Cuántos equipos quieres que tenga?");
                int cantidadEqLiga=scanner.nextInt();scanner.nextLine();
                Liga nuevaLiga= new Liga(nombreLiga,cantidadEqLiga);
            }
            else if (entrada==2) {
                System.out.println("Elija una de estás siguientes opciones: ");
            }
            else{
                System.out.println("Por favor elija una opción válida");
                continue externo;
            }
        }
    }
}

