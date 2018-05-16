package ua.skillsup.jp1.dao.repo;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.skillsup.jp1.dao.model.Order;
import ua.skillsup.jp1.dao.model.OrderItem;
import ua.skillsup.jp1.dao.model.Product;
import ua.skillsup.jp1.dao.model.Product.Category;
import ua.skillsup.jp1.dao.model.Product.Color;
import ua.skillsup.jp1.dao.model.Product.Gender;
import ua.skillsup.jp1.dao.model.Product.Size;
import ua.skillsup.jp1.dao.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional
public class OrderDaoTest {

	@Autowired
	private OrderDao orderDao;

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	public void test_create_order() {
		// given
		User user = new User(null, "John", "Doe", 42);
		entityManager.persist(user);

		Product product1 = new Product(null, "Levis 501", BigDecimal.TEN, Category.CLOTHES,
				Gender.FEMALE, Color.BLUE, Size.S, 10);
		Product product2 = new Product(null, "Timberland", BigDecimal.TEN, Category.FOOTWEAR,
				Gender.MALE, Color.BLACK, Size.XL, 3);
		entityManager.persist(product1);
		entityManager.persist(product2);

		Order order = new Order(user, null);

		Set<OrderItem> orderItems = new HashSet<>();
		orderItems.add(
				new OrderItem(new OrderItem.Id(null, product1.getId()), order, product1, 1));
		orderItems.add(
				new OrderItem(new OrderItem.Id(null, product2.getId()), order, product2, 2));

		order.setOrderItems(orderItems);

		// when
		orderDao.create(order);

		// then
		Assert.assertNotNull(order.getId());
		orderItems.forEach(orderItem -> Assert.assertNotNull(orderItem.getId()));
	}

	@Test
	public void test_find_order_by_id() {

	}

	@Test
	public void test_find_order_by_ids() {

	}

	@Test
	public void test_find_all_orders() {
		List<Order> orders = orderDao.findAll();
		System.out.println(orders);
	}

	@Test
	public void test_update_order() {

	}

	@Test
	public void test_delete_order() {

	}
}
