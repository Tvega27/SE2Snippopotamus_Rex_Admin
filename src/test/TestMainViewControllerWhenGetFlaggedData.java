package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MainViewController;

class TestMainViewControllerWhenGetFlaggedData {

	@Test
	void testGetFlaggedData() {
		MainViewController controller = new MainViewController();
		
		assertEquals(4, controller.getFlaggedData().size());
	}

}
