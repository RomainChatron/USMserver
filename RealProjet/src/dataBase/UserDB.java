package dataBase;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import packageServer.SendEmail;
import packageServer.User;
import vInterface._User;
import vInterfaceDB._UserDB;

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
	
	public User getUsers (String userName) {
		HashMap<String, String> map = new HashMap<String, String>() ;
        try {
            ConnectionDB con = new ConnectionDB();
            Class<? extends _User> info = null;
            String req = "SELECT firstName, lastName, email, job FROM user WHERE userName='"+userName+"' LIMIT 1";
            Statement stmt = con.getConnection().createStatement();
            //stmt.setString(1, userName);
            ResultSet rset = stmt.executeQuery(req);
            ResultSetMetaData rsetMeta = rset.getMetaData();
            User cls = new User();
            if(rset.next()) {
            	
					cls.setUserName(userName);
					cls.setFirstName(rset.getString(1));
					cls.setLastName(rset.getString(2));
					cls.setEmail(rset.getString(3));
					cls.setJob(rset.getString(4));
					
            	
            	/*for(int i = 1 ; i < rsetMeta.getColumnCount()+1 ; i++) {
            		map.put(rsetMeta.getColumnName(i), rset.getString(i));
            	}*/
               //cls = (Class<? extends _User>) Class.forName(rset.getString(5));
               //cls.getConstructor(String.class, String.class, String.class, String.class)
               // 	.newInstance(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(4));
                //info = cls;
            }
            return cls;
        } catch(SQLException | IllegalArgumentException | SecurityException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }
	
	
	/**
	 * All users saved in the dataBase
	 *
	 * @return a list composed of all the users
	 */
	public  ArrayList<_User> allUser() throws RemoteException {
		ArrayList<_User> u = new ArrayList<_User>();
		try {
			ConnectionDB con = new ConnectionDB();
	        String req = "SELECT userName from user";
	        Statement stmt = con.getConnection().createStatement();
	        ResultSet rset = stmt.executeQuery(req);
			
			while(rset.next()) {
				u.add(getUsers(rset.getString(1)));
			}
			rset.close();
			stmt.close();
			con.closeDB();
		} catch(SQLException e) {
			e.getStackTrace();
			throw new RuntimeException(e);
		}
		
		return u;
	}

	
	/**
	 * Adds the user.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param email the email
	 * @param job the job
	 */
	public void addUser(final String userName, final String passWord, final String firstName, final String lastName, final String email, final String job) {
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
	public void addUser(final String userName, final String passWord, final String firstName, final String lastName, final String email) {
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
	public void updateUser(final String userName, final String email, final String job) {
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
	public void updateUserEmail(final String userName, final String email) {
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
	public void updateUserJob(final String userName, final String job) {
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
	public void removeUser(final String userName) {
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
	public void removeUser(final String firstName, final String lastName) {
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
