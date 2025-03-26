package ma.fstm.ilisi.commande_service.dto;

import java.util.Date;

import ma.fstm.ilisi.commande_service.external.Client;

public class CommandeAvecClientDTO {
	private int id;
	private Date datecmd;
	
	private Client client;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getDatecmd() {
		return datecmd;
	}
	public void setDatecmd(Date datecmd) {
		this.datecmd = datecmd;
	}
	
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
}
