package ua.skillsup.jp1.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDto {

	private String name;
	private String price;
	private String category;
	private String gender;
	private String color;
	private String size;
	private String remainingCount;
}
