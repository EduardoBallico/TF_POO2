package Tests.AcessoTests;

import AcmeFun.acesso.Acesso;
import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import AcmeFun.entretenimento.Jogo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class AcessoTest {

    Jogo jogo;
    ClienteEmpresarial cE;
    ClienteIndividual cN;
    ClienteIndividual cV;
    Acesso ac;

    String dataHoraMinuto = "12/11/2020;03:55";
    LocalDateTime dataConvertida = LocalDateTime.parse(dataHoraMinuto,DateTimeFormatter.ofPattern("dd/MM/yyyy;HH:mm"));

    @BeforeEach
    public void start(){
        cE = new ClienteEmpresarial("Focco", "focco@f.com", "123", "12123123123333", "Focco Solucoes");
        cN = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", null);
        cV = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", cE);
        jogo = new Jogo("222","COD",2000,"Call Of Duty","Shooter");
        ac = new Acesso(cN,jogo, dataConvertida);
    }

    @Test
    void getCliente() {
        assertEquals(ac.getCliente(),cN);
    }

    @Test
    void getEntretenimento() {
        assertEquals(ac.getEntretenimento(),jogo);
    }

    @Test
    void getDataHora() {
        assertEquals(ac.getDataHora(),dataConvertida);
    }

    @Test
    void testToString() {
        assertEquals(ac.toString(),"12/11/2020;03:55;mts@email.com;222");
    }
}