package packageServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import vInterface._Diary;
import vInterface._Group;
import vInterface._User;

public class Diary extends UnicastRemoteObject implements _Diary {

	private int idDi;
	private String name;
	//private ArrayList<Article> articles;
	private _User diaryPerso;
	private _Group diaryGroup;
	
	
	protected Diary() throws RemoteException {
		super();
	}
	
	@Override
	public String getName() throws RemoteException {
		return name;
	}

	@Override
	public _User getDiaryPerso() throws RemoteException {
		return diaryPerso;
	}

	@Override
	public _Group getDiaryGroup() throws RemoteException {
		return diaryGroup;
	}

	@Override
	public int getIdDi() throws RemoteException {
		return idDi;
	}

	@Override
	public void setName(String name) throws RemoteException {
		this.name = name ;
	}

	@Override
	public void setDiaryPerso(_User diaryPerso) throws RemoteException {
		this.diaryPerso = diaryPerso ;
	}

	@Override
	public void setDiaryGroup(_Group diaryGroup) throws RemoteException {
		this.diaryGroup = diaryGroup ;
	}

	@Override
	public void setIdDi(int idDi) throws RemoteException {
		this.idDi = idDi ;
	}

}
