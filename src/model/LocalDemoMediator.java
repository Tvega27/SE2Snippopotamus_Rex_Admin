package model;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class LocalDemoMediator implements Mediator {

	private List<CodeSnippet> serverFiles;
	private boolean loggedIn;

	public LocalDemoMediator() {
		this(new ArrayList<CodeSnippet>());
	}

	public LocalDemoMediator(List<CodeSnippet> toPopulate) {

		this.serverFiles = Objects.requireNonNull(toPopulate);
	}

	@Override
	public boolean isReachable() {
		return true;
	}

	public boolean isLoggedIn() {
		return loggedIn;
	}

	@Override
	public List<CodeSnippet> requestServerDump() {
		return this.serverFiles;
	}

	@Override
	public boolean requestServerAdd(CodeSnippet toAdd) {
		this.serverFiles.add(Objects.requireNonNull(toAdd));
		return true;
	}

	@Override
	public boolean requestServerRemove(CodeSnippet toRemove) {
		boolean toReturn = false;
		for (Iterator<CodeSnippet> iter = this.serverFiles.listIterator(); iter.hasNext();) {
			CodeSnippet curr = iter.next();
			if (curr.equals(toRemove)) {
				iter.remove();
				toReturn = true;

			}
		}
		return toReturn;
	}

	@Override
	public boolean requestServerModify(CodeSnippet origonal, CodeSnippet changed) {
		return false;
	}

	@Override
	public boolean requestPKey() {
		return true;
	}

	@Override
	public boolean logInToServer(String username, String password) {
		if (username == "user" && password == "pass") {
			return true;
		}
		return false;
	}

	@Override
	public InetAddress getServerAddress() {
		return null;
	}

	@Override
	public void setServerAddress(InetAddress serverAddress) {

	}

	@Override
	public int getPortNumber() {
		return 0;
	}

	@Override
	public void setPortNumber(int portNumber) {

	}

	@Override
	public String getServerPubKey() {
		return null;
	}

	@Override
	public void setServerPubKey(String serverPubKey) {

	}

}
