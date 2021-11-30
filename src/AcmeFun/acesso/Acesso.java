package AcmeFun.acesso;

import AcmeFun.cliente.Cliente;
import AcmeFun.entretenimento.Entretenimento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Acesso {

    private Cliente cliente;

    private Entretenimento entretenimento;

    private LocalDateTime dataHora;

    private int cobranca;

    public Acesso(Cliente cliente, Entretenimento entretenimento) {
        this.cliente = cliente;
        this.entretenimento = entretenimento;
        this.dataHora = LocalDateTime.now();
        this.cobranca = 0;
        if(entretenimento.defineTipo() == 1 ) this.cobranca = 6;
        else if(entretenimento.defineTipo() == 4 ) this.cobranca = 4;
        else this.cobranca = 8;
    }
    public Acesso(Cliente cliente, Entretenimento entretenimento,LocalDateTime dataHoraMinuto) {
        this.cliente = cliente;
        this.entretenimento = entretenimento;
        this.dataHora = dataHoraMinuto;
        this.cobranca = 0;
        if(entretenimento.defineTipo() == 1 ) this.cobranca = 6;
        else if(entretenimento.defineTipo() == 4 ) this.cobranca = 4;
        else this.cobranca = 8;
    }

    /* public void setCobranca() {
         int tipo = this.entretenimento.getTipo();
         // filme
         if(tipo == 1 ) cobranca = 6;
             // episodio serie
         else if(tipo == 4 ) cobranca = 4;
             // jogo
         else cobranca = 8;
     }
 */
    public void setCobranca(int cobranca) {
        this.cobranca = cobranca;
    }

    public int getCobranca() {
        return cobranca;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Entretenimento getEntretenimento() {
        return entretenimento;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    //Validar como será o toString. Este metodo definirá como será a impressão no relatório.
    @Override
    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy;HH:mm");
        String data = dtf.format(getDataHora());
        return  data + ";" +
                cliente.getEmail() + ";" +
                entretenimento.getCodigo();
    }
}
