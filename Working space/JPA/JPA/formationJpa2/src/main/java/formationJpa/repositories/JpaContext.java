package formationJpa.repositories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaContext {

	private static EntityManagerFactory entityManagerFactory=null;
	private static DaoProduit daoProduit=new DaoProduitJpaImpl();
	private static DaoClient2 daoClient2=new DaoClient2JpaImpl();
	private static DaoFournisseur daoFournisseur=new DaoFournisseurJpaImpl();
	
	public static DaoClient2 getDaoClient2() {
		return daoClient2;
	}
	
	public static DaoProduit getDaoProduit() {
		return daoProduit;
	}
	
	public static DaoFournisseur getDaoFournisseur() {
		return daoFournisseur;
	}
	
	public static EntityManagerFactory getEntityManagerFactory() {
		if(entityManagerFactory==null) {
			entityManagerFactory=Persistence.createEntityManagerFactory("cinema");
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
