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
                getTempoDurcao() + "\n";
    }

    @Override
    public String getTipo(){
        return "1";
    }

    @Override
    public int getPreco() {
        return 6;
    }
}

