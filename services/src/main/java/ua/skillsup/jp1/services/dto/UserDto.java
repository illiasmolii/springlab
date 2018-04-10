package ua.skillsup.jp1.services.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {

	private String firstName;
	private String lastName;
	private String age;
}
