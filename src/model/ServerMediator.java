package model;

import java.util.List;

/**
 * Mediator that talks to the server.
 * 
 * @author Tyler Vega
 * @version 4/17/18
 *
 */
public class ServerMediator implements Mediator {

	/**
	 * Sends a request to the server to return all snippets.
	 * 
	 * @precondition server must be active
	 * 
	 * @return All the snippets on the server.
	 */
	@Override
	public List<CodeSnippet> requestServerDump() {
		Server server = new Server();
		return server.getAllSnippetsFromServer();
	}

	/**
	 * Sends a request to the server to update a snippet
	 * 
	 * @precondition server must be active
	 * 
	 * @param toUpdate
	 *            The snippet to update on the server
	 * 
	 * @return True if the snippet was updated, otherwise false.
	 */
	@Override
	public boolean requestServerUpdateSnippet(CodeSnippet toUpdate) {
		Server server = new Server();
		return server.updateSnippet(toUpdate);
	}

	/**
	 * Sends a request to the server to remove a snippet
	 * 
	 * @precondition server must be active
	 * 
	 * @param toRemove
	 *            The snippet to remove on the server
	 * 
	 * @return True if the snippet was removed, otherwise false.
	 */
	@Override
	public boolean requestServerRemoveSnippet(CodeSnippet toRemove) {
		Server server = new Server();
		return server.deleteSnippet(toRemove);
	}

}
