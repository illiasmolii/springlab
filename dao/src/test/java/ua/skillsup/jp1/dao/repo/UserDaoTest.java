package ua.skillsup.jp1.dao.repo;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
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

	@PersistenceContext
	private EntityManager entityManager;

	@Test
	@Rollback
	public void test_insert_user() {
		// given
		User user = new User(null, "John", "Doe", 45);

		// when
		userDao.create(user);

		// then
		Assert.assertNotNull(user.getId());
	}

	@Test
	@Rollback
	public void test_find_by_id() {
		// given
		User user = new User(null, "John", "Doe", 45);
		userDao.create(user);
		Long id = user.getId();

		// when
		User foundUser = userDao.findById(id);

		// then
		Assert.assertEquals(user, foundUser);
	}

	@Test
	@Rollback
	public void test_find_by_ids() {
		// given
		User user1 = new User(null, "John", "Doe", 45);
		User user2 = new User(null, "Ivan", "Ivanov", 34);
		userDao.create(user1);
		userDao.create(user2);

		// when
		List<User> foundUsers = userDao.findByIds(Arrays.asList(user1.getId(), user2.getId()));

		// then
		Assert.assertEquals(2, foundUsers.size());
		Assert.assertTrue(foundUsers.contains(user1));
		Assert.assertTrue(foundUsers.contains(user2));
	}

	@Test
	@Sql("/sql/cleanup.sql")
	@Rollback
	public void test_find_all() {
		// given
		User user1 = new User(null, "John", "Doe", 45);
		User user2 = new User(null, "Ivan", "Ivanov", 34);
		User user3 = new User(null, "Ann", "Johnson", 25);
		userDao.create(user1);
		userDao.create(user2);
		userDao.create(user3);

		// when
		List<User> foundUsers = userDao.findAll();

		// then
		Assert.assertEquals(3, foundUsers.size());
		Assert.assertTrue(foundUsers.contains(user1));
		Assert.assertTrue(foundUsers.contains(user2));
		Assert.assertTrue(foundUsers.contains(user3));
	}

	@Test
	@Rollback
	public void test_update() {
		// given
		User user = new User(null, "John", "Doe", 45);
		userDao.create(user);
		Long id = user.getId();
		User newUser = new User(null, "Stew", "Robson", 32);

		// when
		userDao.update(id, newUser);

		// then
		User updatedUser = userDao.findById(id);
		Assert.assertEquals(newUser, updatedUser);
	}

	@Test
	@Rollback
	public void test_delete() {
		// given
		User user = new User(null, "John", "Doe", 45);
		userDao.create(user);
		Long id = user.getId();

		// when
		userDao.delete(id);

		// then
		entityManager.clear();
		User deletedUser = userDao.findById(id);
		Assert.assertNull(deletedUser);
	}
}
