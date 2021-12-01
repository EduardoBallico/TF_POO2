package AcmeFun.cliente;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteIndividualTest {

    @BeforeEach
    public void start(){
        ClienteEmpresarial cE = new ClienteEmpresarial("Focco", "focco@f.com", "123", "12123123123333", "Focco Solucoes");
        ClienteIndividual cN = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", null);
        ClienteIndividual cV = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", cE);
    }

    @Test
    void getCpf() {

    }

    @Test
    void getEmpresa() {
    }

    @Test
    void cobrancaMensal() {
    }

    @Test
    void testToString() {
    }

    @Test
    void defineTipo() {
    }
}