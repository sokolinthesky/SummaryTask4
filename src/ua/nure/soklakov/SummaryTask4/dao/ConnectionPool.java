package ua.nure.soklakov.SummaryTask4.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

/**
 * The class provides connection pool.
 * 
 * @author Oleg Soklakov
 *
 */
public class ConnectionPool {
	private static DataSource dataSource;

	/**
	 * Data source without JNDI.
	 * 
	 * @param dataSource
	 *            specified data source.
	 */
	public ConnectionPool(DataSource dataSource) {
		ConnectionPool.dataSource = dataSource;
	}

	private final static Logger LOG = Logger.getLogger(ConnectionPool.class);

	/**
	 * Get free connection from pool.
	 * 
	 * @return connection.
	 */
	public static synchronized Connection getConnection() {
		if (dataSource == null) {
			try {
				Context initContext = new InitialContext();
				Context envContext = (Context) initContext.lookup("java:/comp/env");
				dataSource = (DataSource) envContext.lookup("jdbc/hospitaldb");
			} catch (NamingException e) {
				LOG.error("Cannot find the data source");
			}
		}

		try {
			return dataSource.getConnection();
		} catch (SQLException e) {
			LOG.error("Cannot establish connection");
			return null;
		}
	}

}
