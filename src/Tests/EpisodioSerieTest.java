package Tests;

import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class EpisodioSerieTest {

    ClienteEmpresarial cE;
    ClienteIndividual cN;
    ClienteIndividual cV;

    @BeforeEach
    public void start(){
        cE = new ClienteEmpresarial("Focco", "focco@f.com", "123", "12123123123333", "Focco Solucoes");
        cN = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", null);
        cV = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", cE);
    }

    @org.junit.jupiter.api.Test
    void getNumTemporada() {
        //assertEquals();
    }

    @org.junit.jupiter.api.Test
    void getNumEpisodio() {
        //assertEquals();
    }

    @org.junit.jupiter.api.Test
    void getSerie() {
        //assertEquals();
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        //assertEquals();
    }

    @org.junit.jupiter.api.Test
    void getTipo() {
        //assertEquals();
    }
}