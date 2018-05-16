package ua.skillsup.jp1.dao.repo.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		return entityManager.find(Order.class, id);
	}

	public List<Order> findByIds(List<Long> ids) {
		TypedQuery<Order> query = entityManager.createQuery(
				"SELECT o FROM Order o LEFT JOIN FETCH o.orderItems WHERE o.id IN :ids",
				Order.class
		);
		query.setParameter("ids", ids);
		return query.getResultList();
	}

	public List<Order> findAll() {
		return entityManager
				.createQuery("SELECT o FROM Order o LEFT JOIN FETCH o.orderItems")
				.getResultList();
	}

	public void update(Long id, Order order) {
		order.setId(id);
		entityManager.merge(order);
	}

	public void delete(Long id) {
		Query query = entityManager.createQuery("DELETE FROM Order o WHERE o.id = :id");
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
