package AcmeFun.cliente;

import java.util.ArrayList;
import java.util.LinkedList;

public class Empresarial extends Cliente {

	private String cnpj;

	private String nomeFantasia;

	private ArrayList<Individual> colaboradores = new ArrayList<>();

	public Empresarial(String nome, String email, String senha, String cnpj, String nomeFantasia) {
		super(nome, email, senha);
		this.cnpj = cnpj;
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() { return cnpj; }
	public ArrayList<Individual> getColaboradores() { return colaboradores; }
	public String getNomeFantasia() { return nomeFantasia; }

	public void addColaboradores(Individual i){
		colaboradores.add(i);
	}
}
