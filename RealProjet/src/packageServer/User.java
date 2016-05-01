package packageServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import vInterface._User;

public class User extends UnicastRemoteObject implements _User {
	
	private String userName;
	private String passWord;
	private String firstName;
	private String lastName;
	private String email;
	private String job;

	protected User() throws RemoteException {
		super();
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
