package Tests.ClienteTests;

import AcmeFun.acesso.Acesso;
import AcmeFun.cliente.Cliente;
import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import AcmeFun.entretenimento.EpisodioSerie;
import AcmeFun.entretenimento.Filme;
import AcmeFun.entretenimento.Jogo;
import AcmeFun.entretenimento.Serie;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    Jogo jogo;
    Filme f1;
    Serie serie;
    EpisodioSerie epSerie;
    ClienteEmpresarial cE;
    ClienteIndividual cN;
    ClienteIndividual cV;
    String dataHoraMinuto = "12/11/2020;03:55";
    LocalDateTime dataConvertida = LocalDateTime.parse(dataHoraMinuto, DateTimeFormatter.ofPattern("dd/MM/yyyy;HH:mm"));
    Acesso ac, ac2, ac3;

    @BeforeEach
    public void start(){
        serie = new Serie("111", "Friends", 1990, 2020);
        epSerie = new EpisodioSerie("222","Suits",1900,1,10,serie);
        serie.linkaEp(epSerie);
        f1 = new Filme("F05", "focco", 2000, 140);
        jogo = new Jogo("222","COD",2000,"Call Of Duty","Shooter");
        cE = new ClienteEmpresarial("Focco", "focco@f.com", "123", "12123123123333", "Focco Solucoes");
        cN = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", null);
        cV = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", cE);
        ac = new Acesso(cN,jogo, dataConvertida);
        ac2 = new Acesso(cN,f1,dataConvertida);
        ac3 = new Acesso(cN,serie,dataConvertida);


    }

    @Test
    void getNome() {
        assertEquals(cN.getNome(),"mts");
    }

    //todo
    @Test
    void getAcessosDoMes() {

        System.out.println(dataConvertida);
        System.out.println(ac.getDataHora().getYear());
        System.out.println(ac.getDataHora().getMonth().getValue());

        assertEquals(cN.getAcessosDoMes(2020,11), 40);
    }

    //todo
    @Test
    void cobrancaMensal() {
        assertEquals(cN.cobrancaMensal(2020,11), 40);
    }
}