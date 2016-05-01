package packageServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import packageServer.User;
import vInterface._ObjectBuilder;
import vInterface._UserDB;
import dataBase.UserDB;

public class ObjectBuilder extends UnicastRemoteObject implements _ObjectBuilder {

	protected ObjectBuilder() throws RemoteException {
		super();
	}

	@Override
	public User createUser() throws RemoteException {
		return new User();
	}

	@Override
	public UserDB UserDB() throws RemoteException {
		return new UserDB();
	}
	

}
