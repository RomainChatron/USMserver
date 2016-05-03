package vInterfaceDB;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface _DataArticleDB extends Remote {
	public void addDataArticle(final int idA, final int idDa) throws RemoteException ;
	public  ArrayList<Integer> getDatas(final int idA) throws RemoteException ; 
	public  ArrayList<String> getDatasName(final int idA) throws RemoteException ; 
	public void removeDataArticle(final int idA, final int idDa) throws RemoteException ; 
}
