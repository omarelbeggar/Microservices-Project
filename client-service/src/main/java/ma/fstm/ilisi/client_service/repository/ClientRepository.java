
package ma.fstm.ilisi.client_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.fstm.ilisi.client_service.bo.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
