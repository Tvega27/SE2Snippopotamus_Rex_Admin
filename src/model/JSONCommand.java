package model;

public class JSONCommand {

	private String command;
	private String paramaters;

	public JSONCommand(String command, String paramaters) {
		this.command = command;
		this.paramaters = paramaters;
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public String getParamaters() {
		return paramaters;
	}

	public void setParamaters(String paramaters) {
		this.paramaters = paramaters;
	}
}
