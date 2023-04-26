package Jpa.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import formation.Jpa.repositories.DaoProduit;
import formation.Jpa.repositories.DaoProduitJpaImpl;

public class Jpacontext {
	
	private static EntityManagerFactory entityManagerFactory;
	private static DaoProduit daoProduit=new DaoProduitJpaImpl();
	
	
	
	public static DaoProduit getDaoProduit() {
		return daoProduit;
	}
	
	public static  EntityManagerFactory getEntityManagerFactory () {
		if(entityManagerFactory==null) {
			entityManagerFactory=Persistence.createEntityManagerFactory("eshop");
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
