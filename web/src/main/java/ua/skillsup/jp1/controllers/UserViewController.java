package ua.skillsup.jp1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/users/view")
@Slf4j
public class UserViewController {

	@RequestMapping(method = RequestMethod.GET)
	public String userView() {
		return "users";
	}
}
