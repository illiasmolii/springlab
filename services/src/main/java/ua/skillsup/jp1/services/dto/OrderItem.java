package ua.skillsup.jp1.services.dto;

import lombok.Data;

@Data
public class OrderItem {

	private Long productId;
	private int count;
}
