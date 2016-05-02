package dataBase;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import packageServer.Task;
import packageServer.TypeTask;
import vInterface._Task;
import vInterfaceDB._TaskDB;


@SuppressWarnings("serial")
public class TaskDB extends UnicastRemoteObject implements _TaskDB {
	
	public TaskDB() throws RemoteException {
		super();
	}

	/**
	 * Adds the task.
	 *
	 * @param nameT the name t
	 * @param descT the desc t
	 * @param deadLineT the dead line a String object representing a date in in the format "yyyy-[m]m-[d]d". The leading zero for mm and dd may also be omitted.
	 * @param idG the id g
	 * @param userName the user name
	 * @param tt the type t
	 */
	public void addTask(final String nameT, final String descT, final String deadLine, final int idG, final String userName, final TypeTask tt) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "INSERT INTO Task (nameT, descT, deadLineT, idG, userName, typeT) VALUES (?,?,?,?,?,?)";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			Date deadLineT = Date.valueOf(deadLine);
			st.setString(1, nameT);
			st.setString(2, descT);
			st.setDate(3, deadLineT);
			st.setInt(4, idG);
			st.setString(5, userName);
			st.setInt(6, tt.getRank());
			st.executeUpdate();
			System.out.println("Task: "+nameT+" has been added in Group: "+idG+" to User: "+userName+"");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public ArrayList<_Task> getTasks(final String userName) {
        try {
            ConnectionDB con = new ConnectionDB();
            ArrayList<_Task> info = new ArrayList<>();
            String req = "SELECT idT, nameT, descT, deadLineT, idG, userName, typeT FROM `Task` WHERE userName=?";
            PreparedStatement stmt = con.getConnection().prepareStatement(req);
            stmt.setString(1, userName);
            ResultSet rset = stmt.executeQuery();
            Task t;
            while(rset.next()) {
                t = new Task(rset.getInt(1), rset.getString(2), rset.getString(3), rset.getString(4), rset.getInt(5), rset.getString(6), TypeTask.valueOf(rset.getInt(7)));
                info.add(t);
            }
            return info;
        } catch(SQLException | RemoteException e) {
        	e.printStackTrace();
            throw new RuntimeException(e);
        }
    }


	public void updateTask(final int idT, final String nameT, final String descT, final String deadLine, final int idG, final String userName, final TypeTask typeT) {

		try {
			ConnectionDB con = new ConnectionDB();
			String req = "UPDATE Task SET idT = ?,nameT = ?, descT = ?, deadLineT = ?, idG = ?, userName = ?, typeT = ? WHERE idT = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			Date deadLineT = Date.valueOf(deadLine);
			st.setInt(1, idT);
			st.setString(2, nameT);
			st.setString(3, descT);
			st.setDate(4, deadLineT);
			st.setInt(5, idG);
			st.setString(6, userName);
			st.setInt(7, typeT.getRank());
			st.setInt(8, idT);
			st.executeUpdate();
			System.out.println("Task: "+idT+"\nWhom name: "+nameT+" description : "+descT+" has been updated");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateTaskName(final int idT, final String nameT) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "UPDATE Task SET nameT = ? WHERE idT = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, nameT);
			st.setInt(2, idT);
			st.executeUpdate();
			System.out.println("Task: "+idT+"\nHis name: "+nameT+" has been updated");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateTaskDesc(final int idT, final String descT) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "UPDATE Task SET descT = ? WHERE idT = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setString(1, descT);
			st.setInt(2, idT);
			st.executeUpdate();
			System.out.println("Task: "+idT+"\nHis description: "+descT+" has been updated");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateTaskDeadLine(final int idT, final String deadLine) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "UPDATE Task SET deadLineT = ? WHERE idT = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			Date deadLineT = Date.valueOf(deadLine);
			st.setDate(1, deadLineT);
			st.setInt(2, idT);
			st.executeUpdate();
			System.out.println("Task: "+idT+"\nHis Date: "+deadLine+" has been updated");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void updateTaskType(final int idT, final int typeT) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "UPDATE Task SET typeT = ? WHERE idT = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, typeT);
			st.setInt(2, idT);
			st.executeUpdate();
			System.out.println("Task: "+idT+"\nHis type: "+typeT+" has been updated");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * Removes the task.
	 *
	 * @param idT the id t
	 */
	public void removeTask(final int idT) {
		try {
			ConnectionDB con = new ConnectionDB();
			String req = "DELETE FROM Task WHERE idT = ?";
			PreparedStatement st = con.getConnection().prepareStatement(req);
			st.setInt(1, idT);
			st.executeUpdate();
			System.out.println("Task: "+idT+" has been deleted");
			st.close();
			con.closeDB();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public int getMaxTask() {
		try {
			int maxIdT = 0;
			ConnectionDB con = new ConnectionDB();
			Statement stmt = con.getConnection().createStatement();
			ResultSet rset = stmt.executeQuery("SELECT max(idT) FROM Task");
			if(rset.next()){
				maxIdT = rset.getInt(1);
			}
			stmt.close();
			con.closeDB();
			return maxIdT;
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
