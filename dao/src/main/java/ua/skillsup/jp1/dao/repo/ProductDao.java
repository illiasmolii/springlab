package ua.skillsup.jp1.dao.repo;

import ua.skillsup.jp1.dao.model.Product;

public interface ProductDao extends GenericDao<Product> {

	void reduceCount(Long id, Integer count);
}
