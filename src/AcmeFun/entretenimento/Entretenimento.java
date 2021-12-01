package AcmeFun.entretenimento;

public abstract class Entretenimento {

    private String codigo;
    private String titulo;
    private int anoLancamento;

    public Entretenimento(String id, String titulo, int anoLancamento) {
        this.codigo = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public abstract String getTipo();
    
}
