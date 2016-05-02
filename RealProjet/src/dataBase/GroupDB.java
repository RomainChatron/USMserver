package dataBase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import packageServer.Group;
import vInterfaceDB._GroupDB;


// TODO: Auto-generated Javadoc
/**
 * The Class GroupDB.
 */
public class GroupDB extends UnicastRemoteObject implements _GroupDB {
	
	public GroupDB() throws RemoteException {
		super();
	}

	/**
	 * Adds the group.
	 *
	 * @param name the name
	 * @param desc the desc
	 */
	public void addGroup(final String name, final String desc) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "INSERT INTO `Group` (nameG, descG) VALUES (?,?)";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, name);
			st.setString(2, desc);
			st.executeUpdate();
			System.out.println("Group: "+name+" -> "+desc+" has been added");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public Group getGroup(int idG) {
        try {
            ConnectionDB con = new ConnectionDB();
            String req = "SELECT nameG, descG FROM `group` WHERE idG=" + idG;
            Statement stmt = con.getConnection().createStatement();
            //stmt.setInt(1, idG);
            ResultSet rset = stmt.executeQuery(req);
            Group g = null;
            if(rset.next()) {
                 g = new Group(rset.getString(1), rset.getString(2));/*TODO: généricité*/
            }
            return g;
        } catch(SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }
	
	/*public static ArrayList<User> getMembersGroup(final int idT) {
        try {
            ConnectionDB con = new ConnectionDB();
            ArrayList<User> info = new ArrayList<User>();
            String req = "SELECT nameG, descG FROM Group WHERE idT=?";
            Statement stmt = con.getConnection().createStatement();
            ResultSet rset = stmt.executeQuery(req);
            Group g;
            while(rset.next()) {
                 g = new Group(rset.getString(1), rset.getString(2));/*TODO: généricité
                 info.add(g);
            }
            return info;
        } catch(SQLException | RemoteException e) {
            throw new RuntimeException(e);
        }
    }*/
	
	/**
	 * Update group.
	 *
	 * @param idG the id g
	 * @param nameG the name g
	 * @param descG the desc g
	 */
	public void updateGroup(final int idG, final String nameG, final String descG) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "UPDATE `Group` SET nameG = ?, descG = ? WHERE idG = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, nameG);
			st.setString(2, descG);
			st.setInt(3, idG);
			st.executeUpdate();
			System.out.println("Group: "+idG+"\nHis name: "+nameG+" and his description: "+descG+" has been updated");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Removes the group.
	 *
	 * @param idG the id g
	 */
	public void removeGroup(final int idG) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "DELETE FROM `Group` WHERE idG = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idG);
			st.executeUpdate();
			System.out.println("Group: "+idG+" has been deleted");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public int getMaxGroup() {
		try {
			int maxIdG = 0;
			ConnectionDB con = new ConnectionDB();
			Statement stmt = con.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery("SELECT max(idG) FROM Group");
			if(rset.next()){
				maxIdG = rset.getInt(1);
			}
			stmt.close();
			con.closeDB();
			return maxIdG;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
