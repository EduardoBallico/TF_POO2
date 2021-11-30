package AcmeFun.entretenimento;

import java.util.Calendar;

public class Filme extends Entretenimento {

	private int duracao;

	public Filme (int id, String titulo, String anoLancamento, int duracao){
		super(id,titulo, anoLancamento);
		this.duracao = duracao;
	}

	@Override
	public int getPreco() {
		return 6;
	}

	public int getDuracao() { return duracao; }
}
