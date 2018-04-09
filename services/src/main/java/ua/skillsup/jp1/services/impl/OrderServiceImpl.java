package ua.skillsup.jp1.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.skillsup.jp1.dao.model.Order;
import ua.skillsup.jp1.dao.model.Product;
import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.dao.repo.OrderDao;
import ua.skillsup.jp1.dao.repo.ProductDao;
import ua.skillsup.jp1.dao.repo.UserDao;
import ua.skillsup.jp1.services.OrderService;
import ua.skillsup.jp1.services.ProductService;
import ua.skillsup.jp1.services.dto.OrderItem;

public class OrderServiceImpl implements OrderService {

	private final OrderDao orderDao;
	private final UserDao userDao;
	private final ProductDao productDao;

	private final ProductService productService;

	public OrderServiceImpl(OrderDao orderDao, UserDao userDao, ProductDao productDao,
			ProductService productService) {
		this.orderDao = orderDao;
		this.userDao = userDao;
		this.productDao = productDao;
		this.productService = productService;
	}

	public void create(Long userId, List<OrderItem> items) {
		Order order = initOrder(userId, items);
		reduceProductsCount(items);
		orderDao.create(order);
	}

	private Order initOrder(Long userId, List<OrderItem> items) {
		User user = userDao.findById(userId);
		Map<Product, Integer> productsWithCounts = getProductsWithCounts(items);

		return new Order(null, user, productsWithCounts);
	}

	private Map<Product, Integer> getProductsWithCounts(List<OrderItem> items) {
		List<Long> productIds = getProductsIds(items);
		List<Product> products = productDao.findByIds(productIds);
		Map<Long, Product> productsWithIds = mapProductsToIds(products);

		return mapProductsToCounts(items, productsWithIds);
	}

	private List<Long> getProductsIds(List<OrderItem> items) {
		List<Long> productsIds = new ArrayList<>();
		for (OrderItem item : items) {
			Long productId = item.getProductId();
			productsIds.add(productId);
		}
		return productsIds;
	}

	private Map<Long, Product> mapProductsToIds(List<Product> products) {
		Map<Long, Product> map = new HashMap<>();
		for (Product product : products) {
			if (map.put(product.getId(), product) != null) {
				throw new IllegalStateException("Duplicate key");
			}
		}
		return map;
	}

	private Map<Product, Integer> mapProductsToCounts(List<OrderItem> items, Map<Long, Product> productsWithIds) {
		Map<Product, Integer> productsWithCounts = new HashMap<>();
		for (OrderItem item: items) {
			Product product = productsWithIds.get(item.getProductId());
			Integer count = item.getCount();
			productsWithCounts.put(product, count);
		}
		return productsWithCounts;
	}

	private void reduceProductsCount(List<OrderItem> items) {
		for (OrderItem item : items) {
			Long productId = item.getProductId();
			Integer count = item.getCount();
			productService.reduceCount(productId, count);
		}
	}

	@Override
	public List<Order> findAll() {
		return orderDao.findAll();
	}
}
