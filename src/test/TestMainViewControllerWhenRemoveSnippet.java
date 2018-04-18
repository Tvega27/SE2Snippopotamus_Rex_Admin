package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import controller.MainViewController;
import model.CodeSnippet;
import model.Server;

class TestMainViewControllerWhenRemoveSnippet {

	@Test
	void test() {
		Server server = new Server();
		server.deleteAllSnippets();

		CodeSnippet testSnippet = new CodeSnippet("admin", "Test Snippet", "Desc");
		server = new Server();
		server.addSnippet(testSnippet);
		MainViewController controller = new MainViewController();
		controller.relaySnippetRemove(testSnippet);
		server = new Server();
		List<CodeSnippet> results = server.getAllSnippetsFromServer();
		boolean wasFound = false;
		for (CodeSnippet snippet : results) {
			if (snippet.getDescription().equals(testSnippet.getDescription())) {
				wasFound = true;
			}
		}

		assertEquals(false, wasFound);
	}
	}


