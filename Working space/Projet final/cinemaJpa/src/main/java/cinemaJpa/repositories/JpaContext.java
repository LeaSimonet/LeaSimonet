package cinemaJpa.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext {
	private static EntityManagerFactory emf=null;
	private static DaoFilm daoFilm=new DaoFilmImpl();
	private static DaoActeur daoActeur=new DaoActeurJpaImpl();
	private static DaoClient daoClient=new DaoClientJpaImpl();
	private static DaoAdmin daoAdmin=new DaoAdminJpaImpl();
	private static DaoReservation daoReservation=new DaoReservationJpaImpl();
	private static DaoSeance daoSeance=new DaoSeanceJpaImpl();
	private static DaoSpectateur daoSpectateur=new DaoSpectateurJpaImpl();
	private static DaoSalle daoSalle=new DaoSalleJpaImpl();
	
	public static DaoFilm getDaoFilm() {
		return daoFilm;
	}
	
	public static DaoActeur getDaoActeur() {
		return daoActeur;
	}
	
	public static DaoClient getDaoClient() {
		return daoClient;
	}
	public static DaoAdmin getDaoAdmin() {
		return daoAdmin;
	}

	public static DaoReservation getDaoReservation() {
		return daoReservation;
	}
	
	public static DaoSeance getDaoSeance() {
		return daoSeance;
	}
	
	public static DaoSpectateur getDaoSpectateur() {
		return daoSpectateur;
	}
	
	public static DaoSalle getDaoSalle() {
		return daoSalle;
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(emf==null) {
			emf=Persistence.createEntityManagerFactory("cinemaprojet");
		}
		return emf;
	}
	
	public static void destroy() {
		if(emf!=null) {
			emf.close();
			emf=null;
		}
	}
}
