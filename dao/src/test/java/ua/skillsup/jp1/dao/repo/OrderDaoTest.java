package ua.skillsup.jp1.dao.repo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.skillsup.jp1.dao.model.Order;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional
public class OrderDaoTest {

	@Autowired
	private OrderDao orderDao;

	@Test
	public void test_find_all() {
		List<Order> orders = orderDao.findAll();
		System.out.println(orders);
	}
}
