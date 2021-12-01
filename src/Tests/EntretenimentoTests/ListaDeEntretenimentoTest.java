package Tests.EntretenimentoTests;

import AcmeFun.entretenimento.Filme;
import AcmeFun.entretenimento.ListaDeEntretenimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDeEntretenimentoTest {

    Filme f;
    ListaDeEntretenimento lE;

    @BeforeEach
    public void start() {
        f = new Filme("F01", "focco", 2000, 140);
        lE = new ListaDeEntretenimento();
    }

    @Test
    void getEntretenimentos() {
        //todo
    }

    @Test
    void getUltimaConsulta() {
    }

    @Test
    void verificaCodigo() {
    }

    @Test
    void addEntretenimento() {
        assertTrue(lE.addEntretenimento(f,false));
    }

    //todo
    @Test
    void pesquisaTitulo() {
        lE.addEntretenimento(f,false);
        assertEquals(lE.pesquisaTitulo("focco"), lE.getEntretenimentos().get(0));
    }

    //todo
    @Test
    void pesquisaAnoLanc() {
        lE.addEntretenimento(f,false);
        assertEquals(lE.pesquisaAnoLanc(2000), lE.getEntretenimentos().get(0));
    }

    //todo
    @Test
    void pesquisaCodigo() {
        lE.addEntretenimento(f,false);
        assertEquals(lE.pesquisaCodigo("F01"), lE.getEntretenimentos().get(0));
    }

    //todo
    @Test
    void ordenaTitulo() {
    }

    //todo
    @Test
    void ordenaAno() {
    }

    @Test
    void testToString() {
        lE.addEntretenimento(f,false);
        assertEquals(lE.toString(),"Cadastrado Entretenimento: 1;F01;focco;2000;140\n\n");
    }
}