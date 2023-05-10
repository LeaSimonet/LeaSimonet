package cinemaJpa.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import cinemaJpa.entities.Acteur;
import cinemaJpa.entities.Film;
import cinemaJpa.entities.Seance;

public class DaoFilmImpl implements DaoFilm {

	@Override
	public void insert(Film obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.persist(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Film update(Film obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Film film = null;
		tx.begin();
		try {
			film = em.merge(obj);
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
		return film;
	}

	@Override
	public void delete(Film obj) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.remove(em.merge(obj));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		try {
			em.remove(em.find(Film.class, key));
			tx.commit();
		} catch (Exception ex) {
			tx.rollback();
		}
		em.close();
	}

	@Override
	public Film findByKey(Long key) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		Film film = em.find(Film.class, key);
		em.close();
		return film;
	}

	@Override
	public List<Film> findAll() {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery("from Film",Film.class);
		List<Film> films = query.getResultList();
		em.close();
		return films;
	}
	
	
	public List<Film> isFilmDisponible(String titre) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
	    TypedQuery<Film> query = em.createQuery("select f from Film f where f.disponible=true", Film.class);
	    List<Film> films = query.getResultList();
	    em.close();
	    return films;
	}

	
	public List<Film> isFilmIndisponible(String titre) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
	    TypedQuery<Film> query = em.createQuery("select f from Film f where f.disponible=false", Film.class);
	    List<Film> films = query.getResultList();
	    em.close();
	    return films;
	}
	
	
	public List<Film> filmFindByYear(int annee) {
		EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
		TypedQuery<Film> query = em.createQuery(
				"select f from Film where year(f.sortie)=:annee",
				Film.class);
		query.setParameter("annee", annee);
	    List<Film> films = query.getResultList();
	    em.close();
	    return films;
	}
	
	
	public List<Film> findFilmsByActor(Acteur acteur) {
	    EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
	    TypedQuery<Film> query = em.createQuery("SELECT f FROM Film f JOIN f.acteurs a WHERE a = :acteur", Film.class);
	    query.setParameter("acteur", acteur);
	    List<Film> films = query.getResultList();
	    em.close();
	    return films;
	}

	
	
	public List<Film> findFilmsByNoteBetween(double note) {
	    EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
	    TypedQuery<Film> query = em.createQuery("SELECT f FROM Film f JOIN f.note n WHERE n.note BETWEEN :min AND :max", Film.class);
	    query.setParameter("min", min);
	    query.setParameter("max", max);
	    List<Film> films = query.getResultList();
	    em.close();
	    return films;
	}

	
	
	
	public List<Film> findFilmsBySeanceDate(Date date) {
	    EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
	    TypedQuery<Film> query = em.createQuery("from Film f left join f.evaluations as e where e.note between :note and :note+1", Film.class);
	    query.setParameter("date", date);
	    List<Film> films = query.getResultList();
	    em.close();
	    return films;
	}

	
	

	 public List<Film> findBylangue(Seance seance) {
	        EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
	        TypedQuery<Film> query = em.createQuery(
	                "SELECT f FROM Film f left JOIN fetch f.langue l WHERE l = :langue"
	                , Film.class);
	        query.setParameter("seance", seance);
	        List<Film> films = query.getResultList();
	        em.close();
	        return films;
	    }
	 
	 
	 
	
//	 public List<Film> findFilmsByNoteBetween(double min, double max) {
//		    EntityManager em = JpaContext.getEntityManagerFactory().createEntityManager();
//		    TypedQuery<Film> query = em.createQuery("SELECT f FROM Film f JOIN f.note n WHERE n.note BETWEEN :min AND :max", Film.class);
//		    query.setParameter("min", min);
//		    query.setParameter("max", max);
//		    List<Film> films = query.getResultList();
//		    em.close();
//		    return films;
//		}


	
	
	
	
	
}
