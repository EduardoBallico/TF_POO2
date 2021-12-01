package Tests.ClienteTests;

import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteEmpresarialTest {

    ClienteEmpresarial cE;
    ClienteIndividual cN;
    ClienteIndividual cV;

    @BeforeEach
    public void start(){
        cE = new ClienteEmpresarial("Focco", "focco@f.com", "123", "12123123123333", "Focco Solucoes");
        cN = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", null);
        cV = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", cE);
    }

    @Test
    void getCnpj() {
        assertEquals(cE.getCnpj(),"12123123123333");
    }

    //todo
    @Test
    void getColaboradores() {
    }

    @Test
    void adicionaColaborador() {
        cE.adicionaColaborador(cV);
        assertEquals(cE.getColaboradores().get(0), cV);
    }

    @Test
    void getNomeFantasia() {
        assertEquals(cE.getNomeFantasia(),"Focco Solucoes");
    }

    //todo
    @Test
    void cobrancaMensal() {
        //assertEquals();
    }

    @Test
    void testToString() {
        //assertEquals();
    }

    @Test
    void getTipo() {
        assertEquals(cE.getTipo(), "2");
    }
}