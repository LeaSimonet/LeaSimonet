package cinemaSpring.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cinemaSpring.entities.Spectateur;

@Repository

public class DaoSpectateurJpaImpl implements DaoSpectateur {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Spectateur obj) {
		em.persist(obj);
			}

	@Override
	@Transactional
	public Spectateur update(Spectateur obj) {
		Spectateur spectateur = null;
		spectateur = em.merge(obj);
			em.close();
		return spectateur;
	}

	@Override
	@Transactional
	public void delete(Spectateur obj) {
		em.remove(em.merge(obj));
			}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Spectateur.class, key));
			}

	@Override
	@Transactional
	public Spectateur findByKey(Long key) {
		Spectateur spectateur = em.find(Spectateur.class, key);
		return spectateur;
	}

	@Override
	@Transactional
	public List<Spectateur> findAll() {
		TypedQuery<Spectateur> query = em.createQuery("from Spectateur",Spectateur.class);
		List<Spectateur> spectateurs = query.getResultList();
		return spectateurs;
	}

}
