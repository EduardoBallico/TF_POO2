package Tests.ClienteTests;

import AcmeFun.cliente.Administrador;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdministradorTest {

    Administrador adm;

    @BeforeEach
    public void start(){
        adm = new Administrador("mts@email.com","mts");
    }

    @Test
    void getTipo() {
        assertNull(adm.getTipo());
    }

    @Test
    void testToString(){
        assertNull(adm.toString());
    }
}