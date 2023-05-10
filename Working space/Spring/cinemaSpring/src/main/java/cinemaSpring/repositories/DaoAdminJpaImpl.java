package cinemaSpring.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cinemaSpring.entities.Admin;

@Repository
public class DaoAdminJpaImpl implements DaoAdmin {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insert(Admin obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Admin update(Admin obj) {
		Admin admin = null;
		admin = em.merge(obj);
		return admin;
	}

	@Override
	@Transactional
	public void delete(Admin obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Admin.class, key));
	}

	@Override
	@Transactional
	public Admin findByKey(Long key) {
		Admin admin = em.find(Admin.class, key);
		return admin;
	}

	@Override
	@Transactional
	public List<Admin> findAll() {
		TypedQuery<Admin> query = em.createQuery("from Admin", Admin.class);
		List<Admin> admins = query.getResultList();
		return admins;
	}

}
