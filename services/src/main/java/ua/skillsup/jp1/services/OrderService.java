package ua.skillsup.jp1.services;

import java.util.List;

import ua.skillsup.jp1.dao.model.Order;
import ua.skillsup.jp1.services.dto.OrderItem;

public interface OrderService {

	void create(Long userId, List<OrderItem> items);

	List<Order> findAll();
}
