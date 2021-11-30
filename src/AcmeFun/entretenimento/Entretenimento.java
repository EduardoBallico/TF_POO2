package AcmeFun.entretenimento;

import java.util.Calendar;

public abstract class Entretenimento {

	static private int qttd = 0;
	private int id;
	private String titulo;
	private Calendar anoLancamento;

	public Entretenimento(int id, String titulo, Calendar anoLancamento){
		this.id = ++qttd;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
	}

	public Calendar getAnoLancamento() { return anoLancamento; }
	public int getId() { return id; }
	public String getTitulo() { return titulo; }
}
