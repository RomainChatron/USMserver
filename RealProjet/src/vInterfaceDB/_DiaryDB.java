package vInterfaceDB;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface _DiaryDB extends Remote {
	public void addDiary(final String nameDi, final int idG) throws RemoteException ;
	public void updateDiary(final int idDi, final String nameDi, final int idG) throws RemoteException ;
	public void updateDiary(final int idDi, final String nameDi) throws RemoteException ;
	public void removeDiary(final int idDi) throws RemoteException ;
	public int getMaxDiary() throws RemoteException ;

}
