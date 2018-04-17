package model;

import java.util.List;

public class ServerMediator implements Mediator {
	
	public ServerMediator() {
		
	}

	@Override
	public List<CodeSnippet> requestServerDump() {
		Server server = new Server();
		return server.getAllSnippetsFromServer();
	}

	@Override
	public boolean requestServerUpdateSnippet(CodeSnippet toUpdate) {
		Server server = new Server();
		return server.updateSnippet(toUpdate);
	}

	@Override
	public boolean requestServerRemoveSnippet(CodeSnippet toRemove) {
		Server server = new Server();
		return server.deleteSnippet(toRemove);
	}

}
