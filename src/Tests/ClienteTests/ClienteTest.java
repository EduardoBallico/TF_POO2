package Tests.ClienteTests;

import AcmeFun.cliente.Cliente;
import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    ClienteEmpresarial cE;
    ClienteIndividual cN;
    ClienteIndividual cV;
    Cliente c;

    @BeforeEach
    public void start(){
        cE = new ClienteEmpresarial("Focco", "focco@f.com", "123", "12123123123333", "Focco Solucoes");
        cN = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", null);
        cV = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", cE);
    }

    @Test
    void getNome() {
        assertEquals(cN.getNome(),"mts");
    }
    //todo
    @Test
    void getAcessosDoMes() {

    }
    //todo
    @Test
    void cobrancaMensal() {

    }
}