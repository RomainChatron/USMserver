package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _User extends Remote {

	public String getUserName() throws RemoteException;
	public String getPassWord() throws RemoteException;
	public String getFirstName() throws RemoteException;
	public String getLastName() throws RemoteException;
	public String getEmail() throws RemoteException;
	public String getJob() throws RemoteException;
	public void setUserName(String username) throws RemoteException;
	public void setPassWord(String pwd) throws RemoteException;
	public void setFirstName(String firstname) throws RemoteException;
	public void setLastName(String lastname) throws RemoteException;
	public void setEmail(String email) throws RemoteException;
	public void setJob(String job) throws RemoteException;
	
	
	//public String toString();
	
	
	public String test() throws RemoteException; 
}
