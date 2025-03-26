package ma.fstm.ilisi.client_service.mapper;

import java.util.List;

import ma.fstm.ilisi.client_service.bo.Client;
import ma.fstm.ilisi.client_service.external.Commande;
import ma.fstm.ilisi.client_service.dto.ClientAvecCommandeDTO;

public interface IClientMapper {
public ClientAvecCommandeDTO mapToClientAvecCommande(Client C, List<Commande> commandes);
}
