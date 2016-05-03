package dataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import kernel.Article;

// TODO: Auto-generated Javadoc
/**
 * The Class ArticleDB.
 */
public class ArticleDB {
	
	/**
	 * Adds the article.
	 *
	 * @param idA the id a
	 * @param idDi the id di
	 */
	public static void addArticle(final int idA, final int idDi) {
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
	
	public static ArrayList<Article> getArticles(final int idG) {
        try {
            ConnectionDB con = new ConnectionDB();
            ArrayList<Article> info = new ArrayList<Article>();
            Article a = null;
            String req = "SELECT idA, dateA, idDi FROM Article NATURAL JOIN Diary WHERE idG="+idG+"";
            Statement stmt = con.getConnection().createStatement();
            ResultSet rset = stmt.executeQuery(req);
            while(rset.next()) {
            	a = new Article(rset.getInt(1), rset.getString(2), rset.getInt(3));
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
	public static void removeArticle(final int idA) {
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
	
	public static int getMaxArticle() {
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
