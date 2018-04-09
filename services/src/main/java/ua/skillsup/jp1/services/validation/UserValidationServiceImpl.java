package ua.skillsup.jp1.services.validation;

import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.services.exceptions.ValidationException;

public class UserValidationServiceImpl implements ValidationService<User> {

	private final static int MIN_NAME_LENGTH = 2;
	private final static int MAX_NAME_LENGTH = 30;
	private final static int MIN_AGE = 18;
	private final static int MAX_AGE = 100;

	private final static String ERROR_USER_IS_NULL =
			"User should not be null";
	private final static String ERROR_FIRST_NAME_TOO_SHORT =
			"User first name should be at least " + MIN_NAME_LENGTH + " characters";
	private final static String ERROR_FIRST_NAME_TOO_LONG =
			"User first name should be as maximum " + MAX_NAME_LENGTH + " characters";
	private final static String ERROR_LAST_NAME_TOO_SHORT =
			"User last name should be at least " + MIN_NAME_LENGTH + " characters";
	private final static String ERROR_LAST_NAME_TOO_LONG =
			"User last name should be as maximum " + MAX_NAME_LENGTH + " characters";
	private final static String ERROR_USER_IS_TOO_YOUNG =
			"User should be at least " + MIN_AGE + " years old";
	private final static String ERROR_USER_IS_TOO_OLD =
			"User should be as maximum " + MAX_AGE + " years old";

	@Override
	public void validate(User user) {
		if (user == null) {
			throw new ValidationException(ERROR_USER_IS_NULL);
		}

		if (user.getFirstName().length() < MIN_NAME_LENGTH) {
			throw new ValidationException(ERROR_FIRST_NAME_TOO_SHORT);
		}

		if (user.getFirstName().length() > MAX_NAME_LENGTH) {
			throw new ValidationException(ERROR_FIRST_NAME_TOO_LONG);
		}

		if (user.getLastName().length() < MIN_NAME_LENGTH) {
			throw new ValidationException(ERROR_LAST_NAME_TOO_SHORT);
		}

		if (user.getLastName().length() > MAX_NAME_LENGTH) {
			throw new ValidationException(ERROR_LAST_NAME_TOO_LONG);
		}

		if (user.getAge() < MIN_AGE) {
			throw new ValidationException(ERROR_USER_IS_TOO_YOUNG);
		}

		if (user.getAge() > MIN_AGE) {
			throw new ValidationException(ERROR_USER_IS_TOO_OLD);
		}
	}
}
