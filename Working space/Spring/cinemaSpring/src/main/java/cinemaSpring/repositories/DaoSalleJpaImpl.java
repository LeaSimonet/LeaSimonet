package cinemaSpring.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cinemaSpring.entities.Salle;


@Repository

public class DaoSalleJpaImpl implements DaoSalle{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Salle obj) {
		em.persist(obj);
			}

	@Override
	@Transactional
	public Salle update(Salle obj) {
		Salle salle = null;
		salle = em.merge(obj);
			return salle;
	}

	@Override
	@Transactional
	public void delete(Salle obj) {
		em.remove(em.merge(obj));
			}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Salle.class, key));
			}

	@Override
	@Transactional
	public Salle findByKey(Long key) {
		Salle salle = em.find(Salle.class, key);
		return salle;
	}

	@Override
	@Transactional
	public List<Salle> findAll() {
		TypedQuery<Salle> query = em.createQuery("from Salle",Salle.class);
		List<Salle> salles = query.getResultList();
		return salles;
	}

}
