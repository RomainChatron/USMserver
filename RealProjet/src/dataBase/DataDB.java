package dataBase;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.*;


// TODO: Auto-generated Javadoc
/**
 * The Class DataDB.
 */
public class DataDB {
	
	/** The Constant BUFFER_SIZE. */
	private static final int BUFFER_SIZE = 4096;
	
	/**
	 * Adds the data.
	 *
	 * @param filePath the file path
	 */
	public static void addData(final String filePath) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "INSERT INTO Data (nameDa, typeDa, data) VALUES (?,?,?)";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			File fBlob = new File(filePath);
			FileInputStream data = new FileInputStream(fBlob);
			String nameDa = fBlob.getName();
			String typeDa = nameDa.substring(nameDa.lastIndexOf("."));
			st.setString(1, nameDa);
			st.setString(2, typeDa);
			st.setBinaryStream(3, data, (int) fBlob.length());
			st.executeUpdate();
			System.out.println("Data: "+nameDa+" has been added");
			st.close();
			con.closeDB();
		} catch(SQLException | FileNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void addDataTxt(final String txt) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "INSERT INTO Data (nameDa, typeDa, data) VALUES (?,?,?)";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, "data");
			st.setString(2, ".txt");
			st.setString(3, txt);
			st.executeUpdate();
			System.out.println("Data: "+txt+" has been added");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static String getDataTxt(final int idDa) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "SELECT data FROM Data WHERE idDa=?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idDa);
			ResultSet rset = st.executeQuery();
			if(rset.next()) {
				String txt;
				Blob blob = rset.getBlob(1);
				byte[] bdata = blob.getBytes(1, (int) blob.length());
				txt = new String(bdata);
				return txt;
			}
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
		return null;
	}
	
	/**
	 * Save data.
	 *
	 * @param idDa the id da
	 * @param filePath the file path
	 */
	public static void saveData(final int idDa, final String filePath) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "SELECT nameDa, data FROM Data WHERE idDa=?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idDa);
			ResultSet rset = st.executeQuery();
			if(rset.next()) {
				String nameDa = rset.getString(1);
				Blob blob = rset.getBlob(2);
				InputStream inputStream = blob.getBinaryStream();
				OutputStream outputStream = new FileOutputStream(filePath+"\\"+nameDa);
				int bytesRead = -1;
				byte[] buffer = new byte[BUFFER_SIZE];
				while((bytesRead = inputStream.read(buffer)) != -1) {
					outputStream.write(buffer, 0, bytesRead);
				}
				inputStream.close();
				outputStream.close();
				System.out.println("Data: "+nameDa+" has been saved");
			}
			st.close();
			con.closeDB();
		} catch(SQLException | IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Boolean isDataTxt(final int idDa) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "SELECT typeDa FROM Data WHERE idDa=?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idDa);
			ResultSet rset = st.executeQuery();
			if(rset.next()) {
				return rset.getString(1).equals(".txt");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return new Boolean("false");
	}
	
	/**
	 * Removes the data.
	 *
	 * @param idDa the id da
	 */
	public static void removeData(final int idDa) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "DELETE FROM Data WHERE idDa = ? LIMIT 1";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idDa);
			st.executeUpdate();
			System.out.println("Data: "+idDa+" has been deleted");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
