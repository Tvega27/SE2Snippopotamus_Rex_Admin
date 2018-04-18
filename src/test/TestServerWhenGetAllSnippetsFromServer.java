package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.CodeSnippet;
import model.Server;

class TestServerWhenGetAllSnippetsFromServer {

	@Test
	void testServerWhenGetAllSnippetsFromServerWithNoSnippets() {
		Server server = new Server();
        assertEquals(true, server.deleteAllSnippets());
        server = new Server();
        List<CodeSnippet> snippets = server.getAllSnippetsFromServer();
        assertEquals(0, snippets.size());
	    }
	
	
	@Test
	void testServerWhenGetAllSnippetsFromDeactivatedServer() {
		Server server = new Server();
		
		server.deactivateServer();
		
		assertThrows(IllegalStateException.class, () -> {
	           server.getAllSnippetsFromServer();
	       });
	}
	
}
