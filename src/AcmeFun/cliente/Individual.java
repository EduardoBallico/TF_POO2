package AcmeFun.cliente;

public class Individual extends Cliente {

	private int cpf;
	private boolean vinculado;

	public Individual(String nome, String email, String senha, int cpf, boolean vinculado){
		super(nome, email, senha);
		this.cpf = cpf;
		this.vinculado = vinculado;
	}

	public int getCpf() { return cpf; }
	public boolean isVinculado() { return vinculado; }
}
