package model;

import java.util.List;

public class ServerMediator implements Mediator {
	private Server server;
	
	public ServerMediator() {
		this.server = new Server();
	}
	
	public ServerMediator(String ipPort) {
		this.server = new Server(ipPort, "admin");
	}

	@Override
	public List<CodeSnippet> requestServerDump() {
		return this.server.getAllSnippetsFromServer();
	}

	@Override
	public boolean requestServerUpdateSnippet(CodeSnippet toUpdate) {
		return this.server.updateSnippet(toUpdate);
	}

}
