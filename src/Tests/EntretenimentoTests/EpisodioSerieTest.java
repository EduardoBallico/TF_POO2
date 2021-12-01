package Tests.EntretenimentoTests;

import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import AcmeFun.entretenimento.EpisodioSerie;
import AcmeFun.entretenimento.Serie;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class EpisodioSerieTest {

    EpisodioSerie eps;
    Serie serie;

    @BeforeEach
    public void start(){
         eps = new EpisodioSerie("111","Friends",1900,1,10,serie);
         serie = new Serie("111", "Friends", 1990, 2020);
    }

    @org.junit.jupiter.api.Test
    void getNumTemporada() {
        assertEquals(eps.getNumTemporada(),1);
    }

    @org.junit.jupiter.api.Test
    void getNumEpisodio() {
        assertEquals(eps.getNumEpisodio(),10);
    }

    //todo
    @org.junit.jupiter.api.Test
    void getSerie() {
       //assertEquals(eps.getSerie(),null);
    }

    //todo
    @org.junit.jupiter.api.Test
    void testToString() {
        //assertEquals(eps.toString(),null);
    }

    @org.junit.jupiter.api.Test
    void getTipo() {
        assertEquals(eps.getTipo(),"4");
    }

    @org.junit.jupiter.api.Test
    void getPreco() {
        assertEquals(eps.getPreco(),4);
    }
}