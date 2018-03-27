package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Code;

class TestCodeWhenContainsText {

	@Test
	void testContainsTextOnCodeThatContainsText() {
		Code code = new Code("Test code text");
		
		boolean result = code.containsText("text");
		
		assertEquals(true, result);
	}

	@Test
	void testContainsTextWithNullQueryText() {
		Code code = new Code("Test code text");
		
		assertThrows(NullPointerException.class, () -> code.containsText(null));
	}
}
