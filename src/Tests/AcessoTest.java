package Tests;

import AcmeFun.acesso.Acesso;
import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import AcmeFun.entretenimento.Jogo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AcessoTest {

    Jogo jogo;
    ClienteEmpresarial cE;
    ClienteIndividual cN;
    ClienteIndividual cV;
    Acesso ac;

    @BeforeEach
    public void start(){
        cE = new ClienteEmpresarial("Focco", "focco@f.com", "123", "12123123123333", "Focco Solucoes");
        cN = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", null);
        cV = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", cE);
        jogo = new Jogo("222","COD",2000,"Call Of Duty","Shooter");
        ac = new Acesso(cN,jogo);
    }

    @Test
    void getCliente() {
        assertEquals(ac.getCliente(),cN);
    }

    @Test
    void getEntretenimento() {
        assertEquals(ac.getEntretenimento(),jogo);
    }

    //todo
    @Test
    void getDataHora() {
        assertEquals(ac.getDataHora(),"2021-12-01T11:28:36.890639");
    }

    //todo
    @Test
    void getPrecoDoAcesso() {
    }

    //todo
    @Test
    void testToString() {
        assertEquals(ac.toString(),"01/12/2021;11:32;mts@email.com;222");
    }
}