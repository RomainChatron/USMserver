package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _UserDB extends Remote {
	public boolean connect(final String userName, final String passWord) throws RemoteException ;
}
