package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Code;
import model.CodeSnippet;
import model.LocalDemoMediator;
import model.Mediator;

class TestDemoMediator {

	@Test
	void testUpdateRemove() {
		Mediator testMediator = new LocalDemoMediator();
		CodeSnippet testSnipp = testMediator.requestServerDump().get(0);
		testSnipp.setToBeRemoved(true);
		testMediator.requestServerUpdateSnippet(testSnipp);
		assertTrue(testMediator.requestServerDump().indexOf(testSnipp) == -1);
	}

	@Test
	void testSnippetModifyName() {
		Mediator testMediator = new LocalDemoMediator();
		CodeSnippet testSnipp = testMediator.requestServerDump().get(0);
		testSnipp.setName("changed");
		testMediator.requestServerUpdateSnippet(testSnipp);
		assertTrue(testSnipp.getName().equals("changed"));

	}

	@Test
	void testSnippetModifyDescription() {
		Mediator testMediator = new LocalDemoMediator();
		CodeSnippet testSnipp = testMediator.requestServerDump().get(0);
		testSnipp.setDescription("changed");
		testMediator.requestServerUpdateSnippet(testSnipp);
		assertTrue(testSnipp.getDescription().equals("changed"));

	}

	@Test
	void testSnippetModifyCode() {
		Mediator testMediator = new LocalDemoMediator();
		CodeSnippet testSnipp = testMediator.requestServerDump().get(0);
		testSnipp.setCode(new Code("changed"));
		testMediator.requestServerUpdateSnippet(testSnipp);
		assertTrue(testSnipp.getCode().getCodeText().equals("changed"));
	}

	@Test
	void testSnippetModifyflag() {
		Mediator testMediator = new LocalDemoMediator();
		CodeSnippet testSnipp = testMediator.requestServerDump().get(0);
		testSnipp.setFlagged(true);
		testMediator.requestServerUpdateSnippet(testSnipp);
		assertTrue(testSnipp.isFlagged());
	}

	@Test
	void testSnippetDoesntExistReturnFalse() {
		Mediator testMediator = new LocalDemoMediator();
		assertFalse(testMediator.requestServerUpdateSnippet(new CodeSnippet("test", "test", "test")));
	}
}
