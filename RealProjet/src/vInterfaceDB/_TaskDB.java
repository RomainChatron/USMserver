package vInterfaceDB;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import packageServer.TypeTask;
import vInterface._Task;

public interface _TaskDB extends Remote {
	public void addTask(final String nameT, final String descT, final String deadLine, final int idG, final String userName, final TypeTask tt) throws RemoteException;
	public ArrayList<_Task> getTasks(final String userName) throws RemoteException ;
	public void updateTask(final int idT, final String nameT, final String descT, final String deadLine, final int idG, final String userName, final TypeTask typeT) throws RemoteException ;
	public void updateTaskName(final int idT, final String nameT) throws RemoteException ;
	public void updateTaskDesc(final int idT, final String descT) throws RemoteException ;
	public void updateTaskDeadLine(final int idT, final String deadLine) throws RemoteException ;
	public void updateTaskType(final int idT, final int typeT) throws RemoteException ;
	public void removeTask(final int idT) throws RemoteException ;
	public int getMaxTask() throws RemoteException ;

}
