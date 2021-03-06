package dataBase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import vInterfaceDB._DataArticleDB;

@SuppressWarnings("serial")
public class DataArticleDB extends UnicastRemoteObject implements _DataArticleDB {
	
	public DataArticleDB() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addDataArticle(final int idA, final int idDa){
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "INSERT INTO DataArticle (idA, idDa) VALUES (?,?)";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idA);
			st.setInt(2, idDa);
			st.executeUpdate();
			System.out.println("Data: "+idDa+" has been added in Article:"+idA+"");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Integer> getDatas(final int idA) {
        try {
            ConnectionDB con = new ConnectionDB();
            ArrayList<Integer> info = new ArrayList<Integer>();
            String req = "SELECT idDa FROM DataArticle WHERE idA="+idA+"";
            Statement stmt = con.getConnection().createStatement();
            ResultSet rset = stmt.executeQuery(req);
            while(rset.next()) {
                info.add(new Integer(rset.getInt(1)));
            }
            return info;
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public ArrayList<String> getDatasName(final int idA) {
        try {
            ConnectionDB con = new ConnectionDB();
            ArrayList<String> info = new ArrayList<String>();
            String req = "SELECT nameDa FROM DataArticle Natural Join Data WHERE idA="+idA+"";
            Statement stmt = con.getConnection().createStatement();
            ResultSet rset = stmt.executeQuery(req);
            while(rset.next()) {
                info.add(new String(rset.getString(1)));
            }
            return info;
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void removeDataArticle(final int idA, final int idDa){
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "DELETE FROM DataArticle WHERE idA=? AND idDa=?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idA);
			st.setInt(2, idDa);
			st.executeUpdate();
			System.out.println("Data: "+idDa+" has been removed from Article: "+idA+"");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
