package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CodeSnippet;
import model.Server;
import model.ServerMediator;

class TestMediatorWhenRemoveSnippet {

	@Test
	void test() {
		CodeSnippet testSnippet = new CodeSnippet("admin", "Test Snippet", "Desc");
		Server server = new Server();
		server.addSnippet(testSnippet);
		ServerMediator mediator = new ServerMediator();
		assertTrue(mediator.requestServerRemoveSnippet(testSnippet));
	}

}
