package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MainViewController;

class TestMainViewControllerWhenGetObservableData {

	@Test
	void testGetObservableData() {
		MainViewController controller = new MainViewController();
		
		assertEquals(7, controller.getObservableList().size());
	}

}
