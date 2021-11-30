package AcmeFun;

import AcmeFun.acesso.CatalogoAcesso;
import AcmeFun.cliente.*;
import AcmeFun.entretenimento.*;

import java.util.Scanner;

public class Main {

    public CatalogoUsuarios catalogoUsuarios;
    public CatalogoEntretenimento catalogoEntretenimento;
    public CatalogoAcesso catalogoAcesso;

    public Usuario usuarioAtivo;

    public static void main(String[] args) {
        Main main = new Main();
        main.iniciar();
        while(true){
            main.executaLogin();
            if(main.usuarioAtivo instanceof Administrador)
                main.executaAdm();
            else
                main.executaUser();
        }
    }

    public void iniciar(){
        catalogoUsuarios = new CatalogoUsuarios();
        catalogoEntretenimento = new CatalogoEntretenimento();
        catalogoAcesso = new CatalogoAcesso();

        Administrador adm = new Administrador("administracao@mail.com","admin123");

        catalogoUsuarios.cadastraCliente(adm, false);

        Arquivo.readFileEntretenimento(Arquivo.getArquivoEntretenimentos());
        Arquivo.readFileCliente(Arquivo.getArquivoClientes());
        Arquivo.readFileAcessos(Arquivo.getArquivoAcessos());
    }

    public Usuario fazLogin(String email, String senha){
        Usuario u = catalogoUsuarios.procuraUsuario(email);
        if(u.getSenha().equals(senha)){
            return u;
        }
        return null;
    }

    public void executaLogin(){
        Scanner in = new Scanner(System.in);
        while (true){
            exibeMenuLogin();

            switch(in.nextLine()){
                case "1" -> {
                    System.out.println("email:");
                    String email = in.nextLine();
                    System.out.println("senha:");
                    String senha = in.nextLine();
                    usuarioAtivo = fazLogin(email, senha);
                    if(usuarioAtivo != null){
                        return;
                    }
                    else{
                        System.out.println("Usuario Invalido!");
                    }
                }
                case "2" -> {
                    System.out.println("Programa finalizado!");
                    System.exit(130);
                }
                default ->
                    System.out.println("Opção invalida!");
            }
        }
    }

    public void executaAdm(){
        Scanner in = new Scanner(System.in);
        while(true){
            exibeMenuAdm();

            switch (in.nextLine()) {
                case "1" -> {

                }
                case "2" -> {

                }
                case "3" -> {

                }
                case "4"-> {

                }
                case "0" -> {
                    System.out.println("Sistema Finalizado");
                    return;
                }
                default ->
                        System.out.println("Opção invalida!");
            }
        }
    }

    public void executaUser(){
        Scanner in = new Scanner(System.in);
        while(true){
            exibeMenuUser();

            switch (in.nextLine()) {
                case "1" -> {
                    // tipo de consulta
                    String tipo;
                    // ordem
                    String ordenacao;
                    // dado pra consulta
                    String consulta;

                    switch(tipo){
                        case "1" -> {
                            catalogoEntretenimento.pesquisaTitulo()
                        }
                        case "2" -> {
                            catalogoEntretenimento.pesquisaTitulo()
                        }
                        case "3" -> {
                            catalogoEntretenimento.pesquisaTitulo()
                        }
                        case "4" -> {
                            catalogoEntretenimento.pesquisaTitulo()
                        }
                    }

                    if(){

                    }
                }
                case "2" -> {

                }
                case "3" -> {

                }
                case "0" -> {
                    System.out.println("Sistema Finalizado");
                    return;
                }
                default ->
                        System.out.println("Opção invalida!");
            }
        }
    }

    public void exibeMenuLogin(){
        System.out.println("MENU");
        System.out.println("1. Fazer Login");
        System.out.println("0. Sair");
    }

    public void exibeMenuAdm(){
        System.out.println("MENU");
        System.out.println("1. Cadastrar novo cliente");
        System.out.println("2. Cadastrar novo entretenimento");
        System.out.println("3. Consultar acessos mensais ");
        System.out.println("4. Simular carga de dados");
        System.out.println("0. Sair");
    }

    public void exibeMenuUser(){
        System.out.println("MENU");
        System.out.println("1. Consultar catálogo de entretenimento");
        System.out.println("2. Acessar entretenimento");
        System.out.println("3. Consultar cobrança mensal");
        System.out.println("0. Sair");
    }

}