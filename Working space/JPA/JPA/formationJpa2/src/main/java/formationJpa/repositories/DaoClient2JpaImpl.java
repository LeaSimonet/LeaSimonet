package formationJpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Client2;
import formationJpa.entities.Produit;

public class DaoClient2JpaImpl implements DaoClient2 {

	@Override
	public void insert(Client2 obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Client2 update(Client2 obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		obj=em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Client2 obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.remove(em.find(Produit.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Client2 findByKey(Long key) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		Client2 client2=em.find(Client2.class, key);
		em.close();
		return client2;
	}

	@Override
	public List<Client2> findAll() {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client2> query=em.createQuery("from Client2",Client2.class);
		List<Client2> client2s=query.getResultList();
		em.close();
		return client2s;
	}

}
