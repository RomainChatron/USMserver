package vInterfaceDB;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vInterface._User;

public interface _UserGroupDB extends Remote {
	public ArrayList<Integer> getGroups(final String userName) throws RemoteException ;
	public void addUserGroup(final int idG, final String userName, final boolean admin) throws RemoteException ;
	public void removeUserGroup(final int idG, final String userName) throws RemoteException ;
	public ArrayList<_User> getAllUsersGroup(final int idG) throws RemoteException ;
}
