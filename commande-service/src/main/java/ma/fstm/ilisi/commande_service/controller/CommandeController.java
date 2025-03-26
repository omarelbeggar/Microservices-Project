package ma.fstm.ilisi.commande_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import ma.fstm.ilisi.commande_service.dto.CommandeAvecClientDTO;
import ma.fstm.ilisi.commande_service.dto.CommandeDTO;
import ma.fstm.ilisi.commande_service.service.CommandeService;

import java.util.*;
@RestController
public class CommandeController {
@Autowired
CommandeService commandeservice;
	@GetMapping("/commandes")
	public List<CommandeDTO> getAllCommandes(){
		return commandeservice.getAllCommandeDTO();
		
	}
	@GetMapping("API/V2/commandes")
	public List<CommandeAvecClientDTO> getAllCommandeAvecClient(){
		return commandeservice.getAllCommandeAvecClientDTO();
		
	}
	@PostMapping("/commande")
	public CommandeDTO createClient(@RequestBody CommandeDTO d) {
		return commandeservice.createCommande(d);
	}
	@GetMapping("/commande/{id}")
	public CommandeDTO getClient(@PathVariable(name="id") int id) {
		return commandeservice.getCommandeDTOById(id);
	}
	@PutMapping("/commande/{id}")
	public CommandeDTO updateClient(@PathVariable(name="id") int id, @RequestBody CommandeDTO D) {
		return commandeservice.updateCommande(id, D);
	}
	@DeleteMapping("/commande/{id}")
	public void deleteClient(@PathVariable(name="id") int id) {
		commandeservice.deleteCommandeDTO(id);
	}
	@GetMapping("/commandes/{idc}")
	public List<CommandeDTO> getCommandeByIdc(@PathVariable(name="idc") int idc) {
		return commandeservice.getCommandeByIdc(idc);
	}
}
