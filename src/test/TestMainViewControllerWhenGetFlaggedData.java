package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MainViewController;
import model.LocalDemoMediator;

class TestMainViewControllerWhenGetFlaggedData {

	@Test
	void testGetFlaggedData() {
		MainViewController controller = new MainViewController(new LocalDemoMediator());
		
		assertEquals(3, controller.getFlaggedData().size());
	}

}
