package packageServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import vInterface._Task;

@SuppressWarnings("serial")
public abstract class $Task extends UnicastRemoteObject implements _Task {

	protected $Task() throws RemoteException {
		super();
	}

	protected String name;
	protected String desc;
	protected String date;
	protected String deadLine;
	protected boolean isDone;
	private int idG;
	protected TypeTask tt;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc1) {
		desc = desc1;
	}

	public String getName() {
		return name;
	}

	public void setName(String name1) {
		name = name1;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date1) {
		date = date1;
	}

	public String getDeadLine() {
		return deadLine;
	}


	public void setDeadLine(String deadLine1) {
		deadLine = deadLine1;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone1) {
		isDone = isDone1;
	}
	
	public String toString(){
		return "name: "+getName()+"\n desc: "+getDesc()+
				"\n date: "+getDate()+"\n deadLine: "+getDeadLine()
				+"\n isDone: "+isDone();	
	}

	public TypeTask getTt() {
		return tt;
	}
	
	public String getTtString() {
		return tt.getGrade();
	}
	
	public int getRank(){
		return tt.getRank();
	}

	public void setTt(TypeTask tt1) {
		tt = tt1;
	}

	public int getIdG() {
		return idG;
	}

	public void setIdG(int idG) {
		this.idG = idG;
	}
}
