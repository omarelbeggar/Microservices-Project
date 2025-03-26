package ma.fstm.ilisi.client_service.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import ma.fstm.ilisi.client_service.bo.Client;
import ma.fstm.ilisi.client_service.dto.ClientAvecCommandeDTO;
import ma.fstm.ilisi.client_service.dto.ClientDTO;
import ma.fstm.ilisi.client_service.exception.ClientNotFoundException;
import ma.fstm.ilisi.client_service.external.Commande;
import ma.fstm.ilisi.client_service.mapper.IClientMapper;
import ma.fstm.ilisi.client_service.repository.ClientRepository;
@Service
public class ClientService implements IClientService {
	
	@Autowired
	ClientRepository clientrepository;
	@Autowired
	RestTemplate restTemplate;
IClientMapper mapper=new IClientMapper() {
	
	@Override
	public ClientAvecCommandeDTO mapToClientAvecCommande(Client C, List<Commande> commandes) {
		ClientAvecCommandeDTO dto=new ClientAvecCommandeDTO();
		dto.setId(C.getId());
		dto.setNom(C.getNom());
		dto.setCommandes(commandes);
		return dto;
	}
};	
public ClientDTO fromClient(Client C) {
	return ClientDTO.builder()
			.id(C.getId())
			.nom(C.getNom())
			.build();
} 
public Client toClient(ClientDTO D) {
	return Client.builder()
			.id(D.getId())
			.nom(D.getNom())
			.build();
	
	
}
@Override
public List<ClientDTO> getAllClientDTO() {
	
	return clientrepository.findAll().stream()
			.map(client->fromClient(client))
			.collect(Collectors.toList())
			;
}
@Override
public ClientDTO getClientDTOById(int id) {
	// TODO Auto-generated method stub
	Optional<Client> client= clientrepository.findById(id);
	if (client.isPresent()) return fromClient(client.get());
	else throw new ClientNotFoundException("Aucun client avec ce Id est enregistré...!");
	
}
@Override
public void deleteClientDTO(int id) {
	clientrepository.deleteById(id);
	
}
@Override
public ClientDTO updateClient(int id, ClientDTO D) {
	Optional<Client> oldclient= clientrepository.findById(id);
	if (oldclient.isPresent()) {
		D.setId(oldclient.get().getId());
		D.setNom(oldclient.get().getNom());
		return fromClient(clientrepository.save(toClient(D)));
		
	}
	else throw new ClientNotFoundException("Aucun client avec ce Id est enregistré...!");
	
}
@Override
public ClientDTO createClient(ClientDTO D) {
	return fromClient(clientrepository.save(toClient(D)));
	
}
@Override
public List<ClientAvecCommandeDTO> getAllClientAvecCommandeDTO() {
	
	List<ClientAvecCommandeDTO> clientdto=new ArrayList<ClientAvecCommandeDTO>();
	List<Client> clients=clientrepository.findAll().stream()
	.collect(Collectors.toList());
	for(Client C:clients) {
	ResponseEntity<List<Commande>> responsetemp=restTemplate.exchange(
			"http://COMMANDE-SERVICE:8079/commandes/"+C.getId(),
			HttpMethod.GET,
			null,
			new ParameterizedTypeReference<List<Commande>>() {
			});
	List<Commande> commandes=responsetemp.getBody();
	
	clientdto.add(mapper.mapToClientAvecCommande(C, commandes));
	
	}
	
	return clientdto;
}
}
