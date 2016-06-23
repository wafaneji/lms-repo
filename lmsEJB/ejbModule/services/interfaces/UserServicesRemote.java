package services.interfaces;

import java.util.List;

import javax.ejb.Remote;

import entities.User;

@Remote
public interface UserServicesRemote {
	Boolean addUser(User user);

	Boolean deleteUser(Integer userId);

	Boolean updateUser(User user);

	User findUserById(Integer id);

	List<User> findAllUsers();
}
