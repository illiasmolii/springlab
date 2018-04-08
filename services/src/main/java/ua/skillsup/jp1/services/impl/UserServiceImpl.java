package ua.skillsup.jp1.services.impl;

import java.util.List;

import ua.skillsup.jp1.dao.generators.IdGenerator;
import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.dao.repo.UserDao;
import ua.skillsup.jp1.services.UserService;

public class UserServiceImpl implements UserService {

	private final UserDao userDao;

	private final IdGenerator<User> userIdGenerator;

	public UserServiceImpl(UserDao userDao, IdGenerator<User> userIdGenerator) {
		this.userDao = userDao;
		this.userIdGenerator = userIdGenerator;
	}

	@Override
	public void register(User user) {
		user.setId(userIdGenerator.incrementAndGet());
		userDao.create(user);
	}

	@Override
	public List<User> findAll() {
		return null;
	}
}
