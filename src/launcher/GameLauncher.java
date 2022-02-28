package launcher;


import smellytrivial.Game;

import java.util.Random;

public class GameLauncher {

    private static boolean ganador;


    public static void main(String[] args) {
        Game juego = new Game();

        juego.agregar("Maria");

        Random rand = new Random();

        ganador = false;
        boolean esJugable = juego.esJugable();
        if (!esJugable) {
            System.out.println("Las partidas deben tener 2 jugadores como minimo");
        }


        while (juego.esJugable() && !ganador){

            juego.tirarDado(rand.nextInt(5) + 1);

            if (rand.nextInt(9) == 7) {
                ganador = juego.respuestaIncorrecta();
            } else {
                ganador = juego.fueRespuestaCorrecta();
            }
        }
    }
}
