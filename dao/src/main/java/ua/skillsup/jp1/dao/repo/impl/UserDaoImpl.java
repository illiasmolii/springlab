package ua.skillsup.jp1.dao.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.dao.repo.UserDao;

@Repository
public class UserDaoImpl implements UserDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(User user) {
		entityManager.persist(user);
	}

	public User findById(Long id) {
		return entityManager.find(User.class, id);
	}

	public List<User> findByIds(List<Long> ids) {
		Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.id IN :ids");
		query.setParameter("ids", ids);
		return query.getResultList();
	}

	public List<User> findAll() {
		return entityManager.createQuery("SELECT u FROM User u")
				.getResultList();
	}

	public void update(Long id, User entity) {
		entity.setId(id);
		entityManager.merge(entity);
	}

	public void delete(Long id) {
		Query query = entityManager.createQuery("DELETE FROM User u WHERE u.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
