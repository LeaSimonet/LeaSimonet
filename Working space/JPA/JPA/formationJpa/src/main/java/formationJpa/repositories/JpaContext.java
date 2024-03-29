package formationJpa.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext {

	private static EntityManagerFactory entityManagerFactory=null;
	private static DaoProduit daoProduit=new DaoProduitJpaImpl();
	private static DaoClient daoClient=new DaoClientJpaImpl();
	private static DaoPersonne daoPersonne=new DaoPersonneJpaImpl();
	
	public static DaoClient getDaoClient() {
		return daoClient;
	}
	
	public static DaoProduit getDaoProduit() {
		return daoProduit;
	}
	
	public static DaoPersonne getDaoPersonne() {
		return daoPersonne;
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory==null) {
			entityManagerFactory=Persistence.createEntityManagerFactory("eshop");
		}
		return entityManagerFactory;
	}
	
	public static void destroy() {
		if(entityManagerFactory!=null) {
			entityManagerFactory.close();
			entityManagerFactory=null;
		}
	}
}
