package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;

import packageServer.TypeTask;

public interface _TypeTask extends Remote {
	public int getRank() throws RemoteException ;
	public String getGrade() throws RemoteException ;
	public void setGrade(String grade) throws RemoteException ;
	public static TypeTask valueOf(int i) throws RemoteException {
		TypeTask tt = null;
		switch(i){
		case 1 : 
			tt = TypeTask.Low;
			break;
		case 2 : 
			tt = TypeTask.Normal;
			break;
		case 3 : 
			tt = TypeTask.High;
			break;
		case 4 : 
			tt = TypeTask.Urgent;
			break;	
		}
		return tt;
	}

}
