package packageServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import packageServer.User;
import vInterface._ObjectBuilder;
import dataBase.UserDB;

public class ObjectBuilder extends UnicastRemoteObject implements _ObjectBuilder {

	protected ObjectBuilder() throws RemoteException {
		super();
	}

	@Override
	public User createUser() throws RemoteException {
		return new User();
	}
	
	public User createUser(final String firstName, final String lastName, final String email, final String job) throws RemoteException {
		return new User(firstName, lastName, email,job);
	}

	@Override
	public UserDB UserDB() throws RemoteException {
		return new UserDB();
	}
	

}
