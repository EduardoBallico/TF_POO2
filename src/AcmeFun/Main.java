package AcmeFun;

import AcmeFun.acesso.CatalogoAcesso;
import AcmeFun.cliente.*;
import AcmeFun.entretenimento.*;

public class Main {

    public  CatalogoUsuarios catalogoUsuarios;

    public static void main(String[] args) {
        Main main = new Main();
        main.iniciar();
        main.executa();
    }

    public void iniciar(){
        catalogoUsuarios = new CatalogoUsuarios();
        CatalogoEntretenimento catalogoEntretenimento = new CatalogoEntretenimento();
        CatalogoAcesso catalogoAcesso = new CatalogoAcesso();

        Administrador adm = new Administrador("administracao@mail.com","admin123");

        catalogoUsuarios.addClienteValido(adm);

        Arquivo arquivo = new Arquivo();
        arquivo.readFileEntretenimento(Arquivo.getArquivoEntretenimentos());
        arquivo.readFileCliente(Arquivo.getArquivoClientes());
        arquivo.readFileAcessos(Arquivo.getArquivoAcessos());
    }

    public void executa(){

    }
}