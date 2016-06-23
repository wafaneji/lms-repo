package services.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entities.User;
import services.interfaces.UserServicesLocal;
import services.interfaces.UserServicesRemote;

/**
 * Session Bean implementation class UserServices
 */
@Stateless
public class UserServices implements UserServicesRemote, UserServicesLocal {

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public UserServices() {
	}

	@Override
	public Boolean addUser(User user) {
		Boolean b = false;
		try {
			entityManager.persist(user);
			b = true;
		} catch (Exception e) {
			System.err.println("insertion problem");
		}

		return b;
	}

	@Override
	public Boolean deleteUser(Integer userId) {
		Boolean b = false;
		try {
			entityManager.remove(findUserById(userId));
			b = true;
		} catch (Exception e) {
			System.err.println("deleting problem");
		}

		return b;
	}

	@Override
	public Boolean updateUser(User user) {
		Boolean b = false;
		try {
			entityManager.merge(user);
			b = true;
		} catch (Exception e) {
			System.err.println("updating problem");
		}

		return b;
	}

	@Override
	public User findUserById(Integer id) {
		return entityManager.find(User.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> findAllUsers() {
		String jpqjQuery = "SELECT u FROM User u";
		Query query = entityManager.createQuery(jpqjQuery, User.class);
		return query.getResultList();
	}

}
