package AcmeFun.entretenimento;

public class EpisodioSerie extends Entretenimento{

    private int numTemporada;

    private int numEpisodio;

    private Serie serie;

    public EpisodioSerie(String codigo, String titulo, int anoLancamento, int numTemporada, int numEpisodio, Serie serie) {
        super(codigo, titulo, anoLancamento);
        this.numTemporada = numTemporada;
        this.numEpisodio = numEpisodio;
        this.serie = serie;
    }

    public int getNumTemporada() {
        return numTemporada;
    }

    public int getNumEpisodio() {
        return numEpisodio;
    }

    public Serie getSerie() {
        return serie;
    }

    @Override
    public String toString() {
        return getTipo() +
                ";" + getCodigo() + ";" +
                getTitulo() + ";" +
                getAnoLancamento() + ";" +
                getNumTemporada() + ";" +
                getNumEpisodio() + ";" +
                getSerie().getCodigo();
    }

    @Override
    public int defineTipo(){
        return 4;
    }
}
