package AcmeFun;

import AcmeFun.acesso.Acesso;
import AcmeFun.acesso.CatalogoAcesso;
import AcmeFun.cliente.CatalogoUsuarios;
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

    // Fechou
    public static void readFileCliente(File strFile){

        CatalogoUsuarios u = new CatalogoUsuarios();

        try(BufferedReader buffRead = new BufferedReader((new FileReader(strFile)))){
            while(buffRead.ready()) {
                String line = buffRead.readLine();

                ArrayList<String> valores = new ArrayList<>();
                Collections.addAll(valores, line.split(";"));

                switch (valores.get(0)) {
                    case "1" -> {
                        System.out.println("Cliente 1");
                        String nome = valores.get(1);
                        String email = valores.get(2);
                        String senha = valores.get(3);
                        String cpf = valores.get(4);
                        ClienteIndividual individualSemEmpresa = new ClienteIndividual(nome, email, senha, cpf, null);
                        u.cadastraCliente(individualSemEmpresa, true);
                    }
                    case "2" -> {
                        System.out.println("Cliente 2");
                        String nome = valores.get(1);
                        String email = valores.get(2);
                        String senha = valores.get(3);
                        String cnpj = valores.get(4);
                        String nomeFantasia = valores.get(5);
                        ClienteEmpresarial empresarial = new ClienteEmpresarial(nome, email, senha, cnpj, nomeFantasia);
                        u.cadastraCliente(empresarial, true);
                    }
                    case "3" -> {
                        System.out.println("Cliente 3");
                        String nome = valores.get(1);
                        String email = valores.get(2);
                        String senha = valores.get(3);
                        String cpf = valores.get(4);
                        String emailEmpresa = valores.get(5);
                        ClienteEmpresarial empresa = (ClienteEmpresarial) u.procuraUsuario(emailEmpresa);
                        ClienteIndividual individualComEmpresa = new ClienteIndividual(nome, email, senha, cpf, empresa);
                        u.cadastraCliente(individualComEmpresa, true);
                    }
                }
            }
        } catch (IOException ex){
            System.out.println("Arquivo não encontrado. Tente novamente");
        }
    }

    // Fechou
    public static void readFileEntretenimento(File strFile){

        CatalogoEntretenimento e = new CatalogoEntretenimento();

        try(BufferedReader buffRead = new BufferedReader((new FileReader(strFile)))){
            while(buffRead.ready()) {
                String line = buffRead.readLine();

                ArrayList<String> valores = new ArrayList<>();
                Collections.addAll(valores, line.split(";"));

                switch (valores.get(0)) {
                    case "1" -> {
                        System.out.println("Filme");
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        int tempoDuracao = Integer.parseInt(valores.get(4));
                        Entretenimento filme = new Filme(codigo, titulo, anoLancamento, tempoDuracao);
                        e.addEntretenimento(filme, true);
                    }
                    case "2" -> {
                        System.out.println("Jogo");
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        String tituloOriginal = valores.get(4);
                        String genero = valores.get(5);
                        Entretenimento jogo = new Jogo(codigo, titulo, anoLancamento, tituloOriginal, genero);
                        e.addEntretenimento(jogo, true);
                    }
                    case "3" -> {
                        System.out.println("Serie");
                        String codigo = valores.get(1);
                        String titulo = valores.get(2);
                        int anoLancamento = Integer.parseInt(valores.get(3));
                        int anoConclusao = Integer.parseInt(valores.get(4));
                        Entretenimento serie = new Serie(codigo, titulo, anoLancamento, anoConclusao);
                        e.addEntretenimento(serie, true);
                    }
                    case "4" -> {
                        System.out.println("Episódio");
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

    // Feshow
    public static void readFileAcessos(File strFile){

        CatalogoEntretenimento e = new CatalogoEntretenimento();
        CatalogoUsuarios u = new CatalogoUsuarios();
        CatalogoAcesso a = new CatalogoAcesso();

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

    /*
    public String readFileRelatorio(File strFile){

        String aux = "";

        try(BufferedReader buffRead = new BufferedReader((new FileReader(strFile)))){
            System.out.println("Chegou aqui em cima");
            while(buffRead.ready()) {
                String line = buffRead.readLine();
                aux += line + "\n";
            }

        } catch (IOException e){
            System.out.println("Arquivo não encontrado. Tente novamente");
            return null;
        }

        if (aux.equals("")){
            return null;
        } else{
            return aux;
        }
    }
    */
}
