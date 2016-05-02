package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import packageServer.User;
import vInterfaceDB.*;

public interface _ObjectBuilder extends Remote {

	public _User createUser() throws RemoteException ;
	public _User createUser(final String firstName, final String lastName, final String email, final String job) throws RemoteException;
	
	/* Pas encore impl�ment� 
	public _Article createArticle() throws RemoteException ;
	public _Chat createChat() throws RemoteException ;
	public _Diary createDiary() throws RemoteException ;
	public _Group createGroup() throws RemoteException ;
	public _Message createMessage() throws RemoteException ;
	public _Task createTask() throws RemoteException ; */
	
	public _UserDB UserDB() throws RemoteException ;

}
