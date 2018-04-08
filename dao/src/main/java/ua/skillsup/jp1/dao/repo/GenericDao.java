package ua.skillsup.jp1.dao.repo;

import java.util.List;

public interface GenericDao<E> {

	void create(E entity);

	E findById(Long id);

	List<E> findByIds(List<Long> ids);

	List<E> findAll();

	void update(Long id, E entity);

	void delete(Long id);
}
