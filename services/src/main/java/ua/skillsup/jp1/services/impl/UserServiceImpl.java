package ua.skillsup.jp1.services.impl;

import java.util.List;

import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.dao.repo.UserDao;
import ua.skillsup.jp1.services.UserService;
import ua.skillsup.jp1.services.converters.GenericConverter;
import ua.skillsup.jp1.services.dto.UserDto;
import ua.skillsup.jp1.services.validation.ValidationService;

public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	private final GenericConverter<UserDto, User> userConverter;

	private final ValidationService<User> userValidationService;

	public UserServiceImpl(GenericConverter<UserDto, User> userConverter, UserDao userDao,
			ValidationService<User> userValidationService) {
		this.userConverter = userConverter;
		this.userDao = userDao;
		this.userValidationService = userValidationService;
	}

	@Override
	public void register(UserDto userDto) {
		User user = userConverter.toEntity(userDto);
		userValidationService.validate(user);
		userDao.create(user);
	}

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
}
