package ma.fstm.ilisi.commande_service.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ma.fstm.ilisi.commande_service.Mapper.ICommandeMapper;
import ma.fstm.ilisi.commande_service.bo.Commande;
import ma.fstm.ilisi.commande_service.dto.CommandeAvecClientDTO;
import ma.fstm.ilisi.commande_service.dto.CommandeDTO;
import ma.fstm.ilisi.commande_service.exception.CommandeNotFoundException;
import ma.fstm.ilisi.commande_service.external.Client;
import ma.fstm.ilisi.commande_service.repository.CommandeRepository;
@Service
public class CommandeService implements ICommandeService {
	ICommandeMapper mapper=new ICommandeMapper() {
		
		@Override
		public CommandeAvecClientDTO mapToCommandeAvecClientDTO(Commande C, Client L) {
			CommandeAvecClientDTO dto=new CommandeAvecClientDTO();
			dto.setId(C.getId());
			dto.setDatecmd(C.getDatecmd());
			dto.setClient(L);
			return dto;
		}
	};
	@Autowired
	CommandeRepository commanderepository;
	@Autowired
	RestTemplate restTemplate;
public CommandeDTO fromCommande(Commande C) {
	return CommandeDTO.builder()
			.id(C.getId())
			.datecmd(C.getDatecmd())
			.idc(C.getIdc())
			.build();
} 
public Commande toCommande(CommandeDTO D) {
	return Commande.builder()
			.id(D.getId())
			.datecmd(D.getDatecmd())
			.idc(D.getIdc())
			.build();
	
	
}
@Override
public List<CommandeDTO> getAllCommandeDTO() {
	
	return commanderepository.findAll().stream()
			.map(cmd->fromCommande(cmd))
			.collect(Collectors.toList())
			;
}
@Override
public CommandeDTO getCommandeDTOById(int id) {
	// TODO Auto-generated method stub
	Optional<Commande> commande= commanderepository.findById(id);
	if (commande.isPresent()) return fromCommande(commande.get());
	else throw new CommandeNotFoundException("Aucune Commande avec ce Id est enregistré...!");
	
}
@Override
public void deleteCommandeDTO(int id) {
	commanderepository.deleteById(id);
	
}
@Override
public CommandeDTO updateCommande(int id, CommandeDTO D) {
	Optional<Commande> oldcommande= commanderepository.findById(id);
	if (oldcommande.isPresent()) {
		D.setId(oldcommande.get().getId());
		D.setDatecmd(oldcommande.get().getDatecmd());
		D.setIdc(oldcommande.get().getIdc());
		return fromCommande(commanderepository.save(toCommande(D)));
		
	}
	else throw new CommandeNotFoundException("Aucune Commande avec ce Id est enregistré...!");
	
}
@Override
public CommandeDTO createCommande(CommandeDTO D) {
	return fromCommande(commanderepository.save(toCommande(D)));
	
}
@Override
public List<CommandeAvecClientDTO> getAllCommandeAvecClientDTO() {
	
	List<Commande> commandes=commanderepository.findAll().stream().collect(Collectors.toList());
	List<CommandeAvecClientDTO> commandedto=new ArrayList<CommandeAvecClientDTO>();
for(Commande C:commandes) {
	Client L=restTemplate.getForObject("http://CLIENT-SERVICE:8089/client/"+C.getIdc(), Client.class);
	commandedto.add(mapper.mapToCommandeAvecClientDTO(C, L));
}
	return commandedto;
}
//for getting commandes by a given Id of client 
public List<CommandeDTO> getCommandeByIdc(int idc) {
return commanderepository.findAll().stream()
.filter(c->c.getIdc()==idc)
.map(cc->fromCommande(cc))
.collect(Collectors.toList());

}

}
