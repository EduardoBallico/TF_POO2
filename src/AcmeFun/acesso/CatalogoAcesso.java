package AcmeFun.acesso;

import AcmeFun.Arquivo;
import AcmeFun.cliente.*;

import java.io.File;
import java.util.ArrayList;

public class CatalogoAcesso {

    private final static ArrayList<Acesso> acessos = new ArrayList<>();

    public ArrayList<Acesso> getCatalogo() { return acessos; }

    public boolean adicionaAcesso(Acesso acesso, boolean isLoadingFromFile){
        acessos.add(acesso);
        if(!isLoadingFromFile){
            Arquivo.writeFile(Arquivo.getArquivoAcessos(),acesso.toString()+ "\n");
        }
        return true;
    }

    //todo
    public ArrayList<Acesso> getAcessosDaqueleMesGeral(int ano, int mes){
        ArrayList<Acesso> resultadoGeral = new ArrayList<>();
        for (Acesso acesso : acessos) {
            if(acesso.getDataHora().getYear() == ano && acesso.getDataHora().getMonth().getValue() == mes){
                resultadoGeral.add(acesso);
            }
        }

        if(resultadoGeral.size()==0){
            return null;
        }else{
            return resultadoGeral;
        }
    }

    //todo
    public ArrayList<Acesso> getAcessosDaqueleMesCliente(ArrayList<Acesso> resultadoGeral, Cliente cliente){
        ArrayList<Acesso> resultadoCliente = new ArrayList<>();
        if(resultadoGeral!=null && cliente!=null){
            for (Acesso acesso : resultadoGeral) {
                if(acesso.getCliente().equals(cliente)){
                    resultadoCliente.add(acesso);
                }
            }
        }

        if(resultadoCliente.size()==0){
            return null;
        }else{
            return resultadoCliente;
        }
    }

    public String getRelatório(ArrayList<Acesso> acessos){
        String relatorio = "";
        for (Acesso acesso : acessos) {
            relatorio += acesso.toString() + "\n";
        }
        return relatorio;

    }

    //todo
    public double cobrancaMensalGeral(int ano, int mes){
        double valorFinal = 0;
        for (Acesso acesso : getAcessosDaqueleMesGeral(ano, mes)) {
            valorFinal = valorFinal + acesso.getCobranca();
        }
        return valorFinal;
    }

    //todo
    public double cobrancaMensalCliente(int ano, int mes, ArrayList<Acesso> acessosCliente, Cliente cliente){
        double valorFinal = 0;
        for (Acesso acesso : getAcessosDaqueleMesCliente(acessosCliente,cliente)) {
            valorFinal = valorFinal + acesso.getCobranca();
        }
        return valorFinal;
    }

    //todo
    public String relatorioFinalAcessos(File file){
        String aux = "";
        for (Acesso value : acessos) {
            aux+= "Cadastrado Acesso: " + value.toString() + "\n";
        }
        if(!aux.equals("")){
            return aux;
        } else{
            return null;
        }
    }

}

