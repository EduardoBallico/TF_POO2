package Tests.ClienteTests;

import AcmeFun.acesso.Acesso;
import AcmeFun.acesso.ListaDeAcesso;
import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import AcmeFun.cliente.ListaDeUsuarios;
import AcmeFun.entretenimento.EpisodioSerie;
import AcmeFun.entretenimento.Filme;
import AcmeFun.entretenimento.Jogo;
import AcmeFun.entretenimento.Serie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ListaDeUsuariosTest {

    ClienteEmpresarial cE;
    ClienteIndividual cN;
    ClienteIndividual cV;
    ListaDeUsuarios lU;

    @BeforeEach
    public void start(){
        cE = new ClienteEmpresarial("Focco", "focco@f.com", "123", "12123123123333", "Focco Solucoes");
        cN = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", null);
        cV = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", cE);
   }

    @Test
    void exiteUsuario() {

    }

    @Test
    void procuraUsuario() {
    }

    @Test
    void cadastraCliente() {
        //assertTrue(lU.cadastraCliente(cN),false);
    }

    @Test
    void clientesIndividuais() {
    }

    @Test
    void clientesIndividuaisVinculados() {
    }

    @Test
    void clientesIndividuaisNaoVinculados() {
    }

    @Test
    void clientesEmpresariais() {
    }

    @Test
    void testToString() {
    }
}