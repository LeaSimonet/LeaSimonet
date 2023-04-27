package Jpa.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Jpa.repositories.DaoFilm;
import Jpa.repositories.DaoFilmJpaImpl;

public class JpaContext {
	
		private static EntityManagerFactory entityManagerFactory;
		private static DaoFilm daoFilm=new DaoFilmJpaImpl();
		
		
		
		public static DaoFilm getDaoFilm() {
			return daoFilm;
		}
		
		public static  EntityManagerFactory getEntityManagerFactory () {
			if(entityManagerFactory==null) {
				entityManagerFactory=Persistence.createEntityManagerFactory("cinema");
			}
			return entityManagerFactory;
		}
		public static void destroy () {
			if(entityManagerFactory!=null) {
				entityManagerFactory.close();
				entityManagerFactory=null;
			}
		}

}
