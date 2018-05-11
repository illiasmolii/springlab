package ua.skillsup.jp1.dao.repo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ua.skillsup.jp1.dao.model.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/test-context.xml")
@Transactional
public class UserDaoTest {

	@Autowired
	private UserDao userDao;

	@Before
	@Sql("cleanup.sql")
	public void init() {

	}

	@Test
	public void test_insert_user() {
		// given
		User user = new User(null, "John", "Doe", 45);

		// when
		userDao.create(user);

		// then
		Assert.assertNotNull(user.getId());
	}
}
