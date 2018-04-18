package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import model.Mediator;
import model.ServerMediator;

class TestServerMediatorWhenAddUser {

	@Test
	void testServerMediatorWhenAddUser() {
Mediator mediator = new ServerMediator();
		
		mediator.requestServerRemoveUser("test_user");
		assertTrue(mediator.requestServerAddUser("test_user"));
	}

}
