package packageServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import vInterface._Article;


@SuppressWarnings("serial")
public class Article extends UnicastRemoteObject implements _Article {
	
	private int idA;
	private String dateA;
	private int idDi;
	
	public Article() throws RemoteException{
		// int idA = DiaryDB.getMaxDiary() + 1;
		setIdA(idA);
		setDateA("");
	}
	
	public Article(int idA, String date, int idDi) throws RemoteException {
		setIdA(idA);
		setDateA(date);
		setIdDi(idDi);
	}

	public String getDateA() throws RemoteException{
		return dateA;
	}

	public void setDateA(String dateA) throws RemoteException{
		this.dateA = dateA;
	}

	public int getIdDi() throws RemoteException{
		return idDi;
	}

	public void setIdDi(int articleDiary) throws RemoteException{
		this.idDi = articleDiary;
	}

	public int getIdA() throws RemoteException{
		return idA;
	}

	public void setIdA(int idA) throws RemoteException{
		this.idA = idA;
	}
}
