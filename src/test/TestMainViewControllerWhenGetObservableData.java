package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MainViewController;
import model.LocalDemoMediator;

class TestMainViewControllerWhenGetObservableData {

	@Test
	void testGetObservableData() {
		MainViewController controller = new MainViewController(new LocalDemoMediator());
		
		assertEquals(7, controller.getObservableList().size());
	}

}
