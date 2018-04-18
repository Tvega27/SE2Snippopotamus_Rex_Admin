package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import controller.MainViewController;
import model.Mediator;
import model.ServerMediator;

class TestMainViewControllerWhenAddUser {

	@Test
	void test() {
		MainViewController controller = new MainViewController();
		controller.relayAddUser("test_user");
		Mediator mediator = new ServerMediator();
		assertTrue(mediator.requestServerRemoveUser("test_user"));
	}

}
