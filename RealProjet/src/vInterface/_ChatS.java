package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _ChatS extends Remote {
	public void register(_ChatC client) throws RemoteException ;
	public void unregister(_ChatC client) throws RemoteException ;
	public void postMessage(String message) throws RemoteException ;
}
