package ua.nure.soklakov.SummaryTask4.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ua.nure.soklakov.SummaryTask4.core.user.User;
import ua.nure.soklakov.SummaryTask4.core.user.UserDao;
import ua.nure.soklakov.SummaryTask4.dao.ConnectionPool;
import ua.nure.soklakov.SummaryTask4.dao.Query;

public class UserDaoImpl implements UserDao {
	private Connection connection;
	
	@Override
	public List<User> getDoctors() {
		List<User> users = new ArrayList<>();
		connection = ConnectionPool.getConnection();
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(Query.SELECT_ALL_DOCTORS)) {
			while (resultSet.next()) {

				//users.add(resultSet.getInt(columnIndex));
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			closeConnection();
		}
		
		return users;
	}

	@Override
	public List<User> getPediatricianDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getTraumatologistDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getSurgeonDoctors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByLogin(String login) {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Method closes connection.
	 */
	private void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
