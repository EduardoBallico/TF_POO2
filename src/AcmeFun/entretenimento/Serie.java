package AcmeFun.entretenimento;

import java.util.*;

public class Serie extends Entretenimento {

	private Calendar anoConclusao;
	private LinkedList<Episodio> episodios;

	public Serie(int id, String titulo, Calendar anoLancamento, Calendar anoConclusao, LinkedList episodios) {
		super(id, titulo, anoLancamento);
		this.anoConclusao = anoConclusao;
		this.episodios = episodios;
	}

	public Calendar getAnoConclusao() { return anoConclusao; }
	public LinkedList<Episodio> getEpisodios() { return episodios; }
}
