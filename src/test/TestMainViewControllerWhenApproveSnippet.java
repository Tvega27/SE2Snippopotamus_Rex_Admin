package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import controller.MainViewController;
import javafx.beans.property.StringProperty;
import model.CodeSnippet;
import model.Server;

class TestMainViewControllerWhenApproveSnippet {

	@Test
	void test() {
		Server server = new Server();
		server.deleteAllSnippets();

		CodeSnippet testSnippet = new CodeSnippet("admin", "Test Snippet", "Desc");
		server = new Server();
		server.addSnippet(testSnippet);
		MainViewController controller = new MainViewController();
		controller.approveSnippet(testSnippet);
		server = new Server();
		List<CodeSnippet> results = server.getAllSnippetsFromServer();
		boolean wasApproved = true;
		for (CodeSnippet snippet : results) {
			for (StringProperty currStringProp : snippet.getTags()) {
				if(currStringProp.getValue().equals("needs_approval"))
				wasApproved = false;
			}
		}

		assertEquals(true, wasApproved);
	}
	}

