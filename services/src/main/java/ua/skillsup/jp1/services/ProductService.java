package ua.skillsup.jp1.services;

import java.util.List;

import ua.skillsup.jp1.dao.model.Product;
import ua.skillsup.jp1.services.dto.ProductDto;
import ua.skillsup.jp1.services.exceptions.OutOfStockException;

public interface ProductService {

	void create(ProductDto product);

	List<Product> findAll();

	void reduceCount(Long id, Integer count) throws OutOfStockException;
}
