package ua.skillsup.jp1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ua.skillsup.jp1.services.UserService;
import ua.skillsup.jp1.services.dto.UserDto;

// http://websystique.com/springmvc/spring-4-mvc-helloworld-tutorial-annotation-javaconfig-full-example/
@Controller
@RequestMapping("/users")
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<UserDto> getAll() {
		return userService.findAll();
	}
}
