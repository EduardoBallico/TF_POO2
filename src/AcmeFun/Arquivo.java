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

    public static void readFileCliente(File strFile, boolean simulaCarga){

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
                        if (simulaCarga){
                            System.out.println("isso é o q printa qnd simula");
                        }
                        else {
                            u.cadastraCliente(individualSemEmpresa, true);
                        }
                    }
                    case "2" -> {
                        String nome = valores.get(1);
                        String email = valores.get(2);
                        String senha = valores.get(3);
                        String cnpj = valores.get(4);
                        String nomeFantasia = valores.get(5);
                        ClienteEmpresarial empresarial = new ClienteEmpresarial(nome, email, senha, cnpj, nomeFantasia);
                        if (simulaCarga){
                            System.out.println("isso é o q printa qnd simula");
                        }
                        else {
                            u.cadastraCliente(empresarial, true);
                        }
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
                        if (simulaCarga){
                            System.out.println("isso é o q printa qnd simula");
                        }
                        else {
                            u.cadastraCliente(individualComEmpresa, true);
                        }
                    }
                }
            }
        } catch (IOException ex){
            System.out.println("Arquivo não encontrado. Tente novamente");
        }
    }

    public static void readFileEntretenimento(File strFile){

        ListaDeEntretenimento e = new ListaDeEntretenimento();

        try(BufferedReader buffRead = new BufferedReader((new FileReader(strFile)))){
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

        try(BufferedReader buffRead = new BufferedReader((new FileReader(strFile)))){
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

}
