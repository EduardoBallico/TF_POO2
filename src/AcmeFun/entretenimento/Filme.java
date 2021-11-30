package AcmeFun.entretenimento;

import java.util.Calendar;

public class Filme extends Entretenimento {

	private int duracao;

	public Filme (int id, String titulo, Calendar anoLancamento, int duracao){
		super(id,titulo, anoLancamento);
		this.duracao = duracao;
	}

	public int getDuracao() { return duracao; }
}
