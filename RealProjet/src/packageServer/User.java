package packageServer;

import java.sql.Statement;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.ArrayList;

import dataBase.ConnectionDB;
import vInterface._User;

public class User extends UnicastRemoteObject implements _User {
	
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String email;
	private String job;

	public User() throws RemoteException {
		super();
	}
	
	protected User(final String firstName, final String lastName, final String email, final String job) throws RemoteException  {
		String username = userName(firstName, lastName);
		String password = password();
		setUserName(username);
		setPassWord(password);
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setJob(job);
	}
	
	/**
	 * Unique user name.
	 *
	 * @param userName the user name
	 * @param i the i
	 * @param stmt the stmt
	 * @return the string
	 */
	public  String uniqueUserName(String userName, char i) {
		String userNameInit = userName;
		try {
			ConnectionDB con = new ConnectionDB();
			Statement stmt = con.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery("SELECT userName FROM User");
			while(rset.next()) {
				if(rset.getString(1).equals(userName)){
					userName = userNameInit + i;
					i++;
				}
			}
			rset.close();
			stmt.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		
		return userName;
	}
	
	/**
	 * User name.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param stmt the stmt
	 * @return the string
	 */
	public  String userName(final String firstName, final String lastName) throws RemoteException  {
		String userName = "";
		if(lastName.length()>6) {
			userName = lastName.substring(0,7)+firstName.substring(0,1);
		} else if(firstName.length()>8-lastName.length()) {
			userName = lastName+firstName.substring(0,8-lastName.length());
		} else userName = lastName+firstName;
		userName = userName.toLowerCase();
		return uniqueUserName(userName, '1');
	}

	
	/**
	 * Password.
	 *
	 * @return the string
	 */
	public  String password() throws RemoteException  {
		return UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
	}

	@Override
	public String getUserName() throws RemoteException {
		return userName;
	}

	@Override
	public String getPassWord() throws RemoteException {
		return passWord;
	}

	@Override
	public String getFirstName() throws RemoteException {
		return firstName;
	}

	@Override
	public String getLastName() throws RemoteException {
		return lastName;
	}

	@Override
	public String getEmail() throws RemoteException {
		return email;
	}

	@Override
	public String getJob() throws RemoteException {
		return job;
	}

	@Override
	public void setUserName(String username) throws RemoteException {
		this.userName = username ;
	}

	@Override
	public void setPassWord(String pwd) throws RemoteException {
		this.passWord = pwd ;		
	}

	@Override
	public void setFirstName(String firstname) throws RemoteException {
		this.firstName = firstname ;
	}

	@Override
	public void setLastName(String lastname) throws RemoteException {
		this.lastName = lastname ;
	}

	@Override
	public void setEmail(String email) throws RemoteException {
		this.email = email ;
	}

	@Override
	public void setJob(String job) throws RemoteException {
		this.job = job ;
	}
	
	@Override
	public String test() throws RemoteException {
		return "testation";
	}
	
}
