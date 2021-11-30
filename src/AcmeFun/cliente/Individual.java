package AcmeFun.cliente;

public class Individual extends Cliente {

	private String cpf;
	private boolean vinculado;

	public Individual(String nome, String email, String senha, String cpf, boolean vinculado){
		super(nome, email, senha);
		this.cpf = cpf;
		this.vinculado = vinculado;
	}

	public String getCpf() { return cpf; }
	public boolean isVinculado() { return vinculado; }
}
