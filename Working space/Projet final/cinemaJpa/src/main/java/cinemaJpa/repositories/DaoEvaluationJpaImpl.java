package cinemaJpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import cinemaJpa.entities.Evaluation;
import cinemaJpa.entities.EvaluationKey;

public class DaoEvaluationJpaImpl implements DaoEvaluation{

	@Override
	public void insert(Evaluation obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
		
	}

	@Override
	public Evaluation update(Evaluation obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		obj=em.merge(obj);
		tx.commit();
		em.close();
		return obj;
	}

	@Override
	public void delete(Evaluation obj) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
		
	}

	@Override
	public void deleteByKey(EvaluationKey key) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx=em.getTransaction();
		tx.begin();
		em.remove(em.find(Evaluation.class, key));
		tx.commit();
		em.close();
	}

	@Override
	public Evaluation findByKey(EvaluationKey key) {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		Evaluation Evaluation=em.find(Evaluation.class, key);
		em.close();
		return Evaluation;
	}

	@Override
	public List<Evaluation> findAll() {
		EntityManager em=JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Evaluation> query=em.createQuery("from Evaluation",Evaluation.class);
		List<Evaluation> evaluations=query.getResultList();
		em.close();
		return evaluations;
	}
	
	
	
}
