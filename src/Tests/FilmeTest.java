package Tests;

import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.entretenimento.Filme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmeTest {

    Filme f;

    @BeforeEach
    public void start() {
        f = new Filme("F01", "focco", 2000, 140);
    }

    @Test
    void getTempoDurcao() {
        assertEquals(f.getTempoDurcao(), 140);
    }

    @Test
    void testToString() {
        assertEquals(f.toString(),"1;F01;focco;2000;140\n");
    }

    @Test
    void getTipo() {
        assertEquals(f.getTipo(), "1");
    }

    @Test
    void getPreco() {
        assertEquals(f.getPreco(), 6);
    }
}