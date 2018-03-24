package model;

public class JSONValidation {
	private String appPubKey;
	private String userName;
	private String password;

	public JSONValidation(String appPubKey, String userName, String password) {
		;
		this.appPubKey = appPubKey;
		this.userName = userName;
		this.password = password;
	}

	public String getAppPubKey() {
		return appPubKey;
	}

	public void setAppPubKey(String appPubKey) {
		this.appPubKey = appPubKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
