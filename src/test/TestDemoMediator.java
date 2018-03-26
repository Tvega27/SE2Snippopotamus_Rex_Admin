package test;

import static org.junit.jupiter.api.Assertions.*;

import java.net.InetAddress;

import org.junit.jupiter.api.Test;

import model.LocalDemoMediator;
import model.Mediator;

class TestDemoMediator {

	@Test
	void testGetServerPubKeyReturnNull() {
		Mediator testMediator = new LocalDemoMediator();
		assertNull(testMediator.getServerPubKey());
	}
	@Test
	void testGetServerAddressReturnNull() {
		Mediator testMediator = new LocalDemoMediator();
		assertNull(testMediator.getServerAddress());
	}
	@Test
	void testSetServerPubKeyThrowsException() {
		
		Mediator testMediator = new LocalDemoMediator();
		assertThrows(UnsupportedOperationException.class, ()->{
			testMediator.setServerPubKey("serverPubKey");
            });
		}
	
	@Test
	void testSetPortThrowsException() {
		
		Mediator testMediator = new LocalDemoMediator();
		assertThrows(UnsupportedOperationException.class, ()->{
			testMediator.setPortNumber(0);
            });
		}
	
	@Test
	void testSetServerAddressThrowsException() {
		
		Mediator testMediator = new LocalDemoMediator();
		assertThrows(UnsupportedOperationException.class, ()->{
			testMediator.setServerAddress(InetAddress.getByName("127.0.0.1"));
            });
		}
	
	@Test
	void testIsReachableReturnTrue() {
		Mediator testMediator = new LocalDemoMediator();
		assertTrue(testMediator.isReachable());
	}
	
	@Test
	void testCorrectLoginReturnTrue() {
		Mediator testMediator = new LocalDemoMediator();
		assertTrue(testMediator.logInToServer("user", "pass"));
	}
	@Test
	void testIncorrectLoginReturnFalse() {
		Mediator testMediator = new LocalDemoMediator();
		assertFalse(testMediator.logInToServer("uset", "pass"));
	}
	@Test
	void testisLoggedInReturnFalseIfNotLoggedIn() {
		LocalDemoMediator testMediator = new LocalDemoMediator();
		testMediator.logInToServer("uset", "pass");
		assertFalse(testMediator.isLoggedIn());
	}
	@Test
	void testisLoggedInReturnTrueIfLoggedIn() {
		LocalDemoMediator testMediator = new LocalDemoMediator();
		testMediator.logInToServer("user", "pass");
		assertTrue(testMediator.isLoggedIn());
	}
}
