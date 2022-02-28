import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import smellytrivial.Game;

public class TrivialTests {
    @Test
    public void true_is_true(){
        Assertions.assertTrue(true);
    }

    @Test
    public void crear_Game(){
        Game trivial = new Game();
    }

    @Test
    public void si_al_principio_saco_un_1_voy_a_casilla_1(){
        //Arrange
        Game sut = new Game();
        sut.agregar("Maria");
        sut.agregar("Juan");

        sut.tirarDado(1);

        String expected = "La nueva posicion de Maria es 1";

        //Act
        String actual = sut.nuevaPosicionJugador();

        //Assert
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void minimo_Dos_Jugadores_Y_Maximo_seis() {
        Game trivial = new Game();
        boolean esJugable = trivial.esJugable();
        Assertions.assertTrue(esJugable);
    }
}
