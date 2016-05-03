package vInterfaceDB;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _DataDB extends Remote {
	public void addData(final String filePath) throws RemoteException ;
	public void addDataTxt(final String txt) throws RemoteException ;
	public String getDataTxt(final int idDa) throws RemoteException ;
	public void saveData(final int idDa, final String filePath) throws RemoteException ;
	public Boolean isDataTxt(final int idDa) throws RemoteException ;
	public void removeData(final int idDa) throws RemoteException ;

}
