package packageServer;

import vInterface._TypeTask;

public enum TypeTask implements _TypeTask {
	
	Low("Low", 1),
	Normal("Normal", 2),
	High("High", 3),
	Urgent("Urgent", 4);
	
	private String grade;
	private int rank;
	
	private TypeTask(String grade, int rank){
		this.setGrade(grade);
		this.rank = rank;
	}
	
	private TypeTask(int rank){
		this.rank = rank;
		this.setGrade(rank);
	}
	
	public int getRank(){
		return rank;
	}
	
	public static TypeTask valueOf(int i) {
		TypeTask tt = null;
		switch(i){
		case 1 : 
			tt = TypeTask.Low;
			break;
		case 2 : 
			tt = TypeTask.Normal;
			break;
		case 3 : 
			tt = TypeTask.High;
			break;
		case 4 : 
			tt = TypeTask.Urgent;
			break;	
		}
		return tt;
	}
	
	public void setGrade(int rank) {
		switch(rank){
		case 1 : 
			this.grade = "Low" ;
			break ;
		case 2 : 
			this.grade = "Normal" ;
			break;
		case 3 : 
			this.grade = "High" ;
			break;
		case 4 : 
			this.grade = "Urgent" ;
			break;	
		}
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
