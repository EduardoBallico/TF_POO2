package AcmeFun.entretenimento;

import java.util.Calendar;

public class Jogo extends Entretenimento {

	private String tituloOriginal;
	private String genero;

	public Jogo(int id, String titulo, String anoLancamento, String tituloOriginal, String genero){
		super(id,titulo, anoLancamento);
		this.tituloOriginal = tituloOriginal;
		this.genero = genero;
	}

	@Override
	public int getPreco() {
		return 8;
	}

	public String getGenero() { return genero; }
	public String getTituloOriginal() { return tituloOriginal; }
}
