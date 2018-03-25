package test;


import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.CodeSnippet;
import model.Mediator;

class TestJSONCodeSnippet {

	@Test
	void testWhenCreatingJSONFromCodeSnippet() {
		List<StringProperty> testTags = new ArrayList<StringProperty>();
		StringProperty tag = new SimpleStringProperty();
		StringProperty tag2 = new SimpleStringProperty();
		tag.setValue("tag 1");
		testTags.add(tag);
		tag2.setValue("tag 2");
		testTags.add(tag2);
		CodeSnippet testSnippet = new CodeSnippet("Test", "test", "test", testTags, true);
		String testString = new Mediator().jsonStringFromSnippet(testSnippet);
		String expectedJSON = "{\"name\":\"Test\",\"description\":\"test\",\"code\":\"test\",\"tags\":[\"tag 1\",\"tag 2\"],\"flagged\":true}";

		assert (testString.equals(expectedJSON));
	}

}
