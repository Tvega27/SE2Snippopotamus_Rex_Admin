package model;

import java.util.List;

public interface Mediator {


	public List<CodeSnippet> requestServerDump();

	public boolean requestServerUpdateSnippet(CodeSnippet toUpdate);
	
	public boolean requestServerRemoveSnippet(CodeSnippet toRemove);

}
