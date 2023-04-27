package formationJpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.entities.Client2;
import formationJpa.entities.Fournisseur;
import formationJpa.entities.Personne;
import formationJpa.entities.Produit;

class DaoPersonneJpaImpl implements DaoPersonne {

	@Override
	public void insert(Personne obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Personne update(Personne obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		obj=em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Personne obj) {
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
	public Personne findByKey(Long key) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		Personne personne=em.find(Personne.class, key);
		em.close();
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Personne> query=em.createQuery("from Personne",Personne.class);
		List<Personne> personne=query.getResultList();
		em.close();
		return personne;

	}
	
	public List<Client2> findAllClient() {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Client2> query=em.createQuery("from Client2",Client2.class);
		List<Client2> client=query.getResultList();
		em.close();
		return client;

	}
	
	public List<Fournisseur> findAllFournisseur() {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Fournisseur> query=em.createQuery("from Fournisseur",Fournisseur.class);
		List<Fournisseur> fournisseur=query.getResultList();
		em.close();
		return fournisseur;

	}

}
