package AcmeFun;

import AcmeFun.acesso.Acesso;
import AcmeFun.acesso.ListaDeAcesso;
import AcmeFun.cliente.ListaDeUsuarios;
import AcmeFun.cliente.Cliente;
import AcmeFun.cliente.ClienteEmpresarial;
import AcmeFun.cliente.ClienteIndividual;
import AcmeFun.entretenimento.*;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;

public class Arquivo {

    private static File arquivoClientes = new File(
            "src/data/TESTE-cliente.dat");
    private static File arquivoEntretenimentos = new File(
            "src/data/TESTE-entretenimento.dat");
    private static File arquivoAcessos = new File(
            "src/data/TESTE-acessos.dat");

    public static void readFileCliente(File strFile){

        ListaDeUsuarios u = new ListaDeUsuarios();

        try(BufferedReader buffRead = new BufferedReader((new FileReader(strFile)))){
            while(buffRead.ready()) {
                String line = buffRead.readLine();

                ArrayList<String> valores = new ArrayList<>();
                Collections.addAll(valores, line.split(";"));

                switch (valores.get(0)) {
                    case "1" -> {
                        String nome = valores.get(1);
                        String email = valores.get(2);
                        String senha = valores.get(3);
                        String cpf = valores.get(4);
                        ClienteIndividual individualSemEmpresa = new ClienteIndividual(nome, email, senha, cpf, null);
                        u.cadastraCliente(individualSemEmpresa, true);
                    }
                    case "2" -> {
                        String nome = valores.get(1);
                        String email = valores.get(2);
                        String senha = valores.get(3);
                        String cnpj = valores.get(4);
                        String nomeFantasia = valores.get(5);
                        ClienteEmpresarial empresarial = new ClienteEmpresarial(nome, email, senha, cnpj, nomeFantasia);
                        u.cadastraCliente(empresarial, true);
                    }
                    case "3" -> {
                        String nome = valores.get(1);
                        String email = valores.get(2);
                        String senha = valores.get(3);
                        String cpf = valores.get(4);
                        String emailEmpresa = valores.get(5);
                        ClienteEmpresarial empresa = (ClienteEmpresarial) u.procuraUsuario(emailEmpresa);
                        ClienteIndividual individualComEmpresa = new ClienteIndividual(nome, email, senha, cpf, empresa);
                        empresa.adicionaColaborador(individualComEmpresa);
                        u.cadastraCliente(individualComEmpresa, true);
                    }
                }
            }
        } catch (IOException ex){
            System.out.println("Arquivo não encontrado. Tente novamente");
        }
    }

    public static void readFileEntretenimento(File strFile){

        ListaDeEntretenimento e = new ListaDeEntretenimento();

        try(BufferedReader buffRead = new BufferedReader(new FileReader(strFile))){
            while(buffRead.ready()) {
                String line = buffRead.readLine();

                ArrayList<String> valores = new ArrayList<>();
                Collections.addAll(valores, line.split(";"));

                switch (valores.get(0)) {
                    case "1" -> {
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        int tempoDuracao = Integer.parseInt(valores.get(4));
                        Entretenimento filme = new Filme(codigo, titulo, anoLancamento, tempoDuracao);
                        e.addEntretenimento(filme, true);
                    }
                    case "2" -> {
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        String tituloOriginal = valores.get(4);
                        String genero = valores.get(5);
                        Entretenimento jogo = new Jogo(codigo, titulo, anoLancamento, tituloOriginal, genero);
                        e.addEntretenimento(jogo, true);
                    }
                    case "3" -> {
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        int anoConclusao = Integer.parseInt(valores.get(4));
                        Entretenimento serie = new Serie(codigo, titulo, anoLancamento, anoConclusao);
                        e.addEntretenimento(serie, true);
                    }
                    case "4" -> {
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        int numTemporada = Integer.parseInt(valores.get(4));
                        int numEpisodio = Integer.parseInt(valores.get(5));
                        Serie serie = (Serie) e.pesquisaCodigo(valores.get(6));
                        EpisodioSerie episodio = new EpisodioSerie(codigo, titulo, anoLancamento, numTemporada, numEpisodio, serie);
                        e.addEntretenimento(episodio, true);
                        serie.linkaEp(episodio);
                    }
                }
            }
        } catch (IOException ex){
            System.out.println("Arquivo não encontrado. Tente novamente");
        }
    }

    public static void readFileAcessos(File strFile){

        ListaDeEntretenimento e = new ListaDeEntretenimento();
        ListaDeUsuarios u = new ListaDeUsuarios();
        ListaDeAcesso a = new ListaDeAcesso();

        try(BufferedReader buffRead = new BufferedReader(new FileReader(strFile))){
            while(buffRead.ready()) {
                String line = buffRead.readLine();

                ArrayList<String> valores = new ArrayList<>();
                Collections.addAll(valores, line.split(";"));

                String dataHoraMinuto = valores.get(0) +";"+ valores.get(1);
                LocalDateTime dataConvertida = LocalDateTime.parse(dataHoraMinuto,DateTimeFormatter.ofPattern("dd/MM/yyyy;HH:mm"));

                String email = valores.get(2);
                String codigoEntretenimento = valores.get(3);
                Cliente cliente = (Cliente) u.procuraUsuario(email);
                Entretenimento entretenimento = e.pesquisaCodigo(codigoEntretenimento);

                Acesso acesso = new Acesso(cliente,entretenimento,dataConvertida);
                a.adicionaAcesso(acesso, true);
                System.out.println("Acesso Cadastrado");
            }

        } catch (IOException ex){
            System.out.println("Arquivo não encontrado. Tente novamente");
        }
    }

    public static void writeFile(File strFile, String strData){
        try(BufferedWriter bfwriter = new BufferedWriter(new FileWriter(strFile,true))){
            bfwriter.write(strData);
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static File getArquivoClientes() {
        return arquivoClientes;
    }

    public static File getArquivoEntretenimentos() {
        return arquivoEntretenimentos;
    }

    public static File getArquivoAcessos() {
        return arquivoAcessos;
    }

    public static void simulaCarga(){
        readFileClienteSim();
        readFileEntretenimentoSim();
        readFileAcessoSim();
    }
    /*
        System.out.println("Abrindo Arquivo...");
        System.out.println("Arquivo Aberto!");
        System.out.println("Lendo Linha...");
        System.out.println("Cliente Individual não vinculado identificado");
        System.out.println("Cliente Individual não vinculado importado");
     */

    public static void readFileClienteSim(){
        ListaDeUsuarios u = new ListaDeUsuarios();
        System.out.println("Abrindo Arquivo...");
        try(BufferedReader buffRead = new BufferedReader(new FileReader(arquivoClientes))){
            System.out.println("Arquivo Aberto!");
            while(buffRead.ready()) {
                System.out.println("Lendo Linha...");
                String line = buffRead.readLine();

                ArrayList<String> valores = new ArrayList<>();
                Collections.addAll(valores, line.split(";"));

                switch (valores.get(0)) {
                    case "1" -> {
                        System.out.println("Cliente Individual não vinculado identificado");
                        String nome = valores.get(1);
                        String email = valores.get(2);
                        String senha = valores.get(3);
                        String cpf = valores.get(4);
                        ClienteIndividual individualSemEmpresa = new ClienteIndividual(nome, email, senha, cpf, null);
                        System.out.println("Cliente Individual não vinculado importado");
                    }
                    case "2" -> {
                        System.out.println("Cliente Empresarial identificado");
                        String nome = valores.get(1);
                        String email = valores.get(2);
                        String senha = valores.get(3);
                        String cnpj = valores.get(4);
                        String nomeFantasia = valores.get(5);
                        ClienteEmpresarial empresarial = new ClienteEmpresarial(nome, email, senha, cnpj, nomeFantasia);
                        System.out.println("Cliente Individual não vinculado importado");
                    }
                    case "3" -> {
                        System.out.println("Cliente Individual vinculado identificado");
                        String nome = valores.get(1);
                        String email = valores.get(2);
                        String senha = valores.get(3);
                        String cpf = valores.get(4);
                        String emailEmpresa = valores.get(5);
                        ClienteEmpresarial empresa = (ClienteEmpresarial) u.procuraUsuario(emailEmpresa);
                        ClienteIndividual individualComEmpresa = new ClienteIndividual(nome, email, senha, cpf, empresa);
                        empresa.adicionaColaborador(individualComEmpresa);
                        System.out.println("Cliente Individual não vinculado importado");
                    }
                }
            }
        } catch (IOException ex){
            System.out.println("Arquivo não encontrado. Tente novamente");
        }
    }
    public static void readFileEntretenimentoSim(){
        System.out.println("Abrindo Arquivo...");
        ListaDeEntretenimento e = new ListaDeEntretenimento();
        try(BufferedReader buffRead = new BufferedReader(new FileReader(arquivoEntretenimentos))){
            System.out.println("Arquivo Aberto!");
            while(buffRead.ready()) {
                System.out.println("Lendo Linha...");
                String line = buffRead.readLine();

                ArrayList<String> valores = new ArrayList<>();
                Collections.addAll(valores, line.split(";"));

                switch (valores.get(0)) {
                    case "1" -> {
                        System.out.println("Filme identificado");
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        int tempoDuracao = Integer.parseInt(valores.get(4));
                        Entretenimento filme = new Filme(codigo, titulo, anoLancamento, tempoDuracao);
                        e.addEntretenimento(filme, true);
                        System.out.println("Filme importado");
                    }
                    case "2" -> {
                        System.out.println(" identificado");
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        String tituloOriginal = valores.get(4);
                        String genero = valores.get(5);
                        Entretenimento jogo = new Jogo(codigo, titulo, anoLancamento, tituloOriginal, genero);
                        e.addEntretenimento(jogo, true);
                        System.out.println("Cliente Individual não vinculado importado");
                    }
                    case "3" -> {
                        System.out.println("Cliente Individual não vinculado identificado");
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        int anoConclusao = Integer.parseInt(valores.get(4));
                        Entretenimento serie = new Serie(codigo, titulo, anoLancamento, anoConclusao);
                        e.addEntretenimento(serie, true);
                        System.out.println("Cliente Individual não vinculado importado");
                    }
                    case "4" -> {
                        System.out.println("Cliente Individual não vinculado identificado");
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        int numTemporada = Integer.parseInt(valores.get(4));
                        int numEpisodio = Integer.parseInt(valores.get(5));
                        Serie serie = (Serie) e.pesquisaCodigo(valores.get(6));
                        EpisodioSerie episodio = new EpisodioSerie(codigo, titulo, anoLancamento, numTemporada, numEpisodio, serie);
                        e.addEntretenimento(episodio, true);
                        serie.linkaEp(episodio);
                        System.out.println("Cliente Individual não vinculado importado");
                    }
                }
            }
        } catch (IOException ex){
            System.out.println("Arquivo não encontrado. Tente novamente");
        }
    }
    public static void readFileAcessoSim(){

    }

}
