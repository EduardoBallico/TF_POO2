package Tests.AcessoTests;

import AcmeFun.acesso.Acesso;
import AcmeFun.acesso.ListaDeAcesso;
import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import AcmeFun.entretenimento.Filme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListaDeAcessoTest {

    ListaDeAcesso lA;
    ClienteEmpresarial cE;
    ClienteIndividual cN;
    ClienteIndividual cV;
    Filme f;
    Acesso acV;
    Acesso acN;

    @BeforeEach
    public void start(){
        lA = new ListaDeAcesso();
        cE = new ClienteEmpresarial("Focco", "focco@f.com", "123", "12123123123333", "Focco Solucoes");
        cN = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", null);
        cV = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", cE);
        f = new Filme("F01","bibi", 2003, 19);
        acV = new Acesso(cV,f);
        acN = new Acesso(cN,f);
    }

    @Test
    void getCatalogo() {
    }

    @Test
    void adicionaAcesso() {
        assertTrue(lA.adicionaAcesso(acN,false));
    }

    @Test
    void getAcessosMes() {
    }

    @Test
    void getAcessosMesPt2() {
    }

    @Test
    void getAcessosMesCliente() {
    }

    @Test
    void getAcessosMesClientePt2() {
    }

    @Test
    void getCobrancaTotal() {
    }

    @Test
    void getCobrancaCliente() {
    }

    @Test
    void getCobrancaClientePt2() {
    }

    @Test
    void testToString() {
    }

    @Test
    void testToStringPt2() {
    }
}