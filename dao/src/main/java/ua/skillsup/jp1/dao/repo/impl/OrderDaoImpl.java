package ua.skillsup.jp1.dao.repo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.skillsup.jp1.dao.generators.OrderIdGenerator;
import ua.skillsup.jp1.dao.model.Order;
import ua.skillsup.jp1.dao.repo.OrderDao;

public class OrderDaoImpl implements OrderDao {

	private final Map<Long, Order> orders = new HashMap<>();

	private final OrderIdGenerator orderIdGenerator;

	public OrderDaoImpl(OrderIdGenerator orderIdGenerator) {
		this.orderIdGenerator = orderIdGenerator;
	}

	public void create(Order order) {
		Long id = orderIdGenerator.incrementAndGet();
		order.setId(id);
		orders.put(id, order);
	}

	public Order findById(Long id) {
		return null;
	}

	public List<Order> findByIds(List<Long> ids) {
		return null;
	}

	public List<Order> findAll() {
		return new ArrayList<>(orders.values());
	}

	public void update(Long id, Order entity) {

	}

	public void delete(Long id) {

	}
}
