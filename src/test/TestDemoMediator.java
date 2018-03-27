package test;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;

import model.CodeSnippet;
import model.LocalDemoMediator;
import model.Mediator;

class TestDemoMediator {



	@Test
	void testSnippetAddMediator() {
		Mediator testMediator = new LocalDemoMediator();
		int sizeBefore = testMediator.requestServerDump().size();
		testMediator.requestServerAdd(new CodeSnippet("test","test","test"));
		assertTrue(sizeBefore<testMediator.requestServerDump().size() );
	}
	@Test
	void testSnippetRemoveMediator() {
		Mediator testMediator = new LocalDemoMediator();
		int sizeBefore = testMediator.requestServerDump().size();
		CodeSnippet toRemove =  testMediator.requestServerDump().get(0);
		testMediator.requestServerRemove(toRemove);
		assertTrue(sizeBefore>testMediator.requestServerDump().size() );
	}
}
