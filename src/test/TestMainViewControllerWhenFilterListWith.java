package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MainViewController;
import model.LocalDemoMediator;

class TestMainViewControllerWhenFilterListWith {

	@Test
	void testFilterListWithValidText() {
		MainViewController controller = new MainViewController(new LocalDemoMediator());
		
		controller.filterListWith("SomeCode1");
		
		assertEquals(1, controller.getObservableList().size());
		assertEquals("SomeCode1", controller.getObservableList().get(0).getCode().getCodeText());
	}
	
	@Test
	void testFilterListWithInvalidText() {
		MainViewController controller = new MainViewController(new LocalDemoMediator());
		controller.filterListWith("");
		
		assertEquals(7, controller.getObservableList().size());
	}

}
