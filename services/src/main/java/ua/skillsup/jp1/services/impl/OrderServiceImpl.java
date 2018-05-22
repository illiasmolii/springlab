package ua.skillsup.jp1.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ua.skillsup.jp1.dao.model.Order;
import ua.skillsup.jp1.dao.model.OrderItem;
import ua.skillsup.jp1.dao.model.Product;
import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.dao.repo.OrderDao;
import ua.skillsup.jp1.dao.repo.ProductDao;
import ua.skillsup.jp1.dao.repo.UserDao;
import ua.skillsup.jp1.services.OrderService;
import ua.skillsup.jp1.services.ProductService;
import ua.skillsup.jp1.services.dto.OrderItemDto;

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

	@Override
	public void create(Long userId, List<OrderItemDto> items) {
		Order order = initOrder(userId, items);
		reduceProductsCount(items);
		orderDao.create(order);
	}

	private Order initOrder(Long userId, List<OrderItemDto> items) {
		User user = userDao.findById(userId);
		Set<OrderItem> orderItems = getProductsWithCounts(items);
		Order order = new Order(user, orderItems);
		orderItems.forEach(orderItem -> orderItem.setOrder(order));
		return order;
	}

	private Set<OrderItem>  getProductsWithCounts(List<OrderItemDto> items) {
		List<Long> productIds = getProductsIds(items);
		List<Product> products = productDao.findByIds(productIds);
		Map<Long, Product> productsToIds = mapProductsToIds(products);

		return initOrderItems(items, productsToIds);
	}

	private List<Long> getProductsIds(List<OrderItemDto> items) {
		List<Long> productsIds = new ArrayList<>();
		for (OrderItemDto item : items) {
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

	private Set<OrderItem> initOrderItems(List<OrderItemDto> items, Map<Long, Product> products) {
		Set<OrderItem> orderItems = new HashSet<>();
		for (OrderItemDto itemDto: items) {
			Long productId = itemDto.getProductId();
			Product product = products.get(productId);
			Integer count = itemDto.getCount();
			orderItems.add(new OrderItem(null, null, product, count));
		}
		return orderItems;
	}

	private void reduceProductsCount(List<OrderItemDto> items) {
		for (OrderItemDto item : items) {
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
