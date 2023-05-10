package cinemaSpring.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cinemaSpring.entities.Acteur;

public interface ActeurRepository  extends JpaRepository<Acteur, Integer> {
	
	@Query("from Acteur a left join fetch a.films where a.id=:id")
	Optional<Acteur> findByIdFetchFilms(@Param("id") Integer id);


}
