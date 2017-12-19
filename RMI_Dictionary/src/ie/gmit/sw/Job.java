package ie.gmit.sw;

public class Job {
	
	// variables
	private int ID;
	private String msg;
	
	//constructor
	public Job(int iD, String msg) {
		super();
		ID = iD;
		this.msg = msg;
	}
	
	//getters setters
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "Job ID: " + ID + ", Word: " + msg + "]";
	}
	

}
