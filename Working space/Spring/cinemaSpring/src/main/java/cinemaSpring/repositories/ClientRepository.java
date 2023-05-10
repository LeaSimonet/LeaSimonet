package cinemaSpring.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cinemaSpring.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer>{
	
	List<Client> findMajeur();

	List<Client> findMineur();

	List<Client> findSenior();

	
	@Query("from Client c left join fetch c.reservations where c.id=:id ")
	Optional<Client> findByIdFetchReservations(@Param("id") Integer id);

	@Query("from Client c left join fetch c.evaluations where c.id=:id ")
	Optional<Client> findByIdFetchEvaluations(@Param("id") Integer id);

	@Query("from Client c left join fetch c.reservations left join fetch c.evaluations where c.id=:id ")
	Optional<Client> findByIdFetchReservationsAndEvaluations(@Param("id") Long id);



}
