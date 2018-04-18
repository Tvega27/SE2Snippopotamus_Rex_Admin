package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.CodeSnippet;
import model.Server;
import model.ServerMediator;

class TestServerMediatorWhenUpdateSnippet {

	@Test
	void test() {
			CodeSnippet testSnippet = new CodeSnippet("admin", "Test Snippet", "Desc");
			Server server = new Server();
			server.addSnippet(testSnippet);
			testSnippet = new CodeSnippet("admin", "Test Snippet", "Longer Description");
			ServerMediator mediator = new ServerMediator();
			assertTrue(mediator.requestServerUpdateSnippet(testSnippet));
		}
	}


