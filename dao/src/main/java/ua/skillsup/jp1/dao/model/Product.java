package ua.skillsup.jp1.dao.model;

import java.math.BigDecimal;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Product {

	private Long id;
	private String name;
	private BigDecimal price;
	private Category category;
	private Gender gender;
	private Color color;
	private Size size;
	private int remainingCount;

	public enum Category {
		CLOTHES, FOOTWEAR, ACCESSORISE
	}

	public enum Gender {
		MALE, FEMALE, UNISEX
	}

	public enum Color {
		WHITE, YELLOW, ROSE, RED, GREEN, BLUE, PURPLE, GREY, BLACK
	}

	public enum Size {
		S, M, L, XL
	}
}
