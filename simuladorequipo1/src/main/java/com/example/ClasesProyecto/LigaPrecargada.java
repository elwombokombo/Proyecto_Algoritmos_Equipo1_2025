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
public class LigaPrecargada {
    public static Liga crearLiga() {

    // Crear liga
        Liga liga = new Liga("Liga UCU");

        //Se crean las divisiones:
        
        //divisionA
        Division divisionA = new Division("division A", 8);
        liga.agregarDivision(divisionA);

        //B 
        Division divisionB = new Division("Division B", 8);
        liga.agregarDivision(divisionB);

        
        //Se crean los equipos:
        
        //1
        Equipo peñarol = new Equipo("PRL","Peñarol", divisionA);  
        liga.agregarEquipoADivision(divisionA, peñarol);
        //2
        Equipo liverpool = new Equipo("LIV", "Liverpool", divisionA); 
        liga.agregarEquipoADivision(divisionA, liverpool);
        //3
        Equipo racing = new Equipo ("RCG", "Racing", divisionA);
        liga.agregarEquipoADivision(divisionA, racing);
        //4
        Equipo river = new Equipo ("RIV", "River", divisionA);
        liga.agregarEquipoADivision(divisionA, river);
        //5
        Equipo arsenal = new Equipo ("ARS", "Arsenal", divisionA); 
        liga.agregarEquipoADivision(divisionA, arsenal);
        //6
        Equipo palmeiras = new Equipo ("PLM", "Palmeiras", divisionA);
        liga.agregarEquipoADivision(divisionA, palmeiras);
        //7
        Equipo cerrito = new Equipo ("CRR", "Cerrito", divisionA);
        liga.agregarEquipoADivision(divisionA, cerrito);
        //8
        Equipo rocha = new Equipo ("RCH", "Rocha", divisionA);
        liga.agregarEquipoADivision(divisionA, rocha);
        //9
        Equipo cerro = new Equipo ("CER", "Cerro", divisionB);
        liga.agregarEquipoADivision(divisionB, cerro);
        //10
        Equipo rentistas = new Equipo ("REN", "Rentistas", divisionB);
        liga.agregarEquipoADivision(divisionB, rentistas);
        //11
        Equipo tabaré = new Equipo ("TAB", "Tabaré", divisionB);
        liga.agregarEquipoADivision(divisionB, tabaré);
        //12
        Equipo barcelona = new Equipo ("BAR", "Barcelona", divisionB);
        liga.agregarEquipoADivision(divisionB, barcelona);
        //13
        Equipo bilbao = new Equipo ("BIB", "Bilbao", divisionB);
        liga.agregarEquipoADivision(divisionB, bilbao);
        //14
        Equipo prime = new Equipo ("PRI", "Prime", divisionB);
        liga.agregarEquipoADivision(divisionB, prime);
        //15
        Equipo palermo = new Equipo ("PAL", "Palermo", divisionB);
        liga.agregarEquipoADivision(divisionB, palermo);
        //16
        Equipo lavalleja = new Equipo ("LVJ", "Lavalleja", divisionB);
        liga.agregarEquipoADivision(divisionB, lavalleja);

    //Se crean los jugadores:
    
    //1
        Jugador jugador1 = new Jugador("Pepe",20, "Delantero");
        liga.agregarJugadorAEquipo(peñarol, jugador1);
        Jugador jugador2 = new Jugador("Juan",25, "Mediocampista");
        liga.agregarJugadorAEquipo(peñarol, jugador2);
        Jugador jugador3 = new Jugador("Lucia",30, "Defensa");
        liga.agregarJugadorAEquipo(peñarol, jugador3);
        Jugador jugador4 = new Jugador("Amadea",23, "Golero");
        liga.agregarJugadorAEquipo(peñarol, jugador4);
        Jugador jugador5 = new Jugador("Sebastian",21, "Delantero");
        liga.agregarJugadorAEquipo(peñarol, jugador5);
    //2 
        Jugador jugador6 = new Jugador("Juana",28, "Mediocampista");
        liga.agregarJugadorAEquipo(liverpool, jugador6);
        Jugador jugador7 = new Jugador("Pedro",24, "Defensa");
        liga.agregarJugadorAEquipo(liverpool, jugador7);
        Jugador jugador8 = new Jugador("Amanda",20, "Delantero");
        liga.agregarJugadorAEquipo(liverpool, jugador8);
        Jugador jugador9 = new Jugador("Jose",21, "Golero");
        liga.agregarJugadorAEquipo(liverpool, jugador9);
        Jugador jugador10 = new Jugador("Clementina",24, "Defensa");
        liga.agregarJugadorAEquipo(liverpool, jugador10);
    //3
        Jugador jugador11 = new Jugador("Santiago",23, "Golero");
        liga.agregarJugadorAEquipo(racing, jugador11);
        Jugador jugador12 = new Jugador("Victoria",46, "Defensa");
        liga.agregarJugadorAEquipo(racing, jugador12);
        Jugador jugador13 = new Jugador("Luis",18, "Defensa");
        liga.agregarJugadorAEquipo(racing, jugador13);
        Jugador jugador14 = new Jugador("Pepe",20, "Delantero");
        liga.agregarJugadorAEquipo(racing, jugador14);
        Jugador jugador15 = new Jugador("Manuela",27, "Delantero");
        liga.agregarJugadorAEquipo(racing, jugador15);
    //4 
        Jugador jugador16 = new Jugador("Sebastian",28, "Golero");
        liga.agregarJugadorAEquipo(river, jugador16);
        Jugador jugador17 = new Jugador("Juan",19, "Delantero");
        liga.agregarJugadorAEquipo(river, jugador17);
        Jugador jugador18 = new Jugador("Nicolas",19, "Delantero");
        liga.agregarJugadorAEquipo(river, jugador18);
        Jugador jugador19 = new Jugador("Paulina",20, "Delantero");
        liga.agregarJugadorAEquipo(river, jugador19);
        Jugador jugador20 = new Jugador("Amadeo",30, "Delantero");
        liga.agregarJugadorAEquipo(river, jugador20);
    //5
        Jugador jugador21 = new Jugador("Joaquin",23, "Golero");
        liga.agregarJugadorAEquipo(arsenal, jugador21);
        Jugador jugador22 = new Jugador("Fernanda",22, "Defensa");
        liga.agregarJugadorAEquipo(arsenal, jugador22);
        Jugador jugador23 = new Jugador("Pepe",21, "Defensa");
        liga.agregarJugadorAEquipo(arsenal, jugador23);
        Jugador jugador24 = new Jugador("Thiago",20, "Defensa");
        liga.agregarJugadorAEquipo(arsenal, jugador24);
        Jugador jugador25 = new Jugador("Felipe",19, "Delantero");
        liga.agregarJugadorAEquipo(arsenal, jugador25);
    //6
        Jugador jugador26 = new Jugador("Martina",20, "Golero");
        liga.agregarJugadorAEquipo(palmeiras, jugador26);
        Jugador jugador27 = new Jugador("Gabriel",24, "Mediocampista");
        liga.agregarJugadorAEquipo(palmeiras, jugador27);
        Jugador jugador28 = new Jugador("Agustin",20, "Delantero");
        liga.agregarJugadorAEquipo(palmeiras, jugador28);
        Jugador jugador29 = new Jugador("Carlos",35, "Defensa");
        liga.agregarJugadorAEquipo(palmeiras, jugador29);
        Jugador jugador30 = new Jugador("Pepe",20, "Delantero");
        liga.agregarJugadorAEquipo(palmeiras, jugador30);
    //7 
        Jugador jugador31 = new Jugador("Martin",66, "Golero");
        liga.agregarJugadorAEquipo(cerrito, jugador31);
        Jugador jugador32 = new Jugador("Juliana",20, "Delantero");
        liga.agregarJugadorAEquipo(cerrito, jugador32);
        Jugador jugador33 = new Jugador("Milagros",20, "Delantero");
        liga.agregarJugadorAEquipo(cerrito, jugador33);
        Jugador jugador34 = new Jugador("Belen",20, "Delantero");
        liga.agregarJugadorAEquipo(cerrito, jugador34);
        Jugador jugador35 = new Jugador("Enzo",20, "Defensa");
        liga.agregarJugadorAEquipo(cerrito, jugador35);

    //8
        Jugador jugador36 = new Jugador("Joaquin",25, "Golero");
        liga.agregarJugadorAEquipo(rocha, jugador36);
        Jugador jugador37 = new Jugador("Lalo",50, "Delantero");
        liga.agregarJugadorAEquipo(rocha, jugador37);
        Jugador jugador38 = new Jugador("Milagros",40, "Defensa");
        liga.agregarJugadorAEquipo(rocha, jugador38);
        Jugador jugador39 = new Jugador("Javier",30, "Mediocampista");
        liga.agregarJugadorAEquipo(rocha, jugador39);
        Jugador jugador40 = new Jugador("Manuel",10, "Delantero");
        liga.agregarJugadorAEquipo(rocha, jugador40);

    //9
        Jugador jugador41 = new Jugador("Lisandro",14, "Delantero");
        liga.agregarJugadorAEquipo(cerro, jugador41);
        Jugador jugador42 = new Jugador("Diego",4, "Golero");
        liga.agregarJugadorAEquipo(cerro, jugador42);
        Jugador jugador43 = new Jugador("Lisandro",41, "Defensa");
        liga.agregarJugadorAEquipo(cerro, jugador43);
        Jugador jugador44 = new Jugador("Lautaro",15, "Golero");
        liga.agregarJugadorAEquipo(cerro, jugador44);
        Jugador jugador45 = new Jugador("Pablo",14, "Mediocampista");
        liga.agregarJugadorAEquipo(cerro, jugador45);

    //10
        Jugador jugador46 = new Jugador("Emiliano",14, "Delantero");
        liga.agregarJugadorAEquipo(rentistas, jugador46);
        Jugador jugador47 = new Jugador("Nicolas",3, "Golero");
        liga.agregarJugadorAEquipo(rentistas, jugador47);
        Jugador jugador48 = new Jugador("Lisandro",51, "Defensa");
        liga.agregarJugadorAEquipo(rentistas, jugador48);
        Jugador jugador49 = new Jugador("Cristian",15, "Defensa");
        liga.agregarJugadorAEquipo(rentistas, jugador49);
        Jugador jugador50 = new Jugador("Tiago",16, "Mediocampista");
        liga.agregarJugadorAEquipo(rentistas, jugador50);

    //11
        Jugador jugador51 = new Jugador("Ramiro",17, "Delantero");
        liga.agregarJugadorAEquipo(tabaré, jugador51);
        Jugador jugador52 = new Jugador("Franco",4, "Golero");
        liga.agregarJugadorAEquipo(tabaré, jugador52);
        Jugador jugador53 = new Jugador("Benjamin",41, "Defensa");
        liga.agregarJugadorAEquipo(tabaré, jugador53);
        Jugador jugador54 = new Jugador("Lautaro",15, "Defensa");
        liga.agregarJugadorAEquipo(tabaré, jugador54);
        Jugador jugador55 = new Jugador("Pablo",14, "Mediocampista");
        liga.agregarJugadorAEquipo(tabaré, jugador55);

    //12
        Jugador jugador56 = new Jugador("Martin",19, "Delantero");
        liga.agregarJugadorAEquipo(barcelona, jugador56);
        Jugador jugador57 = new Jugador("Diego",4, "Golero");
        liga.agregarJugadorAEquipo(barcelona, jugador57);
        Jugador jugador58 = new Jugador("Geronimo",44, "Defensa");
        liga.agregarJugadorAEquipo(barcelona, jugador58);
        Jugador jugador59 = new Jugador("Renato",15, "Defensa");
        liga.agregarJugadorAEquipo(barcelona, jugador59);
        Jugador jugador60 = new Jugador("Pablo",40, "Mediocampista");
        liga.agregarJugadorAEquipo(barcelona, jugador60);
    
    //13
        Jugador jugador61 = new Jugador("Lisandro",14, "Delantero");
        liga.agregarJugadorAEquipo(bilbao, jugador61);
        Jugador jugador62 = new Jugador("Diego",4, "Golero");
        liga.agregarJugadorAEquipo(bilbao, jugador62);
        Jugador jugador63 = new Jugador("Julian",41, "Defensa");
        liga.agregarJugadorAEquipo(bilbao, jugador63);
        Jugador jugador64 = new Jugador("Lautaro",15, "defensa");
        liga.agregarJugadorAEquipo(bilbao, jugador64);
        Jugador jugador65 = new Jugador("Paulo",34, "Mediocampista");
        liga.agregarJugadorAEquipo(bilbao, jugador65);
    
    //14
        Jugador jugador66 = new Jugador("Lisandro",84, "Delantero");
        liga.agregarJugadorAEquipo(prime, jugador66);
        Jugador jugador67 = new Jugador("Diego",24, "Golero");
        liga.agregarJugadorAEquipo(prime, jugador67);
        Jugador jugador68 = new Jugador("Manuel",41, "Defensa");
        liga.agregarJugadorAEquipo(prime, jugador68);
        Jugador jugador69 = new Jugador("Lautaro",15, "Defensa");
        liga.agregarJugadorAEquipo(prime, jugador69);
        Jugador jugador70 = new Jugador("Antonio",64, "Mediocampista");
        liga.agregarJugadorAEquipo(prime, jugador70);
    
    //15
        Jugador jugador71 = new Jugador("Marcos",14, "Delantero");
        liga.agregarJugadorAEquipo(palermo, jugador71);
        Jugador jugador72 = new Jugador("Nahuel",1, "Golero");
        liga.agregarJugadorAEquipo(palermo, jugador72);
        Jugador jugador73 = new Jugador("Walter",10, "Defensa");
        liga.agregarJugadorAEquipo(palermo, jugador73);
        Jugador jugador74 = new Jugador("Sergio",9, "Defensa");
        liga.agregarJugadorAEquipo(palermo, jugador74);
        Jugador jugador75 = new Jugador("Pablo",53, "Mediocampista");
        liga.agregarJugadorAEquipo(palermo, jugador75);

    //16
        Jugador jugador76 = new Jugador("Mauricio",37, "Delantero");
        liga.agregarJugadorAEquipo(lavalleja, jugador76);
        Jugador jugador77 = new Jugador("Matias",12, "Golero");
        liga.agregarJugadorAEquipo(lavalleja, jugador77);
        Jugador jugador78 = new Jugador("Leonardo",41, "Defensa");
        liga.agregarJugadorAEquipo(lavalleja, jugador78);
        Jugador jugador79 = new Jugador("Emanuel",35, "Defensa");
        liga.agregarJugadorAEquipo(lavalleja, jugador79);
        Jugador jugador80 = new Jugador("Pablo",140, "Mediocampista");
        liga.agregarJugadorAEquipo(lavalleja, jugador80);

        liga.programarPartidos(divisionA);
        liga.programarPartidos(divisionB);

        divisionA.jugarTodosLosPartidos();
        divisionB.jugarTodosLosPartidos();
        return liga;
        //Seccion de consola

        
    }   
}

 
    

  

