package com.example.ClasesProyecto;

  /*
    1. Implementar un simulador de la Liga UCU que permita:
a) Registrar divisiones, equipos y jugadores.
b) Buscar jugadores y equipos por identificador y por nombres.
c) Eliminar jugadores y equipos.
d) Listar divisiones, equipos y jugadores.
e) Programar partidos.
f) Registrar los resultados de los partidos y mantener un historial de los jugados.
g) Consultar información general de la liga, incluyendo partidos jugados, próximos
partidos y estadísticas básicas de jugadores y equipos.

    */
public class Liga {
    

    //Se crean las divisiones:
        
    //1 
    Division division1 = new Division("A", 8);
       
    //2  
    Division division2 = new Division("B", 8);

        //Se crean los equipos:
  
    //1
    Equipo Peñarol = new Equipo("PRL","Peñarol", division1);  
    //2
    Equipo Liverpool = new Equipo("LIV", "Liverpool", division1); 
    //3
    Equipo Racing = new Equipo ("RCG", "Racing", division1);
    //4
    Equipo River = new Equipo ("RIV", "River", division1);
    //5
    Equipo Arsenal = new Equipo ("ARS", "Arsenal", division1); 
    //6
    Equipo Palmeiras = new Equipo ("PLM", "Palmeiras", division1);
    //7
    Equipo Cerrito = new Equipo ("CRR", "Cerrito", division1);
    //8
    Equipo Rocha = new Equipo ("RCG", "Rocha", division1);
    //9
    Equipo Cerro = new Equipo ("CER", "Cerro", division2);
    //10
    Equipo Rentistas = new Equipo ("REN", "Rentistas", division2);
    //11
    Equipo Tabaré = new Equipo ("TAB", "Tabaré", division2);
    //12
    Equipo Barcelona = new Equipo ("BAR", "Barcelona", division1);
    //13
    Equipo Bilbao = new Equipo ("BIB", "Bilbao", division2);
    //14
    Equipo Prime = new Equipo ("PRI", "Prime", division2);
    //15
    Equipo Palermo = new Equipo ("PLM", "Palermo", division2);
    //16
    Equipo Lavalleja = new Equipo ("LVJ", "Lavalleja", division2);

    //Se crean los jugadores:
    //1
        Jugador jugador1 = new Jugador("Pepe",20, "Delantero");
        Jugador jugador2 = new Jugador("Juan",25, "Mediocampista");
        Jugador jugador3 = new Jugador("Lucia",30, "Defensa");
        Jugador jugador4 = new Jugador("Amadea",23, "Golero");
        Jugador jugador5 = new Jugador("Sebastian",21, "Delantero");
    //2 
        Jugador jugador6 = new Jugador("Juana",28, "Mediocampista");
        Jugador jugador7 = new Jugador("Pedro",24, "Defensa");
        Jugador jugador8 = new Jugador("Amanda",20, "Delantero");
        Jugador jugador9 = new Jugador("Jose",21, "Golero");
        Jugador jugador10 = new Jugador("Clementina",24, "Defensa");
    //3
        Jugador jugador11 = new Jugador("Santiago",23, "Golero");
        Jugador jugador12 = new Jugador("Victoria",46, "Defensa");
        Jugador jugador13 = new Jugador("Luis",18, "Defensa");
        Jugador jugador14 = new Jugador("Pepe",20, "Delantero");
        Jugador jugador15 = new Jugador("Manuela",27, "Delantero");
    //4 
        Jugador jugador16 = new Jugador("Sebastian",28, "Golero");
        Jugador jugador17 = new Jugador("Juan",19, "Delantero");
        Jugador jugador18 = new Jugador("Nicolas",19, "Delantero");
        Jugador jugador19 = new Jugador("Paulina",20, "Delantero");
        Jugador jugador20 = new Jugador("Amadeo",30, "Delantero");
    //5
        Jugador jugador21 = new Jugador("Joaquin",23, "Golero");
        Jugador jugador22 = new Jugador("Fernanda",22, "Defensa");
        Jugador jugador23 = new Jugador("Pepe",21, "Defensa");
        Jugador jugador24 = new Jugador("Thiago",20, "Defensa");
        Jugador jugador25 = new Jugador("Felipe",19, "Delantero");
    //6
        Jugador jugador26 = new Jugador("Martina",20, "Golero");
        Jugador jugador27 = new Jugador("Gabriel",24, "Mediocampista");
        Jugador jugador28 = new Jugador("Agustin",20, "Delantero");
        Jugador jugador29 = new Jugador("Carlos",35, "Defensa");
        Jugador jugador30 = new Jugador("Pepe",20, "Delantero");
    //7 
        Jugador jugador31 = new Jugador("Martin",66, "Golero");
        Jugador jugador32 = new Jugador("Juliana",20, "Delantero");
        Jugador jugador33 = new Jugador("Milagros",20, "Delantero");
        Jugador jugador34 = new Jugador("Belen",20, "Delantero");
        Jugador jugador35 = new Jugador("Enzo",20, "Defensa");
    //8
        Jugador jugador36 = new Jugador("Joaquin",25, "Golero");
        Jugador jugador37 = new Jugador("Lalo",50, "Delantero");
        Jugador jugador38 = new Jugador("Milagros",40, "Defensa");
        Jugador jugador39 = new Jugador("Javier",30, "Mediocampista");
        Jugador jugador40 = new Jugador("Manuel",10, "Delantero");

    //9
        Jugador jugador41 = new Jugador("Lisandro",14, "Delantero");
        Jugador jugador42 = new Jugador("Diego",4, "Golero");
        Jugador jugador43 = new Jugador("Lisandro",41, "Defensa");
        Jugador jugador44 = new Jugador("Lautaro",15, "Golero");
        Jugador jugador45 = new Jugador("Pablo",14, "Mediocampista");

    //10
        Jugador jugador46 = new Jugador("Emiliano",14, "Delantero");
        Jugador jugador47 = new Jugador("Nicolas",3, "Golero");
        Jugador jugador48 = new Jugador("Lisandro",51, "Defensa");
        Jugador jugador49 = new Jugador("Cristian",15, "Defensa");
        Jugador jugador50 = new Jugador("Tiago",16, "Mediocampista");

    //11
        Jugador jugador51 = new Jugador("Ramiro",17, "Delantero");
        Jugador jugador52 = new Jugador("Franco",4, "Golero");
        Jugador jugador53 = new Jugador("Benjamin",41, "Defensa");
        Jugador jugador54 = new Jugador("Lautaro",15, "Defensa");
        Jugador jugador55 = new Jugador("Pablo",14, "Mediocampista");

    //12
        Jugador jugador56 = new Jugador("Martin",19, "Delantero");
        Jugador jugador57 = new Jugador("Diego",4, "Golero");
        Jugador jugador58 = new Jugador("Geronimo",44, "Defensa");
        Jugador jugador59 = new Jugador("Renato",15, "Defensa");
        Jugador jugador60 = new Jugador("Pablo",40, "Mediocampista");
    
    //13
        Jugador jugador61 = new Jugador("Lisandro",14, "Delantero");
        Jugador jugador62 = new Jugador("Diego",4, "Golero");
        Jugador jugador63 = new Jugador("Julian",41, "Defensa");
        Jugador jugador64 = new Jugador("Lautaro",15, "defensa");
        Jugador jugador65 = new Jugador("Paulo",34, "Mediocampista");
    
    //14
        Jugador jugador66 = new Jugador("Lisandro",84, "Delantero");
        Jugador jugador67 = new Jugador("Diego",24, "Golero");
        Jugador jugador68 = new Jugador("Manuel",41, "Defensa");
        Jugador jugador69 = new Jugador("Lautaro",15, "Defensa");
        Jugador jugador70 = new Jugador("Antonio",64, "Mediocampista");
    
    //15
        Jugador jugador71 = new Jugador("Marcos",14, "Delantero");
        Jugador jugador72 = new Jugador("Nahuel",1, "Golero");
        Jugador jugador73 = new Jugador("Walter",10, "Defensa");
        Jugador jugador74 = new Jugador("Sergio",9, "Defensa");
        Jugador jugador75 = new Jugador("Pablo",53, "Mediocampista");

    //16
        Jugador jugador76 = new Jugador("Mauricio",37, "Delantero");
        Jugador jugador77 = new Jugador("Matias",12, "Golero");
        Jugador jugador78 = new Jugador("Leonardo",41, "Defensa");
        Jugador jugador79 = new Jugador("Emanuel",35, "Defensa");
        Jugador jugador80 = new Jugador("Pablo",140, "Mediocampista");


    //Se crean los partidos:
    public void programarPartidos(Division division) {
        int cantidadEquipos = division.cantElementos(); //nos dice la cantidad de equipos

        for (int i = 0; i < cantidadEquipos; i++) {
            Equipo local = division.obtenerPorIndice(i);//recorro la lista de equipos

            for (int j = i + 1; j < cantidadEquipos; j++) {
                Equipo visitante = division.obtenerPorIndice(j); //agarro el siguiente, la idea es juntar pares

                // chequeamos si ya jugaron
                if (!division.yaJugaron(local, visitante)) { //Si no jugaron, arma el partido
                    Partido partido = new Partido(local, visitante, division);
                    division.registrarPartido(partido);
                }
            }
        }
    }

        
}

 
    

  

