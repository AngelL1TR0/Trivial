# Trivial

##Problema 0 

Extraemos el codigo duplicado a un unico metodo "NuevaPosicionJugador"
al que llamamos desde ambos sitios.

Creamos test unitario "si_al_principio_saco_un_1_voy_a_casilla_1"

***
##Problema 1 

Creamos en TrivialTest el test unitario "minimo_dos_jugadores" y corregimos el test "true_es_true"
En gameLauncher.java corregimos el do while a un while solo y hacemos un if que hace que no se pueda jugar con menos de dos jugadores  

***
###Problema 2

Editamos el test "Minimo_dos_Jugadores" y añadimos que sea como maximo seis, ahora se llama "Minimo_Dos_Jugadores_Y_Maximo_seis" y el assert pasa de assetFalse a assertTrue
Editamos el metodo EsJugable en Game.java para que los jugadores puedan ser entre dos y 6 (||)
Editamos el println de gameLauncher para especificar los jugadores y añadimos dos mas para que se vea que acierta el juego, tambien, mecionamos el cambio de los "noGanador" a "ganador" en el ejercicio 1
