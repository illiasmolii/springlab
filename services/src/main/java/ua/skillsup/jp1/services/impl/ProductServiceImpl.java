package ua.skillsup.jp1.services.impl;

import ua.skillsup.jp1.dao.generators.IdGenerator;
import ua.skillsup.jp1.dao.model.Product;
import ua.skillsup.jp1.dao.repo.ProductDao;
import ua.skillsup.jp1.services.ProductService;
import ua.skillsup.jp1.services.exceptions.OutOfStockException;

public class ProductServiceImpl implements ProductService {

	private final IdGenerator<Product> productIdGenerator;

	private final ProductDao productDao;

	public ProductServiceImpl(IdGenerator<Product> productIdGenerator, ProductDao productDao) {
		this.productIdGenerator = productIdGenerator;
		this.productDao = productDao;
	}

	@Override
	public void create(Product product) {
		product.setId(productIdGenerator.incrementAndGet());
		productDao.create(product);
	}

	@Override
	public void reduceCount(Long id, Integer count) throws OutOfStockException {
		productDao.reduceCount(id, count);
	}
}
