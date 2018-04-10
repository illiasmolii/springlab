package ua.skillsup.jp1.services.impl;

import java.util.List;

import ua.skillsup.jp1.dao.model.Product;
import ua.skillsup.jp1.dao.repo.ProductDao;
import ua.skillsup.jp1.services.ProductService;
import ua.skillsup.jp1.services.converters.GenericConverter;
import ua.skillsup.jp1.services.dto.ProductDto;
import ua.skillsup.jp1.services.exceptions.OutOfStockException;

public class ProductServiceImpl implements ProductService {

	private final ProductDao productDao;

	private final GenericConverter<ProductDto, Product> productConverter;

	public ProductServiceImpl(ProductDao productDao, GenericConverter<ProductDto, Product> productConverter) {
		this.productDao = productDao;
		this.productConverter = productConverter;
	}

	@Override
	public void create(ProductDto productDto) {
		Product product = productConverter.toEntity(productDto);
		productDao.create(product);
	}

	@Override
	public List<Product> findAll() {
		return productDao.findAll();
	}

	@Override
	public void reduceCount(Long id, Integer count) throws OutOfStockException {
		productDao.reduceCount(id, count);
	}
}
