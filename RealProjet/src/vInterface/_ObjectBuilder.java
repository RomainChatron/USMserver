package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _ObjectBuilder extends Remote {

	public _User createUser() throws RemoteException ;
	public _UserDB UserDB() throws RemoteException ;
	/* Pas encore impl�ment� 
	public _Article createArticle() throws RemoteException ;
	public _Chat createChat() throws RemoteException ;
	public _Diary createDiary() throws RemoteException ;
	public _Group createGroup() throws RemoteException ;
	public _Message createMessage() throws RemoteException ;
	public _Task createTask() throws RemoteException ; */
}
