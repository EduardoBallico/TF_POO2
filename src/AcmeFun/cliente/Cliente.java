package AcmeFun.cliente;

import AcmeFun.acesso.Acesso;

import java.util.ArrayList;

public abstract class Cliente extends Usuario {
    private String nome;
    private ArrayList<Acesso> acessos;
    
    public Cliente(String email, String senha, String nome) {
        super(email, senha);
        this.nome = nome;
        this.acessos = new ArrayList<>();
    }
    
    public String getNome() {
        return nome;
    }
    public abstract String getTipo();

    public ArrayList<Acesso> getAcessosDoMes(int ano, int mes){
        ArrayList<Acesso> resultado = new ArrayList<>();
        for (Acesso acesso : acessos) {
            if(acesso.getDataHora().getYear() == ano && acesso.getDataHora().getMonth().getValue() == mes){
                resultado.add(acesso);
            }
        }
        return resultado;
    }

    public double cobrancaMensal(int ano, int mes){
        double valorFinal = 0;
        for (Acesso acesso : getAcessosDoMes(ano, mes)) {
            String tipo = acesso.getEntretenimento().getTipo();
            if(tipo == "1" ) valorFinal += 6;
            else if(tipo == "4" ) valorFinal += 4;
            else if(tipo == "2" ) valorFinal += 8;
        }
        return valorFinal;
    }

    @Override
    public abstract String toString();
}