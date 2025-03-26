package ma.fstm.ilisi.commande_service.Mapper;

import ma.fstm.ilisi.commande_service.bo.Commande;
import ma.fstm.ilisi.commande_service.dto.CommandeAvecClientDTO;
import ma.fstm.ilisi.commande_service.external.Client;

public interface ICommandeMapper {
public CommandeAvecClientDTO mapToCommandeAvecClientDTO(Commande C, Client L);
}
