package cinemaSpring.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cinemaSpring.entities.Reservation;


@Repository

public class DaoReservationJpaImpl implements DaoReservation {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void insert(Reservation obj) {
		em.persist(obj);
			}

	@Override
	@Transactional
	public Reservation update(Reservation obj) {
		Reservation reservation = null;
		reservation = em.merge(obj);
			return reservation;
	}

	@Override
	@Transactional
	public void delete(Reservation obj) {
		em.remove(em.merge(obj));
			}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Reservation.class, key));
			}

	@Override
	@Transactional
	public Reservation findByKey(Long key) {
		Reservation reservation = em.find(Reservation.class, key);
		return reservation;
	}

	@Override
	@Transactional
	public List<Reservation> findAll() {
		TypedQuery<Reservation> query = em.createQuery("from Reservation",Reservation.class);
		List<Reservation> reservations = query.getResultList();
		return reservations;
	}
}
