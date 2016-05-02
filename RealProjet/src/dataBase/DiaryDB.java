package dataBase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import vInterfaceDB._DiaryDB;

// TODO: Auto-generated Javadoc
/**
 * The Class Diary.
 */
public class DiaryDB extends UnicastRemoteObject implements _DiaryDB {
	
	public DiaryDB() throws RemoteException {
		super();
	}

	/**
	 * Adds the diary.
	 *
	 * @param nameDi the name di
	 * @param idG the id g
	 */
	public void addDiary(final String nameDi, final int idG) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "INSERT INTO Diary (nameDi, idG) VALUES (?,?)";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, nameDi);
			st.setInt(2, idG);
			st.executeUpdate();
			System.out.println("Diary: "+nameDi+" has been added in Group: "+idG+"");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Update diary. Changer idG ????????????????????????????????????????????????????????????? 
	 *
	 * @param idDi the id di
	 * @param nameDi the name di
	 * @param idG the id g
	 */
	public void updateDiary(final int idDi, final String nameDi, final int idG) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "UPDATE Diary SET nameDi = ?, idG = ? WHERE idDi = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, nameDi);
			st.setInt(2, idG);
			st.setInt(3, idDi);
			st.executeUpdate();
			System.out.println("Diary: "+idDi+"\nName: "+nameDi+" in Group: "+idG+" has been updated");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Update diary.
	 *
	 * @param idDi the id di
	 * @param nameDi the name di
	 */
	public void updateDiary(final int idDi, final String nameDi) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "UPDATE Diary SET nameDi = ? WHERE idDi = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, nameDi);
			st.setInt(2, idDi);
			st.executeUpdate();
			System.out.println("Diary: "+idDi+"\nName: "+nameDi+" has been updated");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Removes the diary.
	 *
	 * @param idDi the id di
	 */
	public void removeDiary(final int idDi) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "DELETE FROM Diary WHERE idDi = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idDi);
			st.executeUpdate();
			System.out.println("Diary: "+idDi+" has been deleted");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int getMaxDiary() {
		try {
			int maxIdDi = 0;
			ConnectionDB con = new ConnectionDB();
			Statement stmt = con.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery("SELECT max(idDi) FROM Diary");
			if(rset.next()){
				maxIdDi = rset.getInt(1);
			}
			stmt.close();
			con.closeDB();
			return maxIdDi;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
