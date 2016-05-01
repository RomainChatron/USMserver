package dataBase;

import java.sql.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ConnectionDB.
 */
public class ConnectionDB {
	
	/** The connection. */
	private static Connection connection;
	
	/** The driver. */
	public static String driver = new String("com.mysql.jdbc.Driver");
	
	/** The host. */
	public static String host = new String("jdbc:mysql://localhost/usm");
	
	/** The user. */
	public static String user = new String("root");
	
	/** The pwd. */
	public static String pwd = new String("");
	
	/**
	 * Connection.
	 */
	public ConnectionDB() {		
		try {
			Class.forName(driver);
			setConnection(DriverManager.getConnection(host, user, pwd));	        
		} catch(ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Instantiates a new connection db.
	 *
	 * @param user the user
	 * @param pwd the pwd
	 */
	public ConnectionDB(final String user, final String pwd) {		
		try {
			Class.forName(driver);
			setConnection(DriverManager.getConnection(host, user, pwd));	        
		} catch(ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Instantiates a new connection db.
	 *
	 * @param host the host
	 * @param user the user
	 * @param pwd the pwd
	 */
	public ConnectionDB(final String host, final String user, final String pwd) {		
		try {
			Class.forName(driver);
			setConnection(DriverManager.getConnection(host, user, pwd));	        
		} catch(ClassNotFoundException | SQLException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		return connection;
	}

	/**
	 * Sets the connection.
	 *
	 * @param connection the new connection
	 */
	public void setConnection(Connection connection) {
		ConnectionDB.connection = connection;
	}
	
	public void closeDB() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addColumnDB(final String nameT, final String typeC, final String nameC) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "ALTER TABLE ? ? ADD ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, nameT);
			st.setString(2, typeC);
			st.setString(3, nameC);
			st.executeQuery();
			System.out.println("");
			st.close();
			con.closeDB();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
}