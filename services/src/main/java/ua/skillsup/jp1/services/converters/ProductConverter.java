package ua.skillsup.jp1.services.converters;

import java.math.BigDecimal;

import ua.skillsup.jp1.dao.model.Product;
import ua.skillsup.jp1.services.dto.ProductDto;
import ua.skillsup.jp1.services.exceptions.ValidationException;

public class ProductConverter implements GenericConverter<ProductDto, Product> {

	@Override
	public ProductDto toDto(Product entity) {
		return null;
	}

	@Override
	public Product toEntity(ProductDto dto) {
		if (dto == null) throw new ValidationException("Product should not be null");

		BigDecimal price = getPrice(dto.getPrice());
		Product.Category category = getCategory(dto.getCategory());
		Product.Gender gender = getGender(dto.getGender());
		Product.Color color = getColor(dto.getColor());
		Product.Size size = getSize(dto.getSize());
		int remainingCount = getRemainingCount(dto.getRemainingCount());

		return new Product(
				null,
				dto.getName(),
				price,
				category,
				gender,
				color,
				size,
				remainingCount
		);
	}

	private BigDecimal getPrice(String price) {
		try {
			return new BigDecimal(price);
		} catch (NumberFormatException e) {
			throw new ValidationException("Invalid price");
		}
	}

	private Product.Category getCategory(String category) {
		if (category == null) throw new ValidationException("Category should not be null");

		try {
			return Product.Category.valueOf(category);
		} catch (IllegalArgumentException e) {
			throw new ValidationException("Invalid category " + category);
		}
	}

	private Product.Gender getGender(String gender) {
		if (gender == null) throw new ValidationException("Gender should not be null");

		try {
			return Product.Gender.valueOf(gender);
		} catch (IllegalArgumentException e) {
			throw new ValidationException("Invalid gender " + gender);
		}
	}

	private Product.Color getColor(String color) {
		if (color == null) throw new ValidationException("Color should not be null");

		try {
			return Product.Color.valueOf(color);
		} catch (IllegalArgumentException e) {
			throw new ValidationException("Invalid color " + color);
		}
	}

	private Product.Size getSize(String size) {
		if (size == null) throw new ValidationException("Size should not be null");

		try {
			return Product.Size.valueOf(size);
		} catch (IllegalArgumentException e) {
			throw new ValidationException("Invalid size " + size);
		}
	}

	private int getRemainingCount(String remainingCount) {
		if (remainingCount == null) throw new ValidationException("Remaining count should not be null");

		try {
			return Integer.parseInt(remainingCount);
		} catch (NumberFormatException e) {
			throw new ValidationException("Invalid remaining count " + remainingCount);
		}
	}
}
