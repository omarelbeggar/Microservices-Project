package ma.fstm.ilisi.client_service.service;
import java.util.List;

import ma.fstm.ilisi.client_service.dto.*;
public interface IClientService {
public List<ClientDTO> getAllClientDTO();
public List<ClientAvecCommandeDTO> getAllClientAvecCommandeDTO();
public ClientDTO getClientDTOById(int id);
public void deleteClientDTO(int id);
public ClientDTO updateClient(int id, ClientDTO D);
public ClientDTO createClient(ClientDTO D);
}
