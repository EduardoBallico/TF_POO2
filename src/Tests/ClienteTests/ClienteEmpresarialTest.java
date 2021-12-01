package Tests.ClienteTests;

import AcmeFun.acesso.Acesso;
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

class ClienteEmpresarialTest {

    Jogo jogo;
    Filme f1;
    Serie serie;
    EpisodioSerie epSerie;
    ClienteEmpresarial cE;
    ClienteIndividual cN;
    ClienteIndividual cV;
    Acesso ac, ac2, ac3;
    String dataHoraMinuto = "12/11/2020;03:55";
    LocalDateTime dataConvertida = LocalDateTime.parse(dataHoraMinuto, DateTimeFormatter.ofPattern("dd/MM/yyyy;HH:mm"));


    @BeforeEach
    public void start(){
        serie = new Serie("111", "Friends", 1990, 2020);
        epSerie = new EpisodioSerie("222","Suits",1900,1,10,serie);
        serie.linkaEp(epSerie);
        f1 = new Filme("F05", "focco", 2000, 140);
        cE = new ClienteEmpresarial("Focco", "focco@f.com", "123", "12123123123333", "Focco Solucoes");
        cN = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", null);
        cV = new ClienteIndividual("mts", "mts@email.com","mts", "12312312311", cE);
        ac = new Acesso(cN,jogo, dataConvertida);
        ac2 = new Acesso(cN,f1,dataConvertida);
        ac3 = new Acesso(cN,serie,dataConvertida);
    }

    @Test
    void getCnpj() {
        assertEquals(cE.getCnpj(),"12123123123333");
    }

    //todo
    @Test
    void getColaboradores() {
    }

    @Test
    void adicionaColaborador() {
        cE.adicionaColaborador(cV);
        assertEquals(cE.getColaboradores().get(0), cV);
    }

    @Test
    void getNomeFantasia() {
        assertEquals(cE.getNomeFantasia(),"Focco Solucoes");
    }

    //todo
    @Test
    void cobrancaMensal() {
        assertEquals(cN.cobrancaMensal(2020,11), 40);
    }

    @Test
    void testToString() {
        cE.toString();
        assertEquals("2;Focco;focco@f.com;123;12123123123333;Focco Solucoes\n",cE.toString());
    }

    @Test
    void getTipo() {
        assertEquals(cE.getTipo(), "2");
    }
}