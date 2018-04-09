package ua.skillsup.jp1.services.impl;

import java.util.List;

import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.dao.repo.UserDao;
import ua.skillsup.jp1.services.UserService;
import ua.skillsup.jp1.services.validation.ValidationService;

public class UserServiceImpl implements UserService {

	private final UserDao userDao;


	private final ValidationService<User> userValidationService;

	public UserServiceImpl(UserDao userDao, ValidationService<User> userValidationService) {
		this.userDao = userDao;
		this.userValidationService = userValidationService;
	}

	@Override
	public void register(User user) {
		userValidationService.validate(user);
		userDao.create(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
}
