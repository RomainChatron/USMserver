package packageServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataBase.GroupDB;
import vInterface._Chat;
import vInterface._Group;
import vInterface._User;

public class Group extends UnicastRemoteObject implements _Group {

	private int idG;
	private String name; 
	private String description; 
	private ArrayList<_User> members;
	private ArrayList<_User> admins;
	private Chat chat;
	//private Diary diary;
	
	
	protected Group() throws RemoteException {
		super();
		members = new ArrayList<_User>();
		admins = new ArrayList<_User>();
	}
	
	/**
	 * Create group with name, desc
	 * @param name : a string which represents the name of the group
	 * @param desc : a string which represents the description of the group
	 */
	public Group(String name, String desc) throws RemoteException{
		super();
		this.setAdmins(new ArrayList<_User>());
		this.setMembers(new ArrayList<_User>());
		this.setName(name);
		this.setDescription(desc);
		
	}
	
	/**
	 * Create group with id, name, desc
	 * @param name : a string which represents the name of the group
	 * @param desc : a string which represents the description of the group
	 */
	public Group(int id, String name, String desc) throws RemoteException{
		super();
		this.setAdmins(new ArrayList<_User>());
		this.setMembers(new ArrayList<_User>());
		this.setName(name);
		this.setDescription(desc);
		this.setIdG(id);
	}
	
	@Override
	public int getIdG() throws RemoteException {
		return idG;
	}
	
	@Override
	public String getName() throws RemoteException {
		return name;
	}
	
	@Override
	public String getDescription() throws RemoteException {
		return description;
	}
	
	@Override
	public ArrayList<_User> getListMember() throws RemoteException {
		return members;
	}
	
	@Override
	public ArrayList<_User> getListAdmin() throws RemoteException {
		return admins;
	}

	@Override
	public void setIdG(int idG) throws RemoteException {
		this.idG = idG;
	}

	@Override
	public void setName(String name) throws RemoteException {
		this.name = name ;
	}

	@Override
	public void setDescription(String description) throws RemoteException {
		this.description = description ;		
	}

	@Override
	public void setMembers(ArrayList<_User> listMembers) throws RemoteException {
		members = listMembers ;
	}

	@Override
	public void setAdmins(ArrayList<_User> listAdmins) throws RemoteException {
		admins = listAdmins ;
	}

	@Override
	public boolean addMember(_User user) throws RemoteException {
		return members.add(user);
	}

	@Override
	public boolean removeMember(_User user) throws RemoteException {
		return members.remove(user);
	}

	@Override
	public boolean addAdmin(_User admin) throws RemoteException {
		this.removeMember(admin);
		return admins.add(admin);
	}

	@Override
	public boolean removeAdmin(_User admin) throws RemoteException {
		return admins.remove(admin);
	}

	@Override
	public _Chat getChat() throws RemoteException {
		return chat;
	}

}
