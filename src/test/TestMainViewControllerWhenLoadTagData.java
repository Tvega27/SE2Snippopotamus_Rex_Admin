package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MainViewController;
import model.CodeSnippet;
import model.LocalDemoMediator;

class TestMainViewControllerWhenLoadTagData {

	@Test
	void testLoadTagDataWithValidSnippetThatContainsOneTag() {
		MainViewController controller = new MainViewController(new LocalDemoMediator());
		CodeSnippet cs = new CodeSnippet("Name", "Description", "Code Text");
		cs.addTag("New tag 1");
		
		assertEquals("New tag 1", controller.loadTagData(cs).get(0));
	}
	
	@Test
	void testLoadTagDataValidSnippetWithNoTags() {
		MainViewController controller = new MainViewController(new LocalDemoMediator());
		CodeSnippet cs = new CodeSnippet("Name", "Description", "Code Text");
		
		assertEquals(0, controller.loadTagData(cs).size());
	}
	
	@Test
	void testLoadTagDataValidSnippetWithManyTags() {
		MainViewController controller = new MainViewController(new LocalDemoMediator());
		CodeSnippet cs = new CodeSnippet("Name", "Description", "Code Text");
		cs.addTag("New tag 1");
		cs.addTag("New tag 2");
		cs.addTag("New tag 3");
		
		assertEquals("New tag 1", controller.loadTagData(cs).get(0));
		assertEquals("New tag 2", controller.loadTagData(cs).get(1));
		assertEquals("New tag 3", controller.loadTagData(cs).get(2));
		assertEquals(3, controller.loadTagData(cs).size());
	}
}
