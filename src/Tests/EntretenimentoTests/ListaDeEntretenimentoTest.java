package Tests.EntretenimentoTests;

import AcmeFun.entretenimento.Entretenimento;
import AcmeFun.entretenimento.Filme;
import AcmeFun.entretenimento.ListaDeEntretenimento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListaDeEntretenimentoTest {

    Filme f1;
    Filme f2;
    Filme f3;
    ListaDeEntretenimento lE;

    @BeforeEach
    public void start() {
        f1 = new Filme("F05", "focco", 2000, 140);
        f2 = new Filme("F06", "mts", 2000, 120);
        f3 = new Filme("F07", "focco", 2002, 120);
        lE = new ListaDeEntretenimento();
    }

    @Test
    void getUltimaConsulta() {
    }

    @Test
    void verificaCodigo() {
    }

    @Test
    void addEntretenimento() {
        Filme f = new Filme("F0","teste",2100,150);
        assertTrue(lE.addEntretenimento(f,false));
    }

    @Test
    void pesquisaTitulo() {
        ArrayList<Entretenimento> ent = new ArrayList<>();
        ent.add(f1);
        lE.addEntretenimento(f1,false);
        lE.pesquisaTitulo("focco");
        assertEquals(lE.getUltimaConsulta().get(0).toString(), ent.get(0).toString());
    }

    @Test
    void pesquisaAnoLanc() {
        ArrayList<Entretenimento> ent = new ArrayList<>();
        ent.add(f1);
        lE.addEntretenimento(f1,false);
        assertEquals(lE.pesquisaAnoLanc(2000).get(0).toString(), ent.get(0).toString());
    }

    @Test
    void pesquisaCodigo() {

        lE.addEntretenimento(f1,false);
        assertEquals(lE.pesquisaCodigo("F05"), f1);
    }

    @Test
    void ordenaTitulo() {
        ArrayList<Entretenimento> ent = new ArrayList<>();
        ent.add(f1);
        ent.add(f2);

        lE.addEntretenimento(f2,false);
        lE.addEntretenimento(f1,false);
        lE.pesquisaAnoLanc(2000);

        assertEquals(f1.toString(), lE.ordenaTitulo().get(0).toString());
    }

    //todo
    @Test
    void ordenaAno() {
        ArrayList<Entretenimento> ent = new ArrayList<>();
        ent.add(f1);
        ent.add(f3);

        lE.addEntretenimento(f2,false);
        lE.addEntretenimento(f1,false);
        lE.pesquisaTitulo("focco");

        assertEquals(f1, lE.ordenaAno().get(0));
    }

    @Test
    void testToString() {
        lE.addEntretenimento(f1,false);
        assertEquals(lE.toString(),"Cadastrado Entretenimento: 1;F05;focco;2000;140\n\n");
    }
}