package ua.skillsup.jp1.services;

import java.util.List;

import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.services.dto.UserDto;

public interface UserService {

	void register(UserDto user);

	List<User> findAll();
}
