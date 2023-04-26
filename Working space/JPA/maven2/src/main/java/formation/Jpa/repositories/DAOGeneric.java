package formation.Jpa.repositories;

import java.util.List;

public interface DAOGeneric<T, K> {
	void insert(T obj);

	T update(T obj);

	void delete(T obj);

	void deleteByKey(K key);

	T findByKey(K key);

	List<T> findAll();

//T et K sont deux objets
}
