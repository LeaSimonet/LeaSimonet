package cinemaJpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import cinemaJpa.entities.Client;

public class DaoClientJpaImpl implements DaoClient {

	@Override
	public void insert(Client obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try{
			em.persist(obj);
			tx.commit();
		} catch (Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}
		
		em.close();
	}

	@Override
	public Client update(Client obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try{
			obj=em.merge(obj);
			tx.commit();
		} catch (Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}
		em.close();
		return obj;
	}

	@Override
	public void delete(Client obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try{
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try{
			em.remove(em.find(Client.class, key));
			tx.commit();
		} catch (Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Client findByKey(Long key) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		Client client=em.find(Client.class, key);
		em.close();
		return client;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client> query=em.createQuery("from Client",Client.class);
		List<Client> clients=query.getResultList();
		em.close();
		return clients;
	}

	public List<Client> findMajor(){
		 EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		    TypedQuery<Client> query = em.createQuery( "Select c from Client c where timestampdiff(year, c.naissance, current_date)>=18", 
		    		Client.class
		    );
		    List<Client> clients = query.getResultList();
		    em.close();
		    return clients;
	}
	
	public List<Client> findMineur(){
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
	    TypedQuery<Client> query = em.createQuery( "Select c from Client c where timestampdiff(year, c.naissance, current_date)<18", 
	    		Client.class
	    );
	    List<Client> clients = query.getResultList();
	    em.close();
	    return clients;
	}
	
	public List<Client> findSenior(){
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
	    TypedQuery<Client> query = em.createQuery( "Select c from Client c where timestampdiff(year, c.naissance, current_date)>=18", 
	    		Client.class
	    );
	    List<Client> clients = query.getResultList();
	    em.close();
	    return clients;
	}


	
	
	
	
}
