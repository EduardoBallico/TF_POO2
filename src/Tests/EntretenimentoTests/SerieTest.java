package Tests.EntretenimentoTests;

import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import AcmeFun.entretenimento.EpisodioSerie;
import AcmeFun.entretenimento.Jogo;
import AcmeFun.entretenimento.Serie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SerieTest {

    Serie serie;
    EpisodioSerie epSerie;

    @BeforeEach
    public void start() {
        serie = new Serie("111", "Friends", 1990, 2020);
        epSerie = new EpisodioSerie("222","Suits",1900,1,10,serie);
    }

    @Test
    void getAnoConclusao(){
        assertEquals(serie.getAnoConclusao(),2020);
    }

    @Test
    void getEpisodios() {
        serie.linkaEp(epSerie);
        assertEquals(serie.getEpisodios().get(0),epSerie);
    }

    //todo
    @Test
    void linkaEp() {
        serie.linkaEp(epSerie);
        assertEquals(serie.getEpisodios().get(0), epSerie);
    }

    @Test
    void testToString() {
        assertEquals(serie.toString(),"3;111;Friends;1990;2020\n");
    }

    @Test
    void getTipo() {
        assertEquals(serie.getTipo(),"3");
    }
}