package ua.skillsup.jp1.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;
import ua.skillsup.jp1.dao.model.User;
import ua.skillsup.jp1.dao.repo.GenericDao;
import ua.skillsup.jp1.dao.repo.UserDao;
import ua.skillsup.jp1.services.UserService;
import ua.skillsup.jp1.services.converters.GenericConverter;
import ua.skillsup.jp1.services.dto.UserDto;
import ua.skillsup.jp1.services.validation.ValidationService;

@AllArgsConstructor(onConstructor_={@Autowired})
public class UserServiceImpl implements UserService {

	private GenericDao<User> userDao;
	private GenericConverter<UserDto, User> userConverter;
	private ValidationService<User> userValidationService;

	@Override
	@Transactional
	public void register(UserDto userDto) {
		User user = userConverter.toEntity(userDto);
		userValidationService.validate(user);
		userDao.create(user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<UserDto> findAll() {
		List<UserDto> list = new ArrayList<>();
		for (User user : userDao.findAll()) {
			UserDto userDto = userConverter.toDto(user);
			list.add(userDto);
		}
		return list;
	}
}
