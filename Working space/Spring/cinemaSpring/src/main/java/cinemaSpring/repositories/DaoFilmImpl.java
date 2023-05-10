package cinemaSpring.repositories;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import cinemaSpring.entities.Acteur;
import cinemaSpring.entities.Film;
import cinemaSpring.entities.Langue;

@Repository

class DaoFilmImpl implements DaoFilm {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional
	public void insert(Film obj) {
		em.persist(obj);
			}

	@Override
	@Transactional
	public Film update(Film obj) {
		Film film = null;
		film = em.merge(obj);
		return film;
	}

	@Override
	@Transactional
	public void delete(Film obj) {
		em.remove(em.merge(obj));
			}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Film.class, key));
		}

	@Override
	@Transactional
	public Film findByKey(Long key) {
		Film film = em.find(Film.class, key);
		return film;
	}

	@Override
	@Transactional
	public List<Film> findAll() {
		TypedQuery<Film> query = em.createQuery("from Film", Film.class);
		List<Film> films = query.getResultList();
		return films;
	}

	@Override
	@Transactional
	public List<Film> findByDisponible(boolean disponible) {
		TypedQuery<Film> query = em.createQuery("from Film f where f.disponible=:disponible", Film.class);
		query.setParameter("disponible", disponible);
		List<Film> films = query.getResultList();
		return films;
	}

	@Override
	@Transactional
	public List<Film> findByAnneeSortie(int annee) {
		TypedQuery<Film> query = em.createQuery("from Film f where year(f.sortie)=:annee", Film.class);
		query.setParameter("annee", annee);
		List<Film> films = query.getResultList();
		return films;
	}

	@Override
	@Transactional
	public List<Film> findByActeur(Acteur acteur) {
		TypedQuery<Film> query = em.createQuery("from Film f join f.acteurs as a where a=:acteur", Film.class);
		query.setParameter("acteur", acteur);
		List<Film> films = query.getResultList();
		return films;
	}

	@Override
	@Transactional
	public List<Film> findByEvalutationsNote(int note) {
		TypedQuery<Film> query = em.createQuery(
				"select e.id.film from Evaluation e group by e.id.film having trunc(avg(e.note))=:note", Film.class);
		query.setParameter("note", note);
		List<Film> films = query.getResultList();
		return films;
	}

	@Override
	@Transactional
	public List<Film> findBySeancesDateSeance(LocalDate dateSeance) {
		TypedQuery<Film> query = em.createQuery("from Film f join f.seances as s where s.dateSeance=:dateSeance",
				Film.class);
		query.setParameter("dateSeance", dateSeance);
		List<Film> films = query.getResultList();
		return films;
	}

	@Override
	@Transactional
	public List<Film> findBySeancesLangue(Langue langue) {
		TypedQuery<Film> query = em.createQuery("from Film f join f.seances as s where s.langue=:langue", Film.class);
		query.setParameter("langue", langue);
		List<Film> films = query.getResultList();
		return films;
	}

	@Override
	@Transactional
	public List<Film> findBySeancesDateSeanceAndSeanceLangue(LocalDate dateSeance, Langue langue) {
		TypedQuery<Film> query = em.createQuery(
				"from Film f join f.seances as s where s.langue=:langue and s.dateSeance=:dateSeance", Film.class);
		query.setParameter("langue", langue);
		query.setParameter("dateSeance", dateSeance);
		List<Film> films = query.getResultList();
		return films;
	}

	@Override
	@Transactional
	public Film findByIdFetchEvaluations(Long id) {
		TypedQuery<Film> query = em.createQuery("from Film f left join fetch f.evaluations where f.id=:id", Film.class);
		query.setParameter("id", id);
		Film film = null;
		film = query.getSingleResult();
		return film;
	}

	@Override
	@Transactional
	public Film findByIdFetchActeurs(Long id) {
		TypedQuery<Film> query = em.createQuery("from Film f left join fetch f.acteurs where f.id=:id", Film.class);
		query.setParameter("id", id);
		Film film = null;
		film = query.getSingleResult();
		return film;
	}

	@Override
	@Transactional
	public Film findByIdFetchSeances(Long id) {
		TypedQuery<Film> query = em.createQuery("from Film f left join fetch f.seances where f.id=:id", Film.class);
		query.setParameter("id", id);
		Film film = null;
		film = query.getSingleResult();
		return film;
	}

	@Override
	@Transactional
	public Film findByIdFetchEvaluationsAndActeursAndSeances(Long id) {
		TypedQuery<Film> query = em.createQuery(
				"from Film f left join fetch f.evaluations left join fetch f.acteurs left join fetch f.seances where f.id=:id",
				Film.class);
		query.setParameter("id", id);
		Film film = null;
		film = query.getSingleResult();
		return film;
	}

	@Override
	@Transactional
	public List<Film> findTop10() {
		TypedQuery<Film> query = em
				.createQuery("select e.id.film from Evaluation e group by e.id.film order by avg(e.note)", Film.class);
		query.setMaxResults(10);
		List<Film> films = query.getResultList();
		return films;
	}

}
