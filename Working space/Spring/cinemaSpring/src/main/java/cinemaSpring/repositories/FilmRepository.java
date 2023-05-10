package cinemaSpring.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import cinemaSpring.entities.Acteur;
import cinemaSpring.entities.Film;
import cinemaSpring.entities.Langue;

public interface FilmRepository extends JpaRepository<Film, Integer>{
	
	List<Film> findByDisponible(boolean disponible);

	List<Film> findByAnneeSortie(int annee);

	List<Film> findByActeur(Acteur acteur);

	List<Film> findByEvalutationsNote(int note);

	List<Film> findBySeancesDateSeance(LocalDate dateSeance);

	List<Film> findBySeancesLangue(Langue langue);

	List<Film> findBySeancesDateSeanceAndSeanceLangue(LocalDate dateSeance, Langue langue);

	@Query("from Film f left join fetch f.evaluations where f.id=:id")
	Optional<Film> findByIdFetchEvaluations(@Param("id") Long id);

	@Query("from Film f left join fetch f.acteurs where f.id=:id")
	Optional<Film> findByIdFetchActeurs(@Param("id") Long id);

	
	@Query("from Film f left join fetch f.seances where f.id=:id")
	Optional<Film> findByIdFetchSeances(@Param("id") Long id);

	@Query("from Film f left join fetch f.evaluations left join fetch f.acteurs left join fetch f.seances where f.id=:id")
	Optional<Film> findByIdFetchEvaluationsAndActeursAndSeances(@Param("id") Long id);

	
	List<Film> findTop10();

}
