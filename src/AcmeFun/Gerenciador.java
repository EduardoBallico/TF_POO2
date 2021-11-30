package AcmeFun;

import AcmeFun.acesso.ListaAcessos;
import AcmeFun.cliente.*;
import AcmeFun.entretenimento.*;

public class Gerenciador {
    private ListaAcessos lAcessos = new ListaAcessos();
    private ListaEntretenimentos lEntretenimentos = new ListaEntretenimentos();
    private ListaClientes lClientes = new ListaClientes();

    private Cliente usuarioAtivo;

    public void logIn(String email, String pass){
        if (email.equals("administracao@mail.com") && pass.equals("admin123")){

        }
        else{
            Cliente c = lClientes.pesquisaClientesEmail(email);
            if(c.getSenha() == pass){

            }
            else{
                System.out.println("Credenciais incorretas, tente novamente.");
            }
        }
    }

    public void setUsuarioAtivo(Cliente cliente) {
        usuarioAtivo = cliente;
    }

    public void cadastraEntretenimento(int tipo, int codigo, String titulo, String ano, String extra1, String extra2, String extra3){
        Entretenimento e = null;

        switch (tipo){
            case 1 -> {
                e = new Filme(codigo,titulo,ano,Integer.parseInt(extra1));
            }
            case 2 -> {
                e = new Jogo(codigo,titulo,ano,extra1,extra2);
            }
            case 3 -> {
                e = new Serie(codigo,titulo,ano,extra1);
            }
            case 4 -> {
                Serie serie = (Serie) lEntretenimentos.pesquisaEntretenimentoID(Integer.parseInt(extra3));
                e = new Episodio(codigo,titulo,ano,Integer.parseInt(extra1),Integer.parseInt(extra2), serie);
            }
        }
        lEntretenimentos.cadastra(e);
    }

    public void cadastraCliente(int tipo, String nome, String email, String senha, String id, String extra){
        Cliente c = null;

        switch (tipo){
            case 1 -> {
                c = new Individual(nome,email,senha,id,false);
            }
            case 2 -> {
                c = new Empresarial(nome,email,senha,id,extra);
            }
            case 3 -> {
                c = new Individual(nome,email,senha,id,true);
                Empresarial e = (Empresarial) lClientes.pesquisaClientesEmail(extra);
                e.addColaboradores((Individual) c);
            }
        }

        lClientes.cadastra(c);
    }
}
