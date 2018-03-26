package model;

import java.net.InetAddress;

public interface Mediator {

	public boolean isReachable();

	public boolean requestServerDumpToJSONString();

	public boolean requestServerAdd(CodeSnippet toAdd);

	public boolean requestServerRemove(CodeSnippet toRemove);

	public boolean requestServerModify(CodeSnippet origonal, CodeSnippet changed);

	public boolean requestPKey();

	public boolean logInToServer(String username, String password);

	public InetAddress getServerAddress();

	public void setServerAddress(InetAddress serverAddress);

	public int getPortNumber();

	public void setPortNumber(int portNumber);

	public String getServerPubKey();

	public void setServerPubKey(String serverPubKey);

}
