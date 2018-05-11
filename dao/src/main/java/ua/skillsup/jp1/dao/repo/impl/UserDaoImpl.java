package ua.skillsup.jp1.dao.repo.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
		return null;
	}

	public List<User> findByIds(List<Long> ids) {
		return null;
	}

	public List<User> findAll() {
		return entityManager.createQuery("SELECT u FROM ua.skillsup.jp1.dao.model.User u")
				.getResultList();
	}

	public void update(Long id, User entity) {

	}

	public void delete(Long id) {

	}
}
