package AcmeFun.entretenimento;

import java.util.Calendar;

public class Episodio extends Entretenimento {

	private int nrTemporada;
	private int nrEpisodio;
	private Serie serie;

	public Episodio(int id, String titulo, Calendar anoLancamento, int nrTemporada, int nrEpisodio, Serie serie){
		super(id,titulo, anoLancamento);
		this.nrTemporada = nrTemporada;
		this.nrEpisodio = nrEpisodio;
		this.serie = serie;
	}

	public int getNrEpisodio() { return nrEpisodio; }
	public int getNrTemporada() { return nrTemporada; }
	public Serie getSerie() { return serie; }
}
