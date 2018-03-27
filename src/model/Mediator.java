package model;

import java.util.List;

public interface Mediator {


	public List<CodeSnippet> requestServerDump();

	public boolean requestServerAdd(CodeSnippet toAdd);

	public boolean requestServerRemove(CodeSnippet toRemove);
	
	

}
