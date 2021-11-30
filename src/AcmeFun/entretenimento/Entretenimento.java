package AcmeFun.entretenimento;

public class Entretenimento {

    private String codigo;

    private String titulo;

    private int tipo;

    private int anoLancamento;

    public Entretenimento(String id, String titulo, int anoLancamento) {
        this.codigo = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.tipo = defineTipo();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getTipo() { return tipo;}

    public int getAnoLancamento() {
        return anoLancamento;
    }

    // dei override nesse metodo em cada uma das subclasses, acredito que assim ele funcione

    public int defineTipo(){
        // if(this.getClass().getSimpleName().equals("Filme")){
        //     return 1;
        // }else if(this.getClass().getSimpleName().equals("Jogo")){
        //     return 2;
        // }else if(this.getClass().getSimpleName().equals("Serie")){
        //     return 3;
        // }else{
        //     return 4;
        // }
        return 0;
    }
    
}
