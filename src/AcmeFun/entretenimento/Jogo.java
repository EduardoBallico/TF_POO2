package AcmeFun.entretenimento;

public class Jogo extends Entretenimento{

    private String tituloOriginal;

    private String genero;

    public Jogo(String codigo, String titulo, int anoLancamento, String tituloOriginal, String genero) {
        super(codigo, titulo, anoLancamento);
        this.tituloOriginal = tituloOriginal;
        this.genero = genero;
    }

    public String getTituloOriginal() { return tituloOriginal; }

    public String getGenero() { return genero; }

    @Override
    public String toString() {
        return getTipo() +
                ";" + getCodigo() + ";" +
                getTitulo() + ";" +
                getAnoLancamento() + ";" +
                getTituloOriginal() + ";" +
                getGenero() + "\n";
    }

    @Override
    public String getTipo(){
        return "2";
    }
}
