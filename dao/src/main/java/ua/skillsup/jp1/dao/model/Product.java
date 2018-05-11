package ua.skillsup.jp1.dao.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PRODUCTS")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "PRICE", nullable = false)
	private BigDecimal price;

	@Column(name = "CATEGORY", nullable = false)
	@Enumerated(EnumType.STRING)
	private Category category;

	@Column(name = "GENDER", nullable = false)
	@Enumerated(EnumType.STRING)
	private Gender gender;

	@Column(name = "COLOR", nullable = false)
	@Enumerated(EnumType.STRING)
	private Color color;

	@Column(name = "SIZE", nullable = false)
	@Enumerated(EnumType.STRING)
	private Size size;

	@Column(name = "REMAINING_COUNT", nullable = false)
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
