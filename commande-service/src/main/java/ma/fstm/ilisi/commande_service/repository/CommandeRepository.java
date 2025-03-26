
package ma.fstm.ilisi.commande_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.fstm.ilisi.commande_service.bo.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Integer> {

}
