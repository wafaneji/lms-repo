package lmsClient.tests.junit;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import entities.User;
import services.interfaces.UserServicesRemote;

public class TestUserServices {
	private Context context;
	private UserServicesRemote userServicesRemote;

	@Before
	public void setUp() throws Exception {
		context = new InitialContext();
		userServicesRemote = (UserServicesRemote) context
				.lookup("/lms/lmsEJB/UserServices!services.interfaces.UserServicesRemote");
	}

	@Test
	public void testAddUser() {
		User user = new User();
		user.setId(1);
		user.setName("wafa");

		Assert.assertTrue(userServicesRemote.addUser(user));

	}

	@Test
	public void testUpdateUser() {
		User user = userServicesRemote.findUserById(1);
		user.setName("new wafa");

		Assert.assertTrue(userServicesRemote.updateUser(user));

	}

	@Test
	public void testDeleteUser() {
		Assert.assertTrue(userServicesRemote.deleteUser(1));

	}

	@Test
	public void testFindAllUsers() {
		List<User> users = userServicesRemote.findAllUsers();

		Assert.assertEquals(1, users.size());

	}
}
