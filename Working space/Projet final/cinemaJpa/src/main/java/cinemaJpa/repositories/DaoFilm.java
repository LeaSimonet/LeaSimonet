package cinemaJpa.repositories;

import java.util.List;

import cinemaJpa.entities.Acteur;
import cinemaJpa.entities.Film;

public interface DaoFilm extends DaoGeneric<Film, Long>{
	
	//public List<Film> findFilmsByNoteBetween(double min, double max);

	public List<Film> isFilmDisponible(boolean disponible);

	public List<Film> isFilmIndisponible(String titre);

	public List<Film> filmFindByYear(int sortie);

	public List<Film> findFilmsByActor(Acteur acteur);

}
