package cinemaFilm;

import java.time.LocalDate;
import java.time.LocalTime;

import Jpa.context.JpaContext;
import Jpa.entities.Categorie;
import Jpa.entities.Film;
import Jpa.repositories.DaoFilm;

public class AppTest {
	public static void main(String[]args) {
		
		
		
		
		DaoFilm daoFilm=JpaContext.getDaoFilm();
		Film f1 = new Film("Avatar", LocalDate.parse("2021-01-01"), LocalTime.parse("03:12"), true, Categorie.Action);
		daoFilm.insert(f1);
		
		// EN dernier
		
		//Jpacontext.destroy();
		
		
		
		
	}
}
