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

    public static ListaDeUsuarios readFileCliente(File strFile, ListaDeUsuarios u){

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
            return null;
        }
        return u;
    }

    public static ListaDeEntretenimento readFileEntretenimento(File strFile, ListaDeEntretenimento e){

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
            return null;
        }
        return e;
    }

    public static ListaDeAcesso readFileAcessos(File strFile, ListaDeAcesso a, ListaDeEntretenimento e, ListaDeUsuarios u){

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
            }

        } catch (IOException ex){
            System.out.println("Arquivo não encontrado. Tente novamente");
            return null;
        }
        return a;
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

    public static void simulaCarga(String arquivo, String tipo, ListaDeUsuarios simCli, ListaDeEntretenimento simEnt, ListaDeAcesso simAcs){
        switch (tipo){
            case "1" -> {
                simCli = readFileClienteSim(arquivo, simCli);
                System.out.println(simCli);
            }
            case "2" -> {
                simEnt = readFileEntretenimentoSim(arquivo, simEnt);
                System.out.println(simEnt);
            }
            case "3" -> {
                simAcs = readFileAcessoSim(arquivo, simAcs, simCli, simEnt);
                System.out.println(simAcs);
            }
            default -> System.out.println("Tipo informado incorreto!");
        }

    }

    public static ListaDeUsuarios readFileClienteSim(String file, ListaDeUsuarios u){
        System.out.println("Abrindo Arquivo...");
        File arquivo = new File(file);
        try(BufferedReader buffRead = new BufferedReader(new FileReader(arquivo))){
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
                        u.cadastraCliente(individualSemEmpresa, true);
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
                        u.cadastraCliente(empresarial, true);
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
                        u.cadastraCliente(individualComEmpresa, true);
                        System.out.println("Cliente Individual não vinculado importado");
                    }
                }
            }
        } catch (IOException ex){
            System.out.println("Arquivo não encontrado. Tente novamente");
            return null;
        }
        return u;
    }

    public static ListaDeEntretenimento readFileEntretenimentoSim(String file, ListaDeEntretenimento e){
        System.out.println("Abrindo Arquivo...");
        File arquivo = new File(file);
        try(BufferedReader buffRead = new BufferedReader(new FileReader(arquivo))){
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
                        System.out.println("Jogo identificado");
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        String tituloOriginal = valores.get(4);
                        String genero = valores.get(5);
                        Entretenimento jogo = new Jogo(codigo, titulo, anoLancamento, tituloOriginal, genero);
                        e.addEntretenimento(jogo, true);
                        System.out.println("Jogo importado");
                    }
                    case "3" -> {
                        System.out.println("Serie identificado");
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        int anoConclusao = Integer.parseInt(valores.get(4));
                        Entretenimento serie = new Serie(codigo, titulo, anoLancamento, anoConclusao);
                        e.addEntretenimento(serie, true);
                        System.out.println("Serie importado");
                    }
                    case "4" -> {
                        System.out.println("Episodio identificado");
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        int numTemporada = Integer.parseInt(valores.get(4));
                        int numEpisodio = Integer.parseInt(valores.get(5));
                        Serie serie = (Serie) e.pesquisaCodigo(valores.get(6));
                        EpisodioSerie episodio = new EpisodioSerie(codigo, titulo, anoLancamento, numTemporada, numEpisodio, serie);
                        e.addEntretenimento(episodio, true);
                        serie.linkaEp(episodio);
                        System.out.println("Episodio importado");
                    }
                }
            }
        } catch (IOException ex){
            System.out.println("Arquivo não encontrado. Tente novamente");
            return null;
        }
        return e;
    }

    public static ListaDeAcesso readFileAcessoSim(String file, ListaDeAcesso a, ListaDeUsuarios u, ListaDeEntretenimento e){
        System.out.println("Abrindo Arquivo...");
        File arquivo = new File(file);
        try(BufferedReader buffRead = new BufferedReader(new FileReader(arquivo))){
            System.out.println("Arquivo Aberto!");
            while(buffRead.ready()) {
                System.out.println("Lendo Linha...");
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
                System.out.println("Acesso importado");
            }

        } catch (IOException ex){
            System.out.println("Arquivo não encontrado. Tente novamente");
            return null;
        }
        return a;
    }

}
