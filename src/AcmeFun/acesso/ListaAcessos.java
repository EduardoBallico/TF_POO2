package AcmeFun.acesso;

import java.util.ArrayList;
import java.util.Date;

public class ListaAcessos {

    private ArrayList<Acesso> acessos = new ArrayList<>();
    private ArrayList<Acesso> consAtual;

    public void cadastra(Acesso a) {
        acessos.add(a);
    }

    public ArrayList<Acesso> pesquisaAcesso(Date data) { //throws exception

        if (this.acessos.isEmpty()) { return null; }//throw new exception(); }

        this.consAtual = new ArrayList<>();

        for (Acesso ac : this.acessos) {
            if (data.equals(ac.getDataAcesso())) {
                consAtual.add(ac);
            }
        }
        if (consAtual.isEmpty()) { return null; } //throw new exception(); }
        return consAtual;
    }
}