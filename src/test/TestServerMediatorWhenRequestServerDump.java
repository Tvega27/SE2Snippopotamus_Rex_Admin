package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import model.CodeSnippet;
import model.Mediator;
import model.ServerMediator;

class TestServerMediatorWhenRequestServerDump {

	@Test
	void test() {
		Mediator mediator = new ServerMediator();
		List<CodeSnippet> testList = mediator.requestServerDump();
		assertTrue(testList!= null);
	}

}
