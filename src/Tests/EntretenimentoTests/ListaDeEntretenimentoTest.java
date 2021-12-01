package Tests.EntretenimentoTests;

import AcmeFun.entretenimento.Entretenimento;
import AcmeFun.entretenimento.Filme;
import AcmeFun.entretenimento.ListaDeEntretenimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

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
        ArrayList<Entretenimento> ent = new ArrayList<>();
        ent.add(f);
        lE.addEntretenimento(f,false);
        assertEquals(lE.pesquisaTitulo("focco"), ent.get(0));
    }

    //todo
    @Test
    void pesquisaAnoLanc() {
        ArrayList<Entretenimento> ent = new ArrayList<>();
        ent.add(f);
        lE.addEntretenimento(f,false);
        assertEquals(lE.pesquisaAnoLanc(2000), ent.get(0));
    }

    //todo
    @Test
    void pesquisaCodigo() {
        ArrayList<Entretenimento> ent = new ArrayList<>();
        ent.add(f);
        lE.addEntretenimento(f,false);
        assertEquals(lE.pesquisaCodigo("F01"), ent.get(0));
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