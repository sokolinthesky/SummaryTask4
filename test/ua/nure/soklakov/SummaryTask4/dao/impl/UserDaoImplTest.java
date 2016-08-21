package ua.nure.soklakov.SummaryTask4.dao.impl;

import org.junit.*;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

import ua.nure.soklakov.SummaryTask4.LoginDuplicateException;
import ua.nure.soklakov.SummaryTask4.core.user.User;
import ua.nure.soklakov.SummaryTask4.core.user.UserDao;
import ua.nure.soklakov.SummaryTask4.dao.ConnectionPool;

public class UserDaoImplTest {
	private static UserDao userDao = null;
	
	@BeforeClass
	public static void beforeClass() {
		try {
			userDao = new UserDaoImpl();
			Class.forName("com.mysql.jdbc.Driver");
			MysqlConnectionPoolDataSource dataSource = new MysqlConnectionPoolDataSource();
			dataSource.setURL("jdbc:mysql://localhost:3306/hospitaldb?useEncoding=true&amp;characterEncoding=UTF-8");
			dataSource.setUser("root");
			dataSource.setPassword("root");
			new ConnectionPool(dataSource);
		} catch (ClassNotFoundException e) {
			System.out.println("Cannot get DataSource without JNDI");
		}
	}
	
	@Test
	public void testListDoctors() {
		Assert.assertNotNull(userDao.getDoctors());
	}
	
	@Test
	public void testListDoctorsBySpecialization() {
		Assert.assertNotNull(userDao.getDoctorsBySpecialization(1));
	}
	
	@Test
	public void testListRoles() {
		Assert.assertNotNull(userDao.getRoles());
	}
	
	@Test
	public void testListSpecializations() {
		Assert.assertNotNull(userDao.getSpecializations());
	}
	
	@Test
	public void testAddUser() throws LoginDuplicateException{
		User testUser = new User("testlogin", "testpassword", "testfirstname", "testlastname", 2, 0, 0);
		userDao.addUser(testUser);
	}
	
	@Test
	public void testByLogin() {
		Assert.assertNotNull(userDao.getUserByLogin("admin"));
	}
	
	@Test
	public void testById() {
		Assert.assertNotNull(userDao.getUserById(1));
	}
}
