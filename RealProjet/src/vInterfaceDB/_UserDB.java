package vInterfaceDB;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;

import packageServer.User;
import vInterface._User;


public interface _UserDB extends Remote {
	public boolean connect(final String userName, final String passWord) throws RemoteException ;
	public _User getUsers (final String userName) throws RemoteException ;
	public ArrayList<_User> allUser () throws RemoteException ;
	public void addUser(final String userName, final String passWord, final String firstName, final String lastName, final String email, final String job) throws RemoteException ;
	public void addUser(final String userName, final String passWord, final String firstName, final String lastName, final String email) throws RemoteException ;
	public void updateUser(final String userName, final String email, final String job) throws RemoteException;
	public void updateUserEmail(final String userName, final String email) throws RemoteException;
	public void updateUserJob(final String userName, final String job) throws RemoteException;
	public void removeUser(final String userName) throws RemoteException;
	public void removeUser(final String firstName, final String lastName) throws RemoteException;

}
