package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _Article extends Remote {
	public String getDateA() throws RemoteException ;
	public void setDateA(String dateA) throws RemoteException ;
	public int getIdDi() throws RemoteException ;
	public void setIdDi(int articleDiary) throws RemoteException ;
	public int getIdA() throws RemoteException ;
	public void setIdA(int idA) throws RemoteException ;

}
