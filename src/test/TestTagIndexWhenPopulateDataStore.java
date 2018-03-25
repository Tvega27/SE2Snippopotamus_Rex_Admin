package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;

import org.junit.jupiter.api.Test;

import model.AdminTextFileDataStoreImplementation;
import model.CodeSnippetDataStore;
import model.TagIndex;

class TestTagIndexWhenPopulateDataStore {
	
	@Test
	void testPopulateTagIndexWithValidDataStore() {
		CodeSnippetDataStore ds = new AdminTextFileDataStoreImplementation("data.dat");
		TagIndex index = new TagIndex();
		index.populateIndex(ds);
		
		HashSet<String> allTags = index.getAllTags();
		
		assertEquals(0, allTags.size());
	}
	
	@Test
	void testPopulateTagIndexWithNullDataStore() {
		CodeSnippetDataStore ds = null;
		TagIndex index = new TagIndex();
		
		Throwable exception = assertThrows(NullPointerException.class, () -> {
	           index.populateIndex(ds);
	       });
		
		assertEquals("DataStore can't be null", exception.getMessage());
	}

}
