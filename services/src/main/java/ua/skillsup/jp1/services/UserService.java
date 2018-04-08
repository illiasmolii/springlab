package ua.skillsup.jp1.services;

import java.util.List;

import ua.skillsup.jp1.dao.model.User;

public interface UserService {

	void register(User user);

	List<User> findAll();
}
