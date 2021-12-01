package AcmeFun.cliente;

import java.util.ArrayList;

public class ClienteEmpresarial extends Cliente{
    private String cnpj;
    private String nomeFantasia;
    private ArrayList<ClienteIndividual> colaboradores = new ArrayList<>();

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

    public void adicionaColaborador(ClienteIndividual c){
        colaboradores.add(c);
    }

    @Override
    public String getTipo() {
        return "2";
    }

    @Override
    public double cobrancaMensal(int ano, int mes){
        double valorEmpresa = super.cobrancaMensal(ano, mes);
        for (ClienteIndividual colaborador : colaboradores) {
            valorEmpresa += colaborador.cobrancaMensal(ano, mes);
        }
        return valorEmpresa;
    }

    @Override
    public String toString() {
        return  getTipo() + ";" +
                getNome() + ";" +
                getEmail() + ";" +
                getSenha() + ";" +
                getCnpj() +  ";" +
                getNomeFantasia() + "\n";
    }

}
