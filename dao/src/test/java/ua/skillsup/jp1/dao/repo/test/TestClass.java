package ua.skillsup.jp1.dao.repo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context2.xml")
public class TestClass {

	@Autowired
	private DbSteps dbSteps;

	@Autowired
	private UserActions userActions;

	@Autowired
	private Assertions assertions;

	@Value("${key}")
	private String key;

	@Test
	public void test() {
		// given
		dbSteps.doSomething();

		// when
		userActions.userAction();

		// then
		assertions.assertSomehting();

		System.out.println(key);
	}
}
