package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MainViewController;
import model.LocalDemoMediator;

class TestMainViewControllerWhenFilterListWithTag {

	@Test
	void testFilterListWithValidTag() {
		MainViewController controller = new MainViewController(new LocalDemoMediator());
		
		controller.filterListWithTag("tag1");
		
		assertEquals(4, controller.getObservableList().size());
	}

}
