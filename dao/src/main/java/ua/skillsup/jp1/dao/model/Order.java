package ua.skillsup.jp1.dao.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

	private Long id;
	private User user;
	private Map<Product, Integer> products;
}
