package ma.fstm.ilisi.client_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ma.fstm.ilisi.client_service.dto.ClientAvecCommandeDTO;
import ma.fstm.ilisi.client_service.dto.ClientDTO;
import ma.fstm.ilisi.client_service.service.ClientService;
import java.util.*;
@RestController
public class ClientController {
@Autowired
ClientService clientservice;
	@GetMapping("/clients")
	public List<ClientDTO> getAllClients(){
		return clientservice.getAllClientDTO();
		
	}
	@GetMapping("API/V2/clients")
	public List<ClientAvecCommandeDTO> getAllClientAvecCommande(){
		return clientservice.getAllClientAvecCommandeDTO();
		
	}
	@PostMapping("/client")
	public ClientDTO createClient(@RequestBody ClientDTO d) {
		return clientservice.createClient(d);
	}
	@GetMapping("/client/{id}")
	public ClientDTO getClient(@PathVariable(name="id") int id) {
		return clientservice.getClientDTOById(id);
	}
	@PutMapping("/client/{id}")
	public ClientDTO updateClient(@PathVariable(name="id") int id, @RequestBody ClientDTO D) {
		return clientservice.updateClient(id, D);
	}
	@DeleteMapping("/client/{id}")
	public void deleteClient(@PathVariable(name="id") int id) {
		clientservice.deleteClientDTO(id);
	}
}
