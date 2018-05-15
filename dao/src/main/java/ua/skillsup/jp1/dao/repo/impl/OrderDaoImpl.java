package ua.skillsup.jp1.dao.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import ua.skillsup.jp1.dao.model.Order;
import ua.skillsup.jp1.dao.repo.OrderDao;

@Repository
public class OrderDaoImpl implements OrderDao {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Order order) {
		entityManager.persist(order);
	}

	public Order findById(Long id) {
		return null;
	}

	public List<Order> findByIds(List<Long> ids) {
		return null;
	}

	public List<Order> findAll() {
		return entityManager
				.createQuery("SELECT o FROM Order o LEFT JOIN FETCH o.orderItems")
				.getResultList();
	}

	public void update(Long id, Order entity) {

	}

	public void delete(Long id) {

	}
}
