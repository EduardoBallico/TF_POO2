package AcmeFun.acesso;

import AcmeFun.cliente.Cliente;
import AcmeFun.entretenimento.Entretenimento;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Acesso {
    private Cliente cliente;
    private Entretenimento entretenimento;
    private LocalDateTime dataHora;

    public Acesso(Cliente cliente, Entretenimento entretenimento) {
        this.cliente = cliente;
        this.entretenimento = entretenimento;
        this.dataHora = LocalDateTime.now();
    }
    public Acesso(Cliente cliente, Entretenimento entretenimento,LocalDateTime dataHoraMinuto) {
        this.cliente = cliente;
        this.entretenimento = entretenimento;
        this.dataHora = dataHoraMinuto;
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

    @Override
    public String toString(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy;HH:mm");
        String data = dtf.format(getDataHora());
        return  data + ";" +
                cliente.getEmail() + ";" +
                entretenimento.getCodigo();
    }
}
