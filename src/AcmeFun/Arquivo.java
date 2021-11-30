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
import java.util.List;

public class Arquivo {

    private static CatalogoUsuarios clientes = new CatalogoUsuarios();
    private static CatalogoAcesso acessos = new CatalogoAcesso();
    private static CatalogoEntretenimento entretenimentos = new CatalogoEntretenimento();

    private static File arquivoClientes = new File(
            "src/main/resources/com/example/trabalhofinal2/arquivos/TESTE-clientes.dat");
    private static File arquivoEntretenimentos = new File(
            "src/main/resources/com/example/trabalhofinal2/arquivos/TESTE-entretenimento.dat");
    private static File arquivoAcessos = new File(
            "src/main/resources/com/example/trabalhofinal2/arquivos/TESTE-acessos.dat");


    public void readFileCliente(File strFile){

        try(BufferedReader buffRead = new BufferedReader((new FileReader(strFile)))){
            System.out.println("Chegou aqui em cima");
            while(buffRead.ready()) {
                String line = buffRead.readLine();
                List<String> valores = new ArrayList<>(List.of(line.split(";", -1)));
                if(valores.get(0).equals("1")){
                    System.out.println("Cliente 1");
                    String nome = valores.get(1);
                    String email = valores.get(2);
                    String senha = valores.get(3);
                    String cpf = valores.get(4);
                    ClienteIndividual clienteIndividualSemEmpresa = new ClienteIndividual(nome,email,senha,cpf,null);
                    clientes.addClienteValido(clienteIndividualSemEmpresa);

                }else if(valores.get(0).equals("2")){
                    System.out.println("Cliente 2");
                    String nome = valores.get(1);
                    String email = valores.get(2);
                    String senha = valores.get(3);
                    String cnpj = valores.get(4);
                    String nomeFantasia = valores.get(5);
                    ClienteEmpresarial clienteEmpresarial = new ClienteEmpresarial(nome,email,senha,cnpj,nomeFantasia);
                    clientes.addClienteValido(clienteEmpresarial);

                }else if(valores.get(0).equals("3")){
                    System.out.println("Cliente 3");
                    String nome = valores.get(1);
                    String email = valores.get(2);
                    String senha = valores.get(3);
                    String cpf = valores.get(4);
                    String emailEmpresa = valores.get(5);
                    ClienteEmpresarial empresa = (ClienteEmpresarial) clientes.buscaUsuarioPorEmail(emailEmpresa);
                    ClienteIndividual clienteIndividualComEmpresa = new ClienteIndividual(nome,email,senha,cpf,empresa);
                    clientes.addClienteValido(clienteIndividualComEmpresa);
                }
            }
        } catch (IOException e){
            System.out.println("Arquivo não encontrado. Tente novamente");
        }
    }

    public void readFileEntretenimento(File strFile){

        try(BufferedReader buffRead = new BufferedReader((new FileReader(strFile)))){
            System.out.println("Chegou aqui em cima");
            while(buffRead.ready()) {
                String line = buffRead.readLine();
                List<String> valores = new ArrayList<>(List.of(line.split(";", -1)));
                if(valores.get(0).equals("1")){
                    System.out.println("Filme");
                    String codigo = valores.get(1);
                    String titulo = valores.get(2);
                    int anoLancamento = validaInteiro(valores.get(3));
                    int tempoDuracao = validaInteiro(valores.get(4));
                    Entretenimento filme = new Filme(codigo,titulo,anoLancamento,tempoDuracao);
                    entretenimentos.addEntretenimentoValido(filme);

                }else if(valores.get(0).equals("2")){
                    System.out.println("Jogo");
                    String codigo = valores.get(1);
                    String titulo = valores.get(2);
                    int anoLancamento = validaInteiro(valores.get(3));
                    String tituloOriginal = valores.get(4);
                    String genero = valores.get(5);
                    Entretenimento jogo = new Jogo(codigo,titulo,anoLancamento,tituloOriginal,genero);
                    entretenimentos.addEntretenimentoValido(jogo);

                }else if(valores.get(0).equals("3")){
                    System.out.println("Serie");
                    String codigo = valores.get(1);
                    String titulo = valores.get(2);
                    int anoLancamento = validaInteiro(valores.get(3));
                    int anoConclusao = validaInteiro(valores.get(4));
                    Entretenimento serie = new Serie(codigo,titulo,anoLancamento,anoConclusao);
                    entretenimentos.addEntretenimentoValido(serie);

                }else if(valores.get(0).equals("4")){
                    System.out.println("Episodio");
                    String codigo = valores.get(1);
                    String titulo = valores.get(2);
                    int anoLancamento = validaInteiro(valores.get(3));
                    int numTemporada = validaInteiro(valores.get(4));
                    int numEpisodio= validaInteiro(valores.get(5));
                    Serie serie = (Serie) entretenimentos.buscaPorCodigo(valores.get(6));
                    Entretenimento episodio = new EpisodioSerie(codigo,titulo,anoLancamento,numTemporada,numEpisodio,serie);
                    entretenimentos.addEntretenimentoValido(episodio);
                }
            }
        } catch (IOException e){
            System.out.println("Arquivo não encontrado. Tente novamente");
        }
    }

    public void readFileAcessos(File strFile){

        try(BufferedReader buffRead = new BufferedReader((new FileReader(strFile)))){
            System.out.println("Chegou aqui em cima");
            while(buffRead.ready()) {
                String line = buffRead.readLine();
                List<String> valores = new ArrayList<>(List.of(line.split(";", -1)));

                String dataHoraMinuto = valores.get(0) +";"+ valores.get(1);
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy;HH:mm");
                LocalDateTime dataConvertida = LocalDateTime.parse(dataHoraMinuto,dtf);

                String email = valores.get(2);
                String codigoEntretenimento = valores.get(3);
                Cliente cliente = (Cliente) clientes.buscaUsuarioPorEmail(email);
                Entretenimento entretenimento = entretenimentos.buscaPorCodigo(codigoEntretenimento);

                Acesso acesso = new Acesso(cliente,entretenimento,dataConvertida);
                acessos.addAcesso(acesso);
                System.out.println("Acesso Cadastrado");
            }

        } catch (IOException e){
            System.out.println("Arquivo não encontrado. Tente novamente");
        }
    }

    public void writeFile(File strFile, String strData){

        try(BufferedWriter bfwriter = new BufferedWriter(new FileWriter(strFile,true))){
            bfwriter.write(strData);

        }catch(IOException e){
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

    public int validaInteiro(String numero){
        try{
            int aux = Integer.parseInt(numero);
            return aux;
        }
        catch(NumberFormatException e){
            System.out.println("Objeto não incluido, número inválido");
            return -1;
        }
    }
    public long validaLong(String numero){
        try{
            long aux = Long.parseLong(numero);
            return aux;
        }
        catch(NumberFormatException e){
            System.out.println("Objeto não incluido, número inválido");
            return -1;
        }
    }

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
}
