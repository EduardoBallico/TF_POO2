package Tests;

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

    @Test
    void pesquisaTitulo() {
    }

    @Test
    void pesquisaAnoLanc() {
    }

    @Test
    void pesquisaCodigo() {
    }

    @Test
    void ordenaTitulo() {
    }

    @Test
    void ordenaAno() {
    }

    @Test
    void testToString() {
    }
}