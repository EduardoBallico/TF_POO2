package AcmeFun.entretenimento;

import java.util.*;

public class Serie extends Entretenimento {

	private String anoConclusao;
	private LinkedList<Episodio> episodios;

	public Serie(int id, String titulo, String anoLancamento, String anoConclusao) {
		super(id, titulo, anoLancamento);
		this.anoConclusao = anoConclusao;
	}

	public String getAnoConclusao() { return anoConclusao; }
	public LinkedList<Episodio> getEpisodios() { return episodios; }
}
