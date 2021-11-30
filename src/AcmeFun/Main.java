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
                    System.out.println("Informe o nome do usuário que deseja registrar: ");
                    String nome = in.nextLine();
                    System.out.println("Informe o e-mail do usuário que deseja registrar: ");
                    String email = in.nextLine();
                    System.out.println("Informe o senha que deseja registrar para este usuário: ");
                    String senha = in.nextLine();
                    System.out.println("Que tipo de usuário deseja cadastrar?");
                    System.out.println("(1) Cliente não vinculado /n (2) Cliente vinculado /n " +
                            "(3) Conta empresarial");
                    String tipo = in.nextLine();

                    Cliente cli = null;

                    while (true) {
                        switch (tipo){
                            case "1" ->{
                                System.out.println("Informe o CPF do usuário que deseja registrar: ");
                                String cpf = in.nextLine();

                                cli = new ClienteIndividual(nome, email, senha, cpf, null);
                                catalogoUsuarios.cadastraCliente(cli, false);
                                break;
                            }
                            case "2" ->{
                                System.out.println("Informe o CPF do usuário que deseja registrar: ");
                                String cpf = in.nextLine();
                                System.out.println("Informe o e-mail da empresa em que o usuário está vinculado: ");
                                String empresa = in.nextLine();

                                ClienteEmpresarial cliEmp = (ClienteEmpresarial) catalogoUsuarios.procuraUsuario(empresa);
                                cli = new ClienteIndividual(nome, email, senha, cpf, cliEmp);
                                catalogoUsuarios.cadastraCliente(cli, false);
                                break;
                            }
                            case "3" -> {
                                System.out.println("Informe o CNPJ da empresa que deseja registrar: ");
                                String cnpj = in.nextLine();
                                System.out.println("Informe nome fantasia da empresa que deseja registrar: ");
                                String nomeFantasia = in.nextLine();

                                cli = new ClienteEmpresarial(nome, email, senha, cnpj, nomeFantasia);
                                catalogoUsuarios.cadastraCliente(cli, false);
                                break;
                            }
                            default ->
                                    System.out.println("Opção invalida!");
                        }
                    }
                }
                case "2" -> {
                    System.out.println("Informe o código do entretenimento que deseja registrar: ");
                    String codigo = in.nextLine();
                    System.out.println("Informe o título do entretenimento que deseja registrar: ");
                    String titulo = in.nextLine();
                    System.out.println("Informe o ano de lançamento do entretenimento que deseja registrar: ");
                    int anoLanc = Integer.parseInt(in.nextLine());
                    System.out.println("Que tipo de entretenimento deseja cadastrar?");
                    System.out.println("(1) Filme /n (2) Jogo /n " +
                            "(3) Serie /n (4) Episódio de série");
                    String tipo = in.nextLine();

                    Entretenimento ent = null;

                    while (true) {
                        switch (tipo){
                            case "1" ->{
                                System.out.println("Informe a duração do filme que deseja registrar: ");
                                int duracao = Integer.parseInt(in.nextLine());

                                ent = new Filme(codigo, titulo, anoLanc, duracao);
                                catalogoEntretenimento.addEntretenimento(ent, false);
                                break;
                            }
                            case "2" ->{
                                System.out.println("Informe o título original do jogo que deseja registrar: ");
                                String tituloOriginal = in.nextLine();
                                System.out.println("Informe o gênero que o jogo melhor se enquadra: ");
                                String genero = in.nextLine();

                                ent = new Jogo(codigo, titulo, anoLanc, tituloOriginal, genero);
                                catalogoEntretenimento.addEntretenimento(ent, false);
                                break;
                            }
                            case "3" -> {
                                System.out.println("Informe o ano de conclusão que deseja registrar: ");
                                int anoConc = Integer.parseInt(in.nextLine());

                                ent = new Serie(codigo,titulo,anoLanc,anoConc);
                                catalogoEntretenimento.addEntretenimento(ent, false);
                                break;
                            }
                            case "4" -> {
                                System.out.println("Informe de que temporada é o episódio que deseja registrar: ");
                                int numTemporada = Integer.parseInt(in.nextLine());
                                System.out.println("Informe o número do episódio que deseja registrar: ");
                                int numEpisodio = Integer.parseInt(in.nextLine());
                                System.out.println("Informe o código da série em que este episódio pertence: ");
                                String codSerie = in.nextLine();

                                Serie serie = (Serie) catalogoEntretenimento.pesquisaCodigo(codSerie);
                                EpisodioSerie episodio = new EpisodioSerie(codigo, titulo, anoLanc, numTemporada, numEpisodio, serie);
                                catalogoEntretenimento.addEntretenimento(episodio, false);
                                serie.linkaEp(episodio);
                                break;
                            }
                            default ->
                                    System.out.println("Opção invalida!");
                        }
                    }
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