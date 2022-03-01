package smellytrivial;

import java.util.ArrayList;
import java.util.LinkedList;

public class Game {
    ArrayList jugadores = new ArrayList();
    int[] posiciones = new int[6];
    int[] monederos = new int[6];
    boolean[] enCasillaCastigo = new boolean[6];

    LinkedList preguntasCultura = new LinkedList();
    LinkedList preguntasCiencias = new LinkedList();
    LinkedList preguntasDeportes = new LinkedList();
    LinkedList preguntasMusica = new LinkedList();

    int jugadorActual = 0;
    boolean estaSaliendoDeLaCarcel;

    public  Game(){
        for (int i = 0; i < 50; i++) {
            preguntasCultura.addLast("Pregunta de Cultura " + i);
            preguntasCiencias.addLast(("Pregunta de Ciencias " + i));
            preguntasDeportes.addLast(("Pregunta de Deportes " + i));
            preguntasMusica.addLast(crearPreguntaMusica(i));
        }
    }

    public String crearPreguntaMusica(int index){
        return "Pregunta de Música " + index;
    }

    public boolean esJugable() {
        return (cuantosJugadores() >= 2 || cuantosJugadores() <= 6);
    }

    public boolean agregar(String playerName) {


        jugadores.add(playerName);
        posiciones[cuantosJugadores()] = 0;
        monederos[cuantosJugadores()] = 0;
        enCasillaCastigo[cuantosJugadores()] = false;

        System.out.println(playerName + " se ha unido a la partida");
        System.out.println("Es el jugador número " + jugadores.size());
        return true;
    }

    public int cuantosJugadores() {
        return jugadores.size();
    }

    public void tirarDado(int puntosDado) {
        System.out.println(jugadores.get(jugadorActual) + " es el jugador actual");
        System.out.println("Ha sacado un " + puntosDado);

        if (enCasillaCastigo[jugadorActual]) {
            if (puntosDado % 2 != 0) {
                estaSaliendoDeLaCarcel = true;
                enCasillaCastigo[jugadorActual] = false;

                System.out.println(jugadores.get(jugadorActual) + " sale de la casilla de castigo");
                posiciones[jugadorActual] = posiciones[jugadorActual] + puntosDado;
                if (posiciones[jugadorActual] > 11) posiciones[jugadorActual] = posiciones[jugadorActual] - 12;

                nuevaPosicionJugador();
                System.out.println("La categoría es " + categoriaActual());
                hacerPregunta();
            }
            else {
                System.out.println(jugadores.get(jugadorActual) + " no sale de la casilla de castigo");
                estaSaliendoDeLaCarcel = false;
            }

        } else {

            posiciones[jugadorActual] = posiciones[jugadorActual] + puntosDado;
            if (posiciones[jugadorActual] > 11) posiciones[jugadorActual] = posiciones[jugadorActual] - 12;

            nuevaPosicionJugador();
            System.out.println("La categoría es " + categoriaActual());
            hacerPregunta();
        }

    }

    public String nuevaPosicionJugador() {
        return "La nueva posicion de "
                + jugadores.get(jugadorActual)
                + " es "
                + posiciones[jugadorActual];
    }

    private void hacerPregunta() {
        if (categoriaActual() == "Cultura popular")
            System.out.println(preguntasCultura.removeFirst());
        if (categoriaActual() == "Ciencias")
            System.out.println(preguntasCiencias.removeFirst());
        if (categoriaActual() == "Deportes")
            System.out.println(preguntasDeportes.removeFirst());
        if (categoriaActual() == "Música")
            System.out.println(preguntasMusica.removeFirst());
    }


    private String categoriaActual() {
        if (posiciones[jugadorActual] == 0 || posiciones[jugadorActual] % 4 == 0) return "Cultura popular";
        if (posiciones[jugadorActual] == 1 || posiciones[jugadorActual] % 3 == 0) return "Ciencias";
        if (posiciones[jugadorActual] == 2 || posiciones[jugadorActual] % 5  == 0) return "Deportes";
        else return "Música";

    }

    public boolean fueRespuestaCorrecta() {
        if (enCasillaCastigo[jugadorActual]){
            if (estaSaliendoDeLaCarcel) {
                boolean ganador = haAcertado();
                siguienteJugador();
                return ganador;
            } else {
               boolean ganador = haAcertado();
                siguienteJugador();
                return ganador;
            }

        } else {
            boolean ganador = haAcertado();
            siguienteJugador();
            return ganador;
        }
    }

    private boolean haAcertado() {
        System.out.println("Respuesta correcta!!!!");
        monederos[jugadorActual]++;
        System.out.println(jugadores.get(jugadorActual)
                + " ahora tiene "
                + monederos[jugadorActual]
                + " monedas doradas.");
        boolean ganador = jugadorHaGanado();
        return ganador;
    }

    private void siguienteJugador() {
        jugadorActual++;
        if (jugadorActual == jugadores.size()) jugadorActual = 0;
    }

    public boolean respuestaIncorrecta(){
        System.out.println("Respuesta incorrecta");
        System.out.println(jugadores.get(jugadorActual)+ " va a la casilla de castigo");
        enCasillaCastigo[jugadorActual] = true;

       siguienteJugador();
        return false;
    }


    private boolean jugadorHaGanado() {
        return (monederos[jugadorActual] == 6);
    }
}
