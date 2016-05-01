package vInterface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface _Diary extends Remote {
	
	// GETTERS AND SETTERS 

	//public ArrayList<_Article> getArticles() throws RemoteException ;	
	public String getName() throws RemoteException ;	
	public _User getDiaryPerso() throws RemoteException ;
	public _Group getDiaryGroup() throws RemoteException ;
	public int getIdDi() throws RemoteException ;
	
	//public void setArticles(ArrayList<_Article> articles) throws RemoteException ;
	public void setName(String name)  throws RemoteException ;
	public void setDiaryPerso(_User diaryPerso) throws RemoteException ;
	public void setDiaryGroup(_Group diaryGroup) throws RemoteException ;
	public void setIdDi(int idDi) throws RemoteException ;
	
}
