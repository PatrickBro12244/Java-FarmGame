//KYLE PATRICK ROLAND M. FRANCISCO & JOHN ISAAC J. ZUNIGA
//S24

//Constructor for Report
// 				-Report is the feedback given after an action is executed in Tile
// @param success = a bool representing whether an action was successful or not
// @param message = a string containing detailed feedback of what happened after an action was executed
public class Report { 

	private boolean success; 
	private String message; 
	

	public Report(boolean success, String message) {
		this.success = success; 
		this.message = message; 
	}

	public boolean isSuccess() { 
		return success; 
	}
	public void setSuccess(boolean success) { 
		this.success = success; 
	}
	public boolean GetSuccess() { 
		return success;
	}

	public String getMessage() { 
		return message; 
	}
	public void setMessage(String message) { 
		this.message = message; 
	}

	@Override
	public String toString() {
		return "\nSuccess? = " + success + "\n Feedback = " + message + "\n" ; 
	}
}
