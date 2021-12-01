package Tests.ClienteTests;

import AcmeFun.cliente.Cliente;
import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioTest {

    ClienteIndividual cN;

    @BeforeEach
    public void start(){
        cN = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", null);
    }

    @Test
    void getEmail() {
        assertEquals(cN.getEmail(),"mts@email.com");
    }

    @Test
    void getSenha() {
        assertEquals(cN.getSenha(),"mts");
    }
}