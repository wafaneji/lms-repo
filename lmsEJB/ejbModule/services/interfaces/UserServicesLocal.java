package services.interfaces;

import java.util.List;

import javax.ejb.Local;

import entities.User;

@Local
public interface UserServicesLocal {
	Boolean addUser(User user);

	Boolean deleteUser(Integer userId);

	Boolean updateUser(User user);

	User findUserById(Integer id);

	List<User> findAllUsers();
}
