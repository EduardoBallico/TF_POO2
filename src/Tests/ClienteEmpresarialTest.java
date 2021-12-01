package Tests;

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
    }

    @Test
    void getColaboradores() {
    }

    @Test
    void getNomeFantasia() {
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