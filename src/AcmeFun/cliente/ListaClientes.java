package AcmeFun.cliente;

import AcmeFun.entretenimento.Entretenimento;

import java.util.ArrayList;
import java.util.Calendar;

public class ListaClientes {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente verifica(){
        return null;
    }

    public void cadastra(Cliente c){
        clientes.add(c);
    }

    public Cliente pesquisaClientesEmail(String email) { //throws exception

        if (this.clientes.isEmpty()) { return null; }//throw new exception(); }

        for (Cliente cli : this.clientes) {
            if (email.equalsIgnoreCase(cli.getEmail())) {
                return cli;
            }
        }
        return null;
    }

}
