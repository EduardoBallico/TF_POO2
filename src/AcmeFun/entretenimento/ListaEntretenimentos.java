package AcmeFun.entretenimento;

import AcmeFun.acesso.Acesso;
import AcmeFun.cliente.Cliente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ListaEntretenimentos {

    private ArrayList<Entretenimento> entretenimentos = new ArrayList<>();
    private ArrayList<Entretenimento> consAtual;

    public void cadastra(Entretenimento e){
        entretenimentos.add(e);
    }

    public Entretenimento pesquisaEntretenimentoID(int ID) { //throws exception

        if (this.entretenimentos.isEmpty()) { return null; }//throw new exception(); }

        for (Entretenimento ent : this.entretenimentos) {
            if (ID == ent.getId()) {
                return ent;
            }
        }
        return null;
    }

    public ArrayList<Entretenimento> pesquisaEntretenimentoTitComp(String titulo) { //throws exception

        if (this.entretenimentos.isEmpty()) { return null; }//throw new exception(); }

        this.consAtual = new ArrayList<>();

        for (Entretenimento ent : this.entretenimentos) {
            if (titulo.equalsIgnoreCase(ent.getTitulo())) {
                consAtual.add(ent);
            }
        }
        if (consAtual.isEmpty()) { return null; } //throw new exception(); }
        return consAtual;
    }

    public ArrayList<Entretenimento> pesquisaEntretenimentoAno(Calendar ano) { //throws exception

        if (this.entretenimentos.isEmpty()) { return null; }//throw new exception(); }

        this.consAtual = new ArrayList<>();

        for (Entretenimento ent : this.entretenimentos) {
            if (ano.equals(ent.getAnoLancamento())) {
                consAtual.add(ent);
            }
        }
        if (consAtual.isEmpty()) { return null; } //throw new exception(); }
        return consAtual;
    }

    //public ArrayList<Entretenimento> pesquisaEntretenimentoTituloParc(String semiTit) { //throws exception
        //implementar
    //}
}
