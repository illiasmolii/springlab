package ua.skillsup.jp1.dao.repo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.skillsup.jp1.dao.generators.IdGenerator;
import ua.skillsup.jp1.dao.model.Product;
import ua.skillsup.jp1.dao.repo.ProductDao;

public class ProductDaoImpl implements ProductDao {

	private final Map<Long, Product> products = new HashMap<>();

	private final IdGenerator<Product> productIdGenerator;

	public ProductDaoImpl(IdGenerator<Product> productIdGenerator) {
		this.productIdGenerator = productIdGenerator;
	}

	public void create(Product product) {
		Long id = productIdGenerator.incrementAndGet();
		product.setId(id);
		products.put(id, product);
	}

	public Product findById(Long id) {
		return null;
	}

	public List<Product> findByIds(List<Long> ids) {
		return null;
	}

	public List<Product> findAll() {
		return new ArrayList<>(products.values());
	}

	public void update(Long id, Product entity) {

	}

	public void delete(Long id) {

	}

	public void reduceCount(Long id, Integer count) {

	}
}
