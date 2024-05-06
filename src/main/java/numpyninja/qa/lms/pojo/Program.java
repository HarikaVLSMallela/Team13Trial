package numpyninja.qa.lms.pojo;

public class Program {

	private String programName;
	private String programDescription;
	private String programStatus;
	
	public Program(String programName, String programDescription, String programStatus) {
		this.programName = programName;
		this.programDescription = programDescription;
		this.programStatus = programStatus;
	}
	
	public Program() {}
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getProgramDescription() {
		return programDescription;
	}
	public void setProgramDescription(String programDescription) {
		this.programDescription = programDescription;
	}
	public String getProgramStatus() {
		return programStatus;
	}
	public void setProgramStatus(String programStatus) {
		this.programStatus = programStatus;
	}

	@Override
	public String toString() {
		return "Program [programName=" + programName + ", programDescription=" + programDescription + ", programStatus="
				+ programStatus + "]";
	}

	
}
