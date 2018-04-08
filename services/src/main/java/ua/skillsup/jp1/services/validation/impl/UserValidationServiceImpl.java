package ua.skillsup.jp1.services.validation.impl;

import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.services.exceptions.ValidationException;
import ua.skillsup.jp1.services.validation.UserValidationService;

public class UserValidationServiceImpl implements UserValidationService {

	@Override
	public void validate(User user) {
		if (user == null) throw new ValidationException();
	}
}
