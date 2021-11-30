package AcmeFun.entretenimento;

import java.util.Calendar;

public abstract class Entretenimento {

	private int id;
	private String titulo;
	private String anoLancamento;
	private int preco;

	public Entretenimento(int id, String titulo, String anoLancamento){
		this.id = id;
		this.titulo = titulo;
		this.anoLancamento = anoLancamento;
	}

	public abstract int getPreco();
	public String getAnoLancamento() { return anoLancamento; }
	public int getId() { return id; }
	public String getTitulo() { return titulo; }
}
