package ua.nure.soklakov.SummaryTask4.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import ua.nure.soklakov.SummaryTask4.core.user.User;
import ua.nure.soklakov.SummaryTask4.core.user.UserDao;
import ua.nure.soklakov.SummaryTask4.dao.ConnectionPool;
import ua.nure.soklakov.SummaryTask4.dao.Query;

/**
 * An Implementation of UserDao interface.
 * 
 * @author Oleg Soklakov
 *
 */
public class UserDaoImpl implements UserDao {

	private final static Logger LOG = Logger.getLogger(UserDaoImpl.class);

	private Connection connection;

	@Override
	public List<User> getDoctors() {
		List<User> users = new ArrayList<>();
		connection = ConnectionPool.getConnection();
		try (Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(Query.SELECT_ALL_DOCTORS)) {
			while (resultSet.next()) {

				users.add(new User(resultSet.getInt("id"), resultSet.getString("login"),
						resultSet.getString("password"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getInt("role_id"),
						resultSet.getInt("specialization_id"), resultSet.getInt("count_of_patients")));
			}

		} catch (SQLException ex) {
			LOG.error("Can not find a doctors", ex);
		} finally {
			closeConnection();
		}

		return users;
	}

	@Override
	public List<User> getDoctorsBySpecialization(int specializationId) {
		List<User> users = new ArrayList<>();
		connection = ConnectionPool.getConnection();
		try (final PreparedStatement prStatement = this.connection.prepareStatement(Query.SELECT_DOCTORS_BY_SPEC)) {
			prStatement.setInt(1, specializationId);
			ResultSet resultSet = prStatement.executeQuery();
			while (resultSet.next()) {
				users.add(new User(resultSet.getInt("id"), resultSet.getString("login"),
						resultSet.getString("password"), resultSet.getString("first_name"),
						resultSet.getString("last_name"), resultSet.getInt("role_id"),
						resultSet.getInt("specialization_id"), resultSet.getInt("count_of_patients")));
			}
			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return users;
	}

	@Override
	public void addUser(User user) {
		connection = ConnectionPool.getConnection();
		try (PreparedStatement pStatement = connection.prepareStatement(Query.INSERT_USER)) {
			pStatement.setString(1, user.getLogin());
			pStatement.setString(2, user.getPassword());
			pStatement.setString(3, user.getFirstName());
			pStatement.setString(4, user.getLastName());
			pStatement.setInt(5, user.getRoleId());
			pStatement.setInt(5, user.getSpecializationId());
			pStatement.setInt(5, user.getCountOfPatients());

			pStatement.executeUpdate();
		} catch (SQLException ex) {
			LOG.error("Can not create a new user", ex);
		} finally {
			closeConnection();
		}
	}

	@Override
	public User getUserByLogin(String login) {
		User user = null;
		connection = ConnectionPool.getConnection();
		try (PreparedStatement ps = connection.prepareStatement(Query.SELECT_USER_BY_LOGIN)) {
			ps.setString(1, login);
			ps.execute();

			ResultSet rs = ps.getResultSet();
			if (rs.next()) {
				user = new User(rs.getInt("id"), rs.getString("login"), rs.getString("password"),
						rs.getString("first_name"), rs.getString("last_name"), rs.getInt("role_id"),
						rs.getInt("specialization_id"), rs.getInt("count_of_patients"));
			}
			rs.close();
		} catch (SQLException ex) {
			LOG.error("Can not find user by login", ex);
		} finally {
			closeConnection();
		}

		return user;
	}

	/**
	 * The method closes connection.
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
