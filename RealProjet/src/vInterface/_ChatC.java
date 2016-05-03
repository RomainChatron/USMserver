package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _ChatC extends Remote {
	public void postMessage(String message) throws RemoteException ;
}
