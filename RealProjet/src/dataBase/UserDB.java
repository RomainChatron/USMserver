package dataBase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import packageServer.SendEmail;
import vInterface._UserDB;

// TODO: Auto-generated Javadoc
/**
 * The Class UserDB.
 */
public class UserDB extends UnicastRemoteObject implements _UserDB {
	
	public UserDB() throws RemoteException {
		super();
	}

	/**
	 * Connect.
	 *
	 * @param userName the user name
	 * @param passWord the pass word
	 * @return true, if successful
	 */
	public boolean connect(final String userName, final String passWord) throws RemoteException {
		try {
			ConnectionDB con = new ConnectionDB();
			ArrayList<String> usernamePassword = new ArrayList<String>();
			Statement stmt = con.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery("SELECT username, password FROM User");
			while(rset.next()){
				usernamePassword.add(rset.getString(1)+rset.getString(2)); 
			}
			for(String s : usernamePassword){
				if(s.equals(userName+passWord)) return true;
			}
			return false;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}	
	
	/**
	 * Adds the user.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param email the email
	 * @param job the job
	 */
	public static void addUser(final String userName, final String passWord, final String firstName, final String lastName, final String email, final String job) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "INSERT INTO User VALUES (?,?,?,?,?,?)";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, userName);
			st.setString(2, passWord);
			st.setString(3, firstName);
			st.setString(4, lastName);
			st.setString(5, email);
			st.setString(6, job);
			st.executeUpdate();
			SendEmail.userAddMail(email, userName, passWord, firstName, lastName);
			System.out.println("User: "+userName+" added in the database");
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Adds the user.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param email the email
	 */
	public static void addUser(final String userName, final String passWord, final String firstName, final String lastName, final String email) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "INSERT INTO User (userName, password, firstName, lastName, email) VALUES (?,?,?,?,?)";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, userName);
			st.setString(2, passWord);
			st.setString(3, firstName);
			st.setString(4, lastName);
			st.setString(5, email);
			st.executeUpdate();
			SendEmail.userAddMail(email, userName, passWord, firstName, lastName);
			System.out.println("User: "+userName+" has been added in the database");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Update user.
	 *
	 * @param userName the user name
	 * @param email the email
	 * @param job the job
	 */
	public static void updateUser(final String userName, final String email, final String job) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "UPDATE User SET email = ?, job = ? WHERE userName = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, email);
			st.setString(2, job);
			st.setString(3, userName);
			st.executeUpdate();
			System.out.println("User: "+userName+"\nHis email: "+email+" and his job: "+job+" has been updated in the database");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Update user email.
	 *
	 * @param userName the user name
	 * @param email the email
	 */
	public static void updateUserEmail(final String userName, final String email) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "UPDATE User SET email = ? WHERE userName = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, email);
			st.setString(2, userName);
			st.executeUpdate();
			System.out.println("User: "+userName+"\nHis email: "+email+" has been updated in the database");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Update user job.
	 *
	 * @param userName the user name
	 * @param job the job
	 */
	public static void updateUserJob(final String userName, final String job) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "UPDATE User SET job = ? WHERE userName = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, job);
			st.setString(2, userName);
			st.executeUpdate();
			System.out.println("User: "+userName+"\nHis job: "+job+" has been updated in the database");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Removes the user.
	 *
	 * @param userName the user name
	 */
	public static void removeUser(final String userName) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "DELETE FROM User WHERE userName = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, userName);
			st.executeUpdate();
			System.out.println("User: "+userName+" has been deleted from the database");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Removes the user.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 */
	public static void removeUser(final String firstName, final String lastName) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "DELETE FROM User WHERE firstName = ? AND lastName = ? LIMIT 1";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, firstName);
			st.setString(2, lastName);
			st.executeUpdate();
			System.out.println("User: "+firstName+" "+lastName+" has been deleted from the database");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
