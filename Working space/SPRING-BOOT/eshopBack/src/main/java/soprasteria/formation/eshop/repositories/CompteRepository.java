package soprasteria.formation.eshop.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import soprasteria.formation.eshop.entities.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer>{
	Optional<Compte> findByLogin(String username);
}
