package AcmeFun.entretenimento;

import java.util.ArrayList;

public class Serie extends Entretenimento{

    private int anoConclusao;

    private ArrayList<EpisodioSerie> episodios = new ArrayList<>();

    public Serie(String codigo, String titulo, int anoLancamento, int anoConclusao) {
        super(codigo, titulo, anoLancamento);
        this.anoConclusao = anoConclusao;
    }

    public int getAnoConclusao() {
        return anoConclusao;
    }

    public ArrayList<EpisodioSerie> getEpisodios() {
        return episodios;
    }

    public void linkaEp(EpisodioSerie ep){
        episodios.add(ep);
    }

    @Override
    public String toString() {
        return this.getTipo() +
                ";" + getCodigo() + ";" +
                getTitulo() + ";" +
                getAnoLancamento() + ";" +
                getAnoConclusao() + "\n";
    }

    @Override
    public String getTipo(){
        return "3";
    }

    @Override
    public int getPreco() {
        return 4 * episodios.size();
    }
}

