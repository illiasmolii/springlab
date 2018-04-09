package ua.skillsup.jp1.dao.repo.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ua.skillsup.jp1.dao.generators.IdGenerator;
import ua.skillsup.jp1.dao.generators.UserIdGenerator;
import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.dao.repo.UserDao;

public class UserDaoImpl implements UserDao {

	private final Map<Long, User> users = new HashMap<>();

	private final IdGenerator<User> userIdGenerator;

	public UserDaoImpl(UserIdGenerator userIdGenerator) {
		this.userIdGenerator = userIdGenerator;
	}

	public void create(User user) {
		Long id = userIdGenerator.incrementAndGet();
		user.setId(id);
		users.put(id, user);
	}

	public User findById(Long id) {
		return null;
	}

	public List<User> findByIds(List<Long> ids) {
		return null;
	}

	public List<User> findAll() {
		return new ArrayList<>(users.values());
	}

	public void update(Long id, User entity) {

	}

	public void delete(Long id) {

	}
}
