package ua.skillsup.jp1.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;
import ua.skillsup.jp1.services.UserService;
import ua.skillsup.jp1.services.dto.UserDto;

@Controller
@RequestMapping("/users")
@Slf4j
public class UserController {

	private final UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<UserDto> getAll() {
		log.info("Find all users");
		return userService.findAll();
	}
}
