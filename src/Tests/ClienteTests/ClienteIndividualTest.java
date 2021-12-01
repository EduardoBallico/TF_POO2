package Tests.ClienteTests;

import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteIndividualTest {

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
    void getCpf() {
        assertEquals(cN.getCpf(),"12312312311");
    }

    @Test
    void getEmpresa() {
        assertEquals(cV.getEmpresa(), cE);
    }

    //todo
    @Test
    void cobrancaMensal() {
    }

    @Test
    void testToString() {
        assertEquals("1;mts;mts@email.com;mts;12312312311", cN.toString());
    }

    @Test
    void defineTipo() {
        assertEquals(cV.getTipo(), "3");
    }
}