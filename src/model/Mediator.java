package model;

import java.util.List;

/**
 * Interface for a mediator
 * 
 * @author Tyler Vega, Andrew Weems
 * @version 4/17/18
 *
 */
public interface Mediator {


	public List<CodeSnippet> requestServerDump();

	public boolean requestServerUpdateSnippet(CodeSnippet toUpdate);
	
	public boolean requestServerRemoveSnippet(CodeSnippet toRemove);
	
	public boolean requestServerAddUser(String user);
	
	public boolean requestServerRemoveUser(String user);

}
