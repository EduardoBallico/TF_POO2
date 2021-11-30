package AcmeFun.entretenimento;

import java.util.Calendar;

public class Jogo extends Entretenimento {

	private String tituloOriginal;
	private String genero;

	public Jogo(int id, String titulo, Calendar anoLancamento, String tituloOriginal, String genero){
		super(id,titulo, anoLancamento);
		this.tituloOriginal = tituloOriginal;
		this.genero = genero;
	}

	public String getGenero() { return genero; }
	public String getTituloOriginal() { return tituloOriginal; }
}
