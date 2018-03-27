package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MainViewController;

class TestMainViewControllerWhenFilterListWith {

	@Test
	void testFilterListWithValidText() {
		MainViewController controller = new MainViewController();
		
		controller.filterListWith("SomeCode1");
		
		assertEquals(1, controller.getObservableList().size());
		assertEquals("SomeCode1", controller.getObservableList().get(0).getCode().getCodeText());
	}
	
	@Test
	void testFilterListWithInvalidText() {
		MainViewController controller = new MainViewController();
		
		controller.filterListWith("");
		
		assertEquals(7, controller.getObservableList().size());
	}

}
