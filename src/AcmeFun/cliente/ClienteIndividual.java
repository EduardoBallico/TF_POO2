package AcmeFun.cliente;

public class ClienteIndividual extends Cliente{
    private String cpf;
    private ClienteEmpresarial empresa;

    public ClienteIndividual(String nome, String email, String senha, String cpf, ClienteEmpresarial empresa) {
        super(email,senha,nome);
        this.cpf = cpf;
        this.empresa = empresa;
    }

    public String getCpf() {
        return cpf;
    }

    public ClienteEmpresarial getEmpresa() {
        return empresa;
    }

    @Override
    public String getTipo() {
        if(this.empresa!=null){
            return "3";
        }
        return "1";
    }

    @Override
    public double cobrancaMensal(int ano, int mes){
        double valorInicial = super.cobrancaMensal(ano, mes);
        if(empresa != null){
            valorInicial *= 0.5;
        }
        return valorInicial;
    }

    @Override
    public String toString() {
        if(getTipo().equals("1")){
            return getTipo() +
                ";" + getNome() + ";" +
                getEmail() + ";" +
                getSenha() + ";" +
                getCpf();
        }
        else {
            return getTipo() +
                    ";" + getNome() + ";" +
                    getEmail() + ";" +
                    getSenha() + ";" +
                    getCpf() +  ";" +
                    getEmpresa().getEmail() + "\n";
        }
    }
}
