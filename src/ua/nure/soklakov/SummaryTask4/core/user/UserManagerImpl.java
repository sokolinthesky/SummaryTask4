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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getDoctorsBySpecialization(int specializationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByLogin(String login) {
		return userDao.getUserByLogin(login);
	}

	

}
