package Jpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import Jpa.context.JpaContext;
import Jpa.entities.Film;

public class DaoFilmJpaImpl implements DaoFilm{

	@Override
	public void insert(Film obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public Film update(Film obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		try {
		obj=em.merge(obj);
		tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
		return obj;
	}

	@Override
	public void delete(Film obj) {
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
		em.remove(em.find(Film.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Film findByKey(Long key) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		Film film=em.find(Film.class, key); // recherche un objet à partir de sa clé. 
		em.close();
		return film;
	}

	@Override
	public List<Film> findAll() {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film", Film.class); // Après le from c'est un nom de classe qu'il faut mettre sinon il ne reconnait pas. 
		// Traduit ça par un select * from product
		List<Film> films=query.getResultList();
		em.close();
		return films;
	}

}
