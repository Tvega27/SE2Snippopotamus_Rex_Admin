package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MainViewController;

class TestMainViewControllerWhenFilterListWithTag {

	@Test
	void testFilterListWithValidTag() {
		MainViewController controller = new MainViewController();
		
		controller.filterListWithTag("tag1");
		
		assertEquals(4, controller.getObservableList().size());
	}

}
