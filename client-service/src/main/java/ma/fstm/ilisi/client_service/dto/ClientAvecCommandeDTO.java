package ma.fstm.ilisi.client_service.dto;

import java.util.List;



import ma.fstm.ilisi.client_service.external.Commande;

public class ClientAvecCommandeDTO {
private int id;
private String nom;
private List<Commande> commandes;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public List<Commande> getCommandes() {
	return commandes;
}
public void setCommandes(List<Commande> commandes) {
	this.commandes = commandes;
}

}
