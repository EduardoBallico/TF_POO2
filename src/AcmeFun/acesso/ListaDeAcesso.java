package AcmeFun.acesso;

import AcmeFun.Arquivo;
import AcmeFun.cliente.*;

import java.util.ArrayList;

public class ListaDeAcesso {

    private final static ArrayList<Acesso> acessos = new ArrayList<>();

    public boolean adicionaAcesso(Acesso acesso, boolean isLoadingFromFile){
        acessos.add(acesso);
        if(!isLoadingFromFile){
            Arquivo.writeFile(Arquivo.getArquivoAcessos(),acesso.toString()+ "\n");
        }
        return true;
    }

    public ArrayList<Acesso> getAcessosMes(int ano, int mes){

        ArrayList<Acesso> resultados = new ArrayList<>();
        for (Acesso a : acessos){
            if(a.getDataHora().getYear() == ano && a.getDataHora().getMonth().getValue() == mes){
                resultados.add(a);
            }
        }
        if(resultados.isEmpty()){
            return null;
        }
        else {
            return resultados;
        }
    }
    
    public ArrayList<Acesso> getAcessosMesCliente(int ano, int mes, Cliente cliente){

        ArrayList<Acesso> resultados = new ArrayList<>();
        for(Acesso a : getAcessosMes(ano, mes)){
            if(a.getCliente().getEmail().equals(cliente.getEmail())){
                resultados.add(a);
            }
        }
        if(resultados.size()==0){
            return null;
        }
        else{
            return resultados;
        }
    }

    public double getCobrancaTotal(int ano, int mes){

        double valorFinal = 0;
        for (Acesso a : getAcessosMes(ano, mes)){
            valorFinal += a.getEntretenimento().getPreco();
        }

        return valorFinal;
    }

    public double getCobrancaCliente(int ano, int mes, Cliente cliente){

        double valorFinal = 0;
        double valorColaboradores = 0;

        for (Acesso a : getAcessosMesCliente(ano, mes, cliente)){
            valorFinal += a.getEntretenimento().getPreco();
        }

        if (cliente.getTipo().equals("3")) return valorFinal/2;
        if (cliente.getTipo().equals("2")){
            ClienteEmpresarial ce = (ClienteEmpresarial) cliente;
            for(ClienteIndividual c : ce.getColaboradores()){
                valorColaboradores += getCobrancaCliente(ano, mes, c);
            }
            return valorFinal + valorColaboradores;
        }
        return valorFinal;
    }

    public String toString(){
        StringBuilder aux = new StringBuilder();
        for (Acesso value : acessos) {
            aux.append("Cadastrado Acesso: ").append(value.toString()).append("\n");
        }
        if(!aux.toString().equals("")){
            return aux.toString();
        } else{
            return null;
        }
    }

}

