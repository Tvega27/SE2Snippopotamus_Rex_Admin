package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Code;

class TestCodeWhenSetCodeText {

	@Test
	void testSetCodeTextWithValidCodeText() {
		Code code = new Code("Initial code text");
		
		code.setCodeText("New code text");
		
		assertEquals("New code text", code.getCodeText());
	}
	
	@Test
	void testSetCodeTextWithNullCodeText() {
		Code code = new Code("Initial code text");
		
		assertThrows(NullPointerException.class, () -> code.setCodeText(null));
	}

}
