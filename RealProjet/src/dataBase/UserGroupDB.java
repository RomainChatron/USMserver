package dataBase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vInterfaceDB._UserGroupDB;

/**
 * The Class UserGroupDB.
 */
public class UserGroupDB extends UnicastRemoteObject implements _UserGroupDB{
	
	public UserGroupDB() throws RemoteException {
		super();
	}

	/**
	 * Adds the user group.
	 * @param idG the id g
	 * @param userName the user name
	 * @param admin the admin
	 */
	public void addUserGroup(final int idG, final String userName, final boolean admin){
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "INSERT INTO `UserGroup` (idG, userName, admin) VALUES (?,?,?)";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idG);
			st.setString(2, userName);
			st.setBoolean(3, admin);
			st.executeUpdate();
			System.out.println("User: "+userName+" has been added in Group:"+idG+"");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<Integer> getGroups(final String userName) {
        try {
            ConnectionDB con = new ConnectionDB();
            ArrayList<Integer> info = new ArrayList<>();
            String req = "SELECT idG FROM UserGroup WHERE userName='"+userName+"'";
            Statement stmt = con.getConnection().createStatement();
            ResultSet rset = stmt.executeQuery(req);
            while(rset.next()) {
                info.add(rset.getInt(1));
            }
            return info;
        } catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	/**
	 * Removes the user group.
	 *
	 * @param idG the id g
	 * @param userName the user name
	 */
	public void removeUserGroup(final int idG, final String userName){
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "DELETE FROM UserGroup WHERE idG=? AND userName=?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idG);
			st.setString(2, userName);
			st.executeUpdate();
			System.out.println("User: "+userName+" has been removed from Group: "+idG+"");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
