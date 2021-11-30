package AcmeFun;

import AcmeFun.acesso.ListaAcessos;
import AcmeFun.cliente.*;
import AcmeFun.entretenimento.ListaEntretenimentos;
import AcmeFun.forms.SceneControler;

public class Gerenciador {
    private ListaAcessos lAcessos = new ListaAcessos();
    private ListaEntretenimentos lEntretenimentos = new ListaEntretenimentos();
    private ListaClientes lClientes = new ListaClientes();

    private Cliente usuarioAtivo;

    public void logIn(String email, String pass){
        if (email.equals("administracao@mail.com") && pass.equals("admin123")){
            SceneControler.switchScene("admin");
            usuarioAtivo = null;
        }
        else{
            Cliente c = lClientes.pesquisaClientesEmail(email);
            if(c.getSenha() == pass){
                setUsuarioAtivo(c);
                SceneControler.switchScene("user");
            }
            else{
                System.out.println("Credenciais incorretas, tente novamente.");
            }
        }
    }

    public void setUsuarioAtivo(Cliente cliente) {
        usuarioAtivo = cliente;
    }

    public void cadastraCliente(int tipo, String nome, String email, String senha, int id, String extra){
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
