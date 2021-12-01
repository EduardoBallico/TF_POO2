package Tests;

import AcmeFun.entretenimento.EpisodioSerie;
import AcmeFun.entretenimento.Jogo;
import AcmeFun.entretenimento.Serie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JogoTest {

    Jogo jogo;

    @BeforeEach
    public void start() {
        jogo = new Jogo("222","COD",2000,"Call Of Duty","Shooter");
    }

    @Test
    void getTituloOriginal() {
        assertEquals(jogo.getTituloOriginal(),"Call Of Duty");
    }

    @Test
    void getGenero() {
        assertEquals(jogo.getGenero(),"Shooter");
    }

    @Test
    void testToString() {
        assertEquals(jogo.toString(),"2;222;COD;2000;Call Of Duty;Shooter\n");
    }

    @Test
    void getTipo() {
        assertEquals(jogo.getTipo(),"2");
    }

    @Test
    void getPreco() {
        assertEquals(jogo.getPreco(),8);
    }
}