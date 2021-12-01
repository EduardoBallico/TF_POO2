package AcmeFun;

import AcmeFun.acesso.Acesso;
import AcmeFun.acesso.ListaDeAcesso;
import AcmeFun.cliente.*;
import AcmeFun.entretenimento.*;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {

    public ListaDeUsuarios listaDeUsuarios;
    public ListaDeEntretenimento listaDeEntretenimento;
    public ListaDeAcesso listaDeAcesso;

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
        listaDeUsuarios = new ListaDeUsuarios();
        listaDeEntretenimento = new ListaDeEntretenimento();
        listaDeAcesso = new ListaDeAcesso();

        Administrador adm = new Administrador("administracao@mail.com","admin123");

        listaDeUsuarios.cadastraCliente(adm, false);

        Arquivo.readFileEntretenimento(Arquivo.getArquivoEntretenimentos());
        Arquivo.readFileCliente(Arquivo.getArquivoClientes());
        Arquivo.readFileAcessos(Arquivo.getArquivoAcessos());
    }

    public Usuario fazLogin(String email, String senha){
        Usuario u = listaDeUsuarios.procuraUsuario(email);
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
                case "0" -> {
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

                    boolean flag = true;
                    while (flag) {
                        switch (tipo){
                            case "1" ->{
                                System.out.println("Informe o CPF do usuário que deseja registrar: ");
                                String cpf = in.nextLine();

                                cli = new ClienteIndividual(nome, email, senha, cpf, null);
                                listaDeUsuarios.cadastraCliente(cli, false);
                                flag = false;
                            }
                            case "2" ->{
                                System.out.println("Informe o CPF do usuário que deseja registrar: ");
                                String cpf = in.nextLine();
                                System.out.println("Informe o e-mail da empresa em que o usuário está vinculado: ");
                                String empresa = in.nextLine();

                                ClienteEmpresarial cliEmp = (ClienteEmpresarial) listaDeUsuarios.procuraUsuario(empresa);
                                cli = new ClienteIndividual(nome, email, senha, cpf, cliEmp);
                                listaDeUsuarios.cadastraCliente(cli, false);
                                flag = false;
                            }
                            case "3" -> {
                                System.out.println("Informe o CNPJ da empresa que deseja registrar: ");
                                String cnpj = in.nextLine();
                                System.out.println("Informe nome fantasia da empresa que deseja registrar: ");
                                String nomeFantasia = in.nextLine();

                                cli = new ClienteEmpresarial(nome, email, senha, cnpj, nomeFantasia);
                                listaDeUsuarios.cadastraCliente(cli, false);
                                flag = false;
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

                    boolean flag = true;
                    while (flag) {
                        switch (tipo){
                            case "1" ->{
                                System.out.println("Informe a duração do filme que deseja registrar: ");
                                int duracao = Integer.parseInt(in.nextLine());

                                ent = new Filme(codigo, titulo, anoLanc, duracao);
                                listaDeEntretenimento.addEntretenimento(ent, false);
                                flag = false;
                            }
                            case "2" ->{
                                System.out.println("Informe o título original do jogo que deseja registrar: ");
                                String tituloOriginal = in.nextLine();
                                System.out.println("Informe o gênero que o jogo melhor se enquadra: ");
                                String genero = in.nextLine();

                                ent = new Jogo(codigo, titulo, anoLanc, tituloOriginal, genero);
                                listaDeEntretenimento.addEntretenimento(ent, false);
                                flag = false;
                            }
                            case "3" -> {
                                System.out.println("Informe o ano de conclusão que deseja registrar: ");
                                int anoConc = Integer.parseInt(in.nextLine());

                                ent = new Serie(codigo,titulo,anoLanc,anoConc);
                                listaDeEntretenimento.addEntretenimento(ent, false);
                                flag = false;
                            }
                            case "4" -> {
                                System.out.println("Informe de que temporada é o episódio que deseja registrar: ");
                                int numTemporada = Integer.parseInt(in.nextLine());
                                System.out.println("Informe o número do episódio que deseja registrar: ");
                                int numEpisodio = Integer.parseInt(in.nextLine());
                                System.out.println("Informe o código da série em que este episódio pertence: ");
                                String codSerie = in.nextLine();

                                Serie serie = (Serie) listaDeEntretenimento.pesquisaCodigo(codSerie);
                                EpisodioSerie episodio = new EpisodioSerie(codigo, titulo, anoLanc, numTemporada, numEpisodio, serie);
                                listaDeEntretenimento.addEntretenimento(episodio, false);
                                serie.linkaEp(episodio);
                                flag = false;
                            }
                            default ->
                                    System.out.println("Opção invalida!");
                        }
                    }
                }
                case "3" -> {
                    System.out.println("Informe o ano (número) que deseja consultar: ");
                    int ano = Integer.parseInt(in.nextLine());
                    System.out.println("Informe o mês (número) que deseja consultar: ");
                    int mes = Integer.parseInt(in.nextLine());

                    for (Acesso ac: listaDeAcesso.getAcessosMes(ano,mes)) {
                        String email = ac.getCliente().getEmail();
                        LocalDateTime dateTime = ac.getDataHora();
                        String cod = ac.getEntretenimento().getCodigo();
                        String titulo = ac.getEntretenimento().getTitulo();

                        double res = listaDeAcesso.getCobrancaCliente(ano,mes,ac.getCliente());

                        System.out.println("E-mail do cliente: "+email+" Horário do acesso: "+dateTime+
                                "Código do Serviço acessado: "+cod+" Título do serviço: "+titulo+
                                "Valor total do cliente: "+res);
                    }
                    double d = listaDeAcesso.getCobrancaTotal(ano,mes);
                    System.out.println("Valor total de todos os acessos: "+ d);
                 }

                case "4"-> {
                    // Simular carga de dados
                }
                case "0" -> {
                    System.out.println("Sistema finalizado. Obrigado por utilizar nosso programa.");
                    return;
                }
                default -> System.out.println("Opção invalida!");
            }
        }
    }

    public void executaUser(){
        Scanner in = new Scanner(System.in);
        while(true){
            exibeMenuUser();

            switch (in.nextLine()) {
                case "1" -> {
                    System.out.println("Informe pelo que deseja pesquisar um entretenimento: ");
                    System.out.println("1. Codigo");
                    System.out.println("2. Titulo");
                    System.out.println("3. Ano de Lançamento");
                    String tipo = in.nextLine();

                    System.out.println("Informe o modo de ordenação desejado: ");
                    System.out.println("1. Ordem alfabética crescente do título");
                    System.out.println("2. Ordem decrescente de ano de lançamento");
                    String ordem = in.nextLine();

                    System.out.println("Informe o que deseja pesquisar: ");
                    String pesquisa = in.nextLine();

                    switch (tipo){
                        case "1" -> listaDeEntretenimento.pesquisaCodigo(pesquisa);
                        case "2" -> listaDeEntretenimento.pesquisaTitulo(pesquisa);
                        case "3" -> listaDeEntretenimento.pesquisaAnoLanc(Integer.parseInt(pesquisa));
                        default -> System.out.println("Tipo informado incorreto!");
                    }
                    switch (ordem){
                        case "1" -> listaDeEntretenimento.ordenaTitulo();
                        case "2" -> listaDeEntretenimento.ordenaAno();
                        default -> System.out.println("Ordenação informada incorreta!");
                    }
                    try{
                        for(Entretenimento e : listaDeEntretenimento.getUltimaConsulta()){
                            System.out.println(e.getCodigo() + ", " + e.getTitulo());
                        }
                    }
                    catch (NullPointerException e){
                        System.out.println("Não foram encontrados resultados para a pesquisa");
                    }
                }
                case "2" -> {
                    System.out.println("Selecione o codigo de um dos Entretenimentos da ultima consulta:");
                    for (Entretenimento e : listaDeEntretenimento.getUltimaConsulta()) {
                        System.out.println(e);
                    }

                    Entretenimento e = listaDeEntretenimento.pesquisaCodigo(in.nextLine());

                    if(e == null) {
                        System.out.println("Entretenimento não encontrado");
                        continue;
                    }

                    System.out.println("Deseja acessar esse entretenimento?");
                    System.out.println("1. Sim");
                    System.out.println("2. Não");

                    boolean flag = false;
                    do {
                        switch(in.nextLine()){
                            case "1" ->{
                                Acesso a = new Acesso((Cliente) usuarioAtivo, e);
                                listaDeAcesso.adicionaAcesso(a, false);
                                System.out.println("Acesso cadastrado!");
                                flag = true;
                            }
                            case "2" -> {
                                System.out.println("Acesso a entretenimento não realizado!");
                                flag = true;
                            }
                            default -> System.out.println("Opção invalida");
                        }
                    } while(!flag);
                }
                case "3" -> {
                    System.out.println("Informe o ano desejado para a consulta: ");
                    String ano = in.nextLine();
                    System.out.println("Informe o mês desejado para a consulta: ");
                    String mes = in.nextLine();

                    System.out.println(
                            "Sua cobrança mensal é" +
                            listaDeAcesso.getCobrancaCliente(
                                    Integer.parseInt(ano), Integer.parseInt(mes), (Cliente) usuarioAtivo)
                    );
                }
                case "0" -> {
                    System.out.println("Sistema Finalizado");
                    return;
                }
                default -> System.out.println("Opção invalida!");
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