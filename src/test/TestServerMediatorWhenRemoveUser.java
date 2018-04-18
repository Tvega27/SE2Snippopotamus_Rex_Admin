package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Mediator;
import model.ServerMediator;

class TestServerMediatorWhenRemoveUser {

	@Test
	void test() {
		Mediator mediator = new ServerMediator();
		mediator.requestServerAddUser("test_user");
		assertTrue(mediator.requestServerRemoveUser("test_user"));
	}

}
