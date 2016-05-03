package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _ChatServer extends Remote {
	public void register(String nomChat, _ChatC client) throws RemoteException ;
	public void unregister(String nomChat, _ChatC client) throws RemoteException ;
	public void postMessage(String nomChat, String message) throws RemoteException ;
	public void deleteChat(String nomChat) throws RemoteException ;
	
}
