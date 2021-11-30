package AcmeFun.acesso;

import AcmeFun.cliente.Cliente;
import AcmeFun.entretenimento.Entretenimento;

import java.util.Date;

public class Acesso {

	private Date dataAcesso;
	private Cliente cliente;
	private Entretenimento entretenimento;

	public Acesso(Date dataAcesso, Cliente cliente, Entretenimento entretenimento){
		this.dataAcesso = dataAcesso;
		this.cliente = cliente;
		this.entretenimento = entretenimento;
	}

	public Date getDataAcesso() { return dataAcesso; }
	public Cliente getCliente() { return cliente; }
	public Entretenimento getEntretenimento() { return entretenimento; }
}
