package packageServer;

import java.rmi.RemoteException;

@SuppressWarnings("serial")
public class Task extends $Task {
	
	private int idT;
	//private ArrayList<SubTask> listST;
	
	/**
	 * Create a new Task with no parameters
	 */
	public Task() throws RemoteException {
		setName("");
		setDesc("");
		setDeadLine(getDate());
		setDone(false);
		setTt(TypeTask.Low);
		//listST = new ArrayList<SubTask>();
	}
	

	/**
	 * Create a new Task with parameters
	 * 
	 * @param name the name
	 * @param desc the desc
	 * @param deadLine the dead line
	 * @param tt the task's type
	 * @param idG the id g
	 * @param userName the userName
	 * 
	 */
	public Task(int idT, String name, String desc, String deadLine, int idG, String userName, TypeTask tt) throws RemoteException {
		setIdT(idT);
		setName(name);
		setDesc(desc);
		//*TODO: setDate -> NOW *//
		setDeadLine(deadLine);
		setDone(false);
		setTt(TypeTask.Low);
		//listST = new ArrayList<SubTask>();
	}

	/**
	 * ADD a new SubTask
	 * 
	 * @param the SubTask
	 */
	/* TODO : SUbTask
	@Override
	public void addSubTask(SubTask ST) throws RemoteException {
		listST.add(ST);		
	}*/

	/**
	 * DELETE a new SubTask
	 * 
	 * @param the SubTask
	 */
	/* TODO : subTask
	@Override
	public void deleteSubTask(SubTask ST) throws RemoteException {
		if(ST.isDone()) listST.remove(ST);		
	}*/
	
	@Override
	public String toString(){
		String isDone = this.isDone() ? "is done" : "is not done";
		return "Name: "+getName()+"\nDescription: "+getDesc()+
				"\nDate: "+getDate()+"\nDeadLine: "+getDeadLine()
				+"\n"+isDone;//+"\nSubTask: "+listST;	
	}
	
	public int getIdT() {
		return idT;
	}

	public void setIdT(int idT) {
		this.idT = idT;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDeadLine(String deadLine) {
		this.deadLine = deadLine;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
}
