package ie.gmit.sw;

public class Job {
	
	// variables
	private int ID;
	private String msg;
	private String def;
	private int jobToDo;//1 = lookup word def and 2 = add definition
	
	//constructor
	public Job(int iD, String msg) {
		super();
		ID = iD;
		this.msg = msg;
		this.def = null;
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

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

	//tostring method
	@Override
	public String toString() {
		return "Job ID: " + ID + ", Word: " + msg;
	}
	
}
