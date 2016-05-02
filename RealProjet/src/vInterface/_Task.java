package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _Task extends Remote {
	
	//public void addSubTask(SubTask ST) throws RemoteException ;
	//public void deleteSubTask(SubTask ST) throws RemoteException ;
	
	/* Getters */
	public String getDesc() throws RemoteException ;
	public String getName() throws RemoteException ; 
	public String getDate() throws RemoteException ;
	public String getDeadLine() throws RemoteException ;
	public boolean isDone() throws RemoteException ;
	public int getIdG() throws RemoteException ;
	public int getIdT() throws RemoteException ;
	
	public void setIdT(int idT) throws RemoteException ;
	public void setDesc(String desc1) throws RemoteException ;
	public void setName(String name1) throws RemoteException ;
	public void setDate(String date1) throws RemoteException ;
	public void setDeadLine(String deadLine1) throws RemoteException ;
	public void setDone(boolean isDone1) throws RemoteException ;
	public void setIdG(int idG) throws RemoteException ;
	

}
