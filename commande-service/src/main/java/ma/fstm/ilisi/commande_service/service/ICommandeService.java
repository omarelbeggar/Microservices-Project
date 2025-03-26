package ma.fstm.ilisi.commande_service.service;
import java.util.List;

import ma.fstm.ilisi.commande_service.dto.*;
public interface ICommandeService {
public List<CommandeDTO> getAllCommandeDTO();
public List<CommandeAvecClientDTO> getAllCommandeAvecClientDTO();
public CommandeDTO getCommandeDTOById(int id);
public void deleteCommandeDTO(int id);
public CommandeDTO updateCommande(int id, CommandeDTO D);
public CommandeDTO createCommande(CommandeDTO D);
}
