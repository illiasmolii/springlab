package ua.skillsup.jp1.services.converters;


import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.services.dto.UserDto;
import ua.skillsup.jp1.services.exceptions.ValidationException;

public class UserConverter implements GenericConverter<UserDto, User> {

	@Override
	public UserDto toDto(User user) {
		return new UserDto(user.getFirstName(), user.getLastName(), String.valueOf(user.getAge()));
	}

	@Override
	public User toEntity(UserDto dto) {
		if (dto == null
				|| dto.getFirstName() == null
				|| dto.getLastName() == null) {
			throw new ValidationException("User, first name & last name should not be null");
		}

		return new User(
				null,
				dto.getFirstName(),
				dto.getLastName(),
				getAge(dto.getAge())
		);
	}

	private int getAge(String age) {
		if (age == null) throw new ValidationException("Age should not be null");

		try {
			return Integer.parseInt(age);
		} catch (NumberFormatException e) {
			throw new ValidationException("Invalid age: " + age);
		}
	}
}
