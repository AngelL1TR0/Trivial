# Trivial

##Problema 0 

Extraemos el codigo duplicado a un unico metodo "NuevaPosicionJugador"
al que llamamos desde ambos sitios.

Creamos test unitario "si_al_principio_saco_un_1_voy_a_casilla_1"

***
##Problema 1 

Creamos en TrivialTest el test unitario "minimo_dos_jugadores" y corregimos el test "true_es_true".
En gameLauncher.java corregimos el do while a un while solo y hacemos un if que hace que no se pueda jugar con menos de dos jugadores.  

***
##Problema 2

Editamos el test "Minimo_dos_Jugadores" y añadimos que sea como maximo seis, ahora se llama "Minimo_Dos_Jugadores_Y_Maximo_seis" y el assert pasa de assetFalse a assertTrue.
Editamos el metodo EsJugable en Game.java para que los jugadores puedan ser entre dos y 6 ( || ).
Editamos el println de gameLauncher para especificar los jugadores y añadimos dos mas para que se vea que acierta el juego, tambien, mecionamos el cambio de los "noGanador" a "ganador" en el ejercicio 1.

***
##Problema3

Editamos el metodo tirarDado en game.java los errores como llamar a un metodo dentro de un println y demás errores que hacia que el jugador no saliera de la casilla de castigo.

***
##Problema4

No hace falta hacer nada, ya que en el ejercicio 1 lo he editado por que no me cuadraba el "noGanador", el cambio se basa en cambiar el nombre de los metodos despues en el while que cree tambien. 
Posteriormente me he dado cuenta que en el metodo jugadorHaGanado habia un signo de exclamacion que evitaba que un jugador ganaba cuando tenia 6 monedas.
Y en el metodo respuestaIncorrecta devolvia true, cuando debia devolver false para dejar que un jugador salga de la casilla de castigo. 
En el metodo categoriaActual de Game.java he añadido un else antes de "Musica" ya que veia en las pruebas que no salian preguntas de musica, parece que ahora funciona mejor.

***
##Problema5

Creacion mediante refractores de los metodos: siguienteJugador y haAcertado, para hacer el metodo fueRespuestaCorrecta menos repetitivo.
Tambien he cambiado un return true a return ganador, que encaja mejor, al cambiar el retunr en el metodo el programa de varias pruebas de momento no ha fallado y siempre acaba la partida.

***
##Problema6

El metodo fueRespuestCorrecta ya esta del todo simplificado con el metodo hecho en el ejercicio 5, en este paso solo he puesto un metodo siguienteJugador en el metodo respuestaIncorrecta.

***
##Problema7

Para que no nos quedemos sin preguntas he cambiado los if del metodo categoriaActual, haciendo que cada pregunta tenga ilimitadas preguntas hasta que alguien gane.