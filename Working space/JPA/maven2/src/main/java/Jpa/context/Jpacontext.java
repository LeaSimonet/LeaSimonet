package Jpa.context;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Jpacontext {
	
	private static EntityManagerFactory entityManagerFactory;
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
