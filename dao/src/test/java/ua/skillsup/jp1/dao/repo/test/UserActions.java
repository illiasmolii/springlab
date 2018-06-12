package ua.skillsup.jp1.dao.repo.test;

import org.junit.runner.RunWith;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@Component
public class UserActions {

	void userAction() {
		System.out.println("Action");
	}
}
