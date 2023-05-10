package cinemaSpring.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cinemaSpring.entities.Admin;
import cinemaSpring.entities.Client;
import cinemaSpring.entities.Compte;


@Repository
public class DaoCompteJpaImpl implements DaoCompte {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Compte obj) {
		em.persist(obj);
		}

	@Override
	@Transactional
	public Compte update(Compte obj) {
		Compte compte = null;
		compte = em.merge(obj);
			return compte;
	}

	@Override
	@Transactional
	public void delete(Compte obj) {
		em.remove(em.merge(obj));
			}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Compte.class, key));
			}

	@Override
	@Transactional
	public Compte findByKey(Long key) {
		Compte compte = em.find(Compte.class, key);
		return compte;
	}

	@Override
	@Transactional
	public List<Compte> findAll() {
		TypedQuery<Compte> query = em.createQuery("from Compte",Compte.class);
		List<Compte> comptes = query.getResultList();
		return comptes;
	}
	
	@Override
	@Transactional
	public List<Client> findAllClient() {
		TypedQuery<Client> query = em.createQuery("from Client", Client.class);
		List<Client> comptes = query.getResultList();
		return comptes;
	}
	
	
	@Override
	@Transactional
	public List<Admin> findAllAdmin() {
		TypedQuery<Admin> query = em.createQuery("from Admin", Admin.class);
		List<Admin> comptes = query.getResultList();
		return comptes;
	}



}
