package dataBase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import packageServer.Article;
import vInterface._Article;
import vInterfaceDB._ArticleDB;
import vInterfaceDB._DataArticleDB;


// TODO: Auto-generated Javadoc
/**
 * The Class ArticleDB.
 */
@SuppressWarnings("serial")
public class ArticleDB extends UnicastRemoteObject implements _ArticleDB{
	
	public ArticleDB() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Adds the article.
	 *
	 * @param idA the id a
	 * @param idDi the id di
	 */
	public void addArticle(final int idA, final int idDi) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "INSERT INTO Article (idA, idDi) VALUES (?,?)";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idA);
			st.setInt(2, idDi);
			st.executeUpdate();
			System.out.println("Article: "+idA+" has been added in Diary: "+idDi+"");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<_Article> getArticles(final int idG) {
        try {
            ConnectionDB con = new ConnectionDB();
            ArrayList<_Article> info = new ArrayList<>();
            Article a = null;
            String req = "SELECT idA, dateA, idDi FROM Article NATURAL JOIN Diary WHERE idG="+idG+"";
            Statement stmt = con.getConnection().createStatement();
            ResultSet rset = stmt.executeQuery(req);
            while(rset.next()) {
            	try {
					a = new Article(rset.getInt(1), rset.getString(2), rset.getInt(3));
				} catch (RemoteException e) {
					e.printStackTrace();
				}
                info.add(a);
            }
            return info;
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * Removes the article.
	 *
	 * @param idA the id a
	 */
	public void removeArticle(final int idA) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "DELETE FROM Article WHERE idA=?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idA);
			st.executeUpdate();
			System.out.println("Article: "+idA+" has been deleted");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int getMaxArticle() {
		try {
			int maxIdA = 0;
			ConnectionDB con = new ConnectionDB();
			Statement stmt = con.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery("SELECT max(idA) FROM Article");
			if(rset.next()){
				maxIdA = rset.getInt(1);
			}
			stmt.close();
			con.closeDB();
			return maxIdA;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
