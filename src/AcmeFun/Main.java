package AcmeFun;

import AcmeFun.acesso.Acesso;
import AcmeFun.acesso.CatalogoAcesso;
import AcmeFun.cliente.*;
import AcmeFun.entretenimento.*;

public class Main {

    public static void main(String[] args) {
        //inicializaCadastro();
        inicializaPorArquivo();
    }

    public static void inicializaPorArquivo(){
        CatalogoUsuarios catalogoUsuarios = new CatalogoUsuarios();
        CatalogoEntretenimento catalogoEntretenimento = new CatalogoEntretenimento();
        CatalogoAcesso catalogoAcesso = new CatalogoAcesso();
        Administrador adm = new Administrador("administracao@mail.com","admin123");
        catalogoUsuarios.addClienteValido(adm);


        Arquivo arquivo = new Arquivo();
        //arquivo.readFileEntretenimento(Arquivo.getArquivoEntretenimentos());
        //arquivo.readFileCliente(Arquivo.getArquivoClientes());
        //arquivo.readFileAcessos(Arquivo.getArquivoAcessos());
    }

    public static void inicializaCadastro(){
        CatalogoUsuarios catalogoUsuarios = new CatalogoUsuarios();
        CatalogoEntretenimento catalogoEntretenimento = new CatalogoEntretenimento();
        CatalogoAcesso catalogoAcesso = new CatalogoAcesso();

        Administrador adm = new Administrador("administracao@mail.com","admin123");

        ClienteEmpresarial cliente1 = new ClienteEmpresarial(
                "Coca Cola","coca@gmail.com","coca123","12345678901234","Coca");
        Usuario cliente2 = new ClienteIndividual(
                "Paulo Brito","paulo@gmail.com","brito123","99999999999",cliente1);
        Usuario cliente3 = new ClienteIndividual(
                "Ronaldo","ronaldo@gmail.com","ron123","11111111111",null);




        Entretenimento entretenimento1 = new Filme(
                "1","Star Wars",1990,123);
        Entretenimento entretenimento2 = new Jogo(
                "2","Crash",2010,"Crash Bandiccot","Ação");
        Serie entretenimento3 = new Serie(
                "3","The Office",2001,2009);
        Entretenimento entretenimento4 = new EpisodioSerie(
                "4","Episodio1",2001,2,1,entretenimento3);
        Entretenimento entretenimento5 = new Filme(
                "5","Star Wars 2",1991,123);
        Entretenimento entretenimento6 = new Jogo(
                "6","Crash 2",2011,"Crash Bandicoot 2","Ação");
        Entretenimento entretenimento7 = new Jogo(
                "7","Avatar",2011,"Avatar","Ação");
        Serie serie1 = new Serie(
                "7","Pokemon",2001,2009);
        Serie serie2 = new Serie(
                "8","Round6",2001,2009);
        Serie serie3 = new Serie(
                "9","Suits",2001,2009);

        catalogoUsuarios.addClienteValido(cliente1);
        catalogoUsuarios.addClienteValido(cliente2);
        catalogoUsuarios.addClienteValido(cliente3);
        catalogoUsuarios.addClienteValido(adm);

        catalogoEntretenimento.addEntretenimentoValido(serie1);
        catalogoEntretenimento.addEntretenimentoValido(serie2);
        catalogoEntretenimento.addEntretenimentoValido(serie3);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento1);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento2);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento3);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento4);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento5);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento6);
        catalogoEntretenimento.addEntretenimentoValido(entretenimento7);

        Acesso acesso1 = new Acesso((Cliente)cliente2,entretenimento2);
        Acesso acesso2 = new Acesso((Cliente)cliente2,entretenimento4);
        Acesso acesso3 = new Acesso((Cliente)cliente3,entretenimento2);
        Acesso acesso4 = new Acesso((Cliente)cliente3,entretenimento2);

        catalogoAcesso.addAcesso(acesso1);
        catalogoAcesso.addAcesso(acesso2);
        catalogoAcesso.addAcesso(acesso3);
        catalogoAcesso.addAcesso(acesso4);

    }
}