package ua.skillsup.jp1.main;

import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import ua.skillsup.jp1.services.OrderService;
import ua.skillsup.jp1.services.ProductService;
import ua.skillsup.jp1.services.UserService;
import ua.skillsup.jp1.services.dto.OrderItem;
import ua.skillsup.jp1.services.dto.ProductDto;
import ua.skillsup.jp1.services.dto.UserDto;

public class Main {

	private final ApplicationContext context = new GenericXmlApplicationContext("context.xml");

	/**
	 * 1st arg:
	 * U - user
	 * P - product
	 * O - order
	 *
	 * 2nd arg:
	 * C - create
	 * L - list
	 *
	 * 3rd and next args:
	 * Creation params (e.g. John Doe 25 - to create a new user)
	 *
	 */
	public static void main(String[] args) {
		new Main().run(args);
	}

	private void run(String args[]) {
		switch (args[0]) {
			case "U":
				userActions(args);
				break;

			case "P":
				productActions(args);
				break;

			case "O":
				orderAction(args);
				break;

			default:
				throw new IllegalArgumentException("Unknown entity: " + args[0]);
		}
	}

	private void userActions(String[] args) {
		String action = args[1];
		UserService userService = context.getBean("userService", UserService.class);

		if ("C".equals(action)) {
			UserDto user = new UserDto(args[2], args[3], args[4]);
			userService.register(user);
			System.out.println("User registered successfully " + user);
		}
		else if ("L".equals(action)) {
			System.out.println(userService.findAll());
		}
		else {
			throw new UnsupportedOperationException("Unknown action: " + action);
		}
	}

	private void productActions(String[] args) {
		String action = args[1];
		ProductService productService = context.getBean("productService", ProductService.class);

		if ("C".equals(action)) {
			ProductDto productDto = new ProductDto(args[2], args[3], args[4], args[5], args[6], args[7], args[8]);
			productService.create(productDto);
			System.out.println("Product created successfully " + productDto);
		}
		else if ("L".equals(action)) {
			System.out.println(productService.findAll());
		}
		else {
			throw new UnsupportedOperationException("Unknown action: " + action);
		}
	}

	private void orderAction(String[] args) {
		String action = args[1];
		OrderService orderService = context.getBean("orderService", OrderService.class);

		if ("C".equals(action)) { //TODO
			Long userId = 0L;
			List<OrderItem> items = Collections.emptyList();
			orderService.create(userId, items);
			System.out.println("Order created successfully");
		}
		else if ("L".equals(action)) {
			System.out.println(orderService.findAll());
		}
		else {
			throw new UnsupportedOperationException("Unknown action: " + action);
		}
	}
}
