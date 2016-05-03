package vInterfaceDB;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import vInterface._Article;

public interface _ArticleDB extends Remote {
	public void addArticle(final int idA, final int idDi) throws RemoteException ;
	public ArrayList<_Article> getArticles(final int idG) throws RemoteException ;
	public void removeArticle(final int idA) throws RemoteException ;
	public int getMaxArticle() throws RemoteException ;

}
