package AcmeFun.cliente;

import java.util.ArrayList;

public class ClienteEmpresarial extends Cliente{

    private String cnpj;

    private String nomeFantasia;

    private ArrayList<ClienteIndividual> colaboradores;

    public ClienteEmpresarial(String nome, String email, String senha, String cnpj, String nomeFantasia) {
        super(email,senha,nome);
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public String getCnpj() {
        return cnpj;
    }

    public ArrayList<ClienteIndividual> getColaboradores() {
        return colaboradores;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    @Override
    public double cobrancaMensal(int ano, int mes){
        double valorInicial = super.cobrancaMensal(ano, mes);
        for (ClienteIndividual colaborador : colaboradores) {
            // para cada colaborador, adiciona a cobranca mensal dele
            valorInicial += colaborador.cobrancaMensal(ano, mes);
        }
        return valorInicial;
    }

    @Override
    public String toString() {
        return  "2" +
                ";" + getNome() + ";" +
                getEmail() + ";" +
                getSenha() + ";" +
                getCnpj() +  ";" +
                getNomeFantasia();
    }

    @Override
    public int defineTipo(){
        return 2;
    }
}
