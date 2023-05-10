package cinemaSpring.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cinemaSpring.entities.Seance;

@Repository

public class DaoSeanceJpaImpl implements DaoSeance{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Seance obj) {
		em.persist(obj);
			}

	@Override
	@Transactional
	public Seance update(Seance obj) {
		Seance seance = null;
		seance = em.merge(obj);
		return seance;
	}

	@Override
	@Transactional
	public void delete(Seance obj) {
		em.remove(em.merge(obj));
			}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Seance.class, key));
			}

	@Override
	@Transactional
	public Seance findByKey(Long key) {
		Seance seance = em.find(Seance.class, key);
		return seance;
	}

	@Override
	@Transactional
	public List<Seance> findAll() {
		TypedQuery<Seance> query = em.createQuery("from Seance",Seance.class);
		List<Seance> seances = query.getResultList();
		return seances;
	}

}
