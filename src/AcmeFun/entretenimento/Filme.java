package AcmeFun.entretenimento;

public class Filme extends Entretenimento{

    private int tempoDurcao;

    public Filme(String codigo, String titulo, int anoLancamento, int tempoDurcao) {
        super(codigo, titulo, anoLancamento);
        this.tempoDurcao = tempoDurcao;
    }

    public int getTempoDurcao() {
        return tempoDurcao;
    }

    @Override
    public String toString() {
        return getTipo() +
                ";" + getCodigo() + ";" +
                getTitulo() + ";" +
                getAnoLancamento() + ";" +
                getTempoDurcao();
    }

    @Override
    public int defineTipo(){
        return 1;
    }
}

