package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;


public interface _Group extends Remote {
	
	/* 
	 * Getters
	 */
	public int getIdG() throws RemoteException;
	public String getName()  throws RemoteException;
	public String getDescription() throws RemoteException;
	public ArrayList<_User> getListMember() throws RemoteException;
	//public _User getMember(par nom ?) throws RemoteException;
	public ArrayList<_User> getListAdmin() throws RemoteException;
	//public _User getAdmin(par nom ?) throws RemoteException;
	public _Chat getChat() throws RemoteException;
	//public _Diary getDiary() throws RemoteException;
	
	/*
	 * Setters
	 */
	public void setIdG(int idG) throws RemoteException;
	public void setName(String name) throws RemoteException;
	public void setDescription(String description) throws RemoteException;
	public void setMembers(ArrayList<_User> listMembers) throws RemoteException;
	public void setAdmins(ArrayList<_User> listAdmins) throws RemoteException;
	//public void setChat(_Chat chat) throws RemoteException;
	//public void setDiary(_Diary diary) throws RemoteException;
	
	/*
	 * Ajout & Suppression d'éléments au groupe
	 */
	public boolean addMember(_User user) throws RemoteException;
	public boolean removeMember(_User user) throws RemoteException;
	public boolean addAdmin(_User admin) throws RemoteException;
	public boolean removeAdmin(_User admin) throws RemoteException;
	//public void addChat() throws RemoteException;
	//public void addDiary() throws RemoteException;
	//public void removeChat() throws RemoteException;
	//public void removeDiary() throws RemoteException;
	
}
