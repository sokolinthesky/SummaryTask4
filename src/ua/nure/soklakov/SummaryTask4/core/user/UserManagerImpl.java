package ua.nure.soklakov.SummaryTask4.core.user;

import java.util.List;

import ua.nure.soklakov.SummaryTask4.dao.impl.UserDaoImpl;

/**
 * UserDao implementation.
 * 
 * @author Oleg Soklakov
 *
 */
public class UserManagerImpl implements UserManager {

	UserDao userDao = new UserDaoImpl();

	@Override
	public List<User> getDoctors() {
		return userDao.getDoctors();
	}

	@Override
	public List<User> getDoctorsBySpecialization(int specializationId) {
		return userDao.getDoctorsBySpecialization(specializationId);
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public User getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

}
