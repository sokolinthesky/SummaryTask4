package ua.nure.soklakov.SummaryTask4.core.user;

import java.util.List;

import ua.nure.soklakov.SummaryTask4.LoginDublicateException;
import ua.nure.soklakov.SummaryTask4.dao.impl.UserDaoImpl;

/**
 * UserDao implementation. Here core layer call dao methods.
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
	public void addUser(User user) throws LoginDublicateException {
		userDao.addUser(user);
	}

	@Override
	public User getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

	@Override
	public List<Role> getRoles() {
		return userDao.getRoles();
	}

	@Override
	public List<Specialization> getSpecializations() {
		return userDao.getSpecializations();
	}

	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}

}
