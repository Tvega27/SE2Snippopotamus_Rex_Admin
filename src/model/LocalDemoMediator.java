package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LocalDemoMediator implements Mediator {

	private List<CodeSnippet> serverFiles;

	public LocalDemoMediator() {
		this(new ArrayList<CodeSnippet>());
	}

	public LocalDemoMediator(List<CodeSnippet> toPopulate) {

		this.serverFiles = Objects.requireNonNull(toPopulate);
		this.populate();
	}
	



	@Override
	public List<CodeSnippet> requestServerDump() {
		return this.serverFiles;
	}

	@Override
	public boolean requestServerAdd(CodeSnippet toAdd) {
		this.serverFiles.add(Objects.requireNonNull(toAdd));
		return true;
	}

	@Override
	public boolean requestServerRemove(CodeSnippet toRemove) {
		boolean toReturn = false;
		for (Iterator<CodeSnippet> iter = this.serverFiles.listIterator(); iter.hasNext();) {
			CodeSnippet curr = iter.next();
			if (curr.equals(toRemove)) {
				iter.remove();
				toReturn = true;

			}
		}
		return toReturn;
	}

	private void populate() {
		this.serverFiles.add(new CodeSnippet("Name1", "Description1", "SomeCode1", new ArrayList<StringProperty>() {

			private static final long serialVersionUID = 1L;

			{
				add(new SimpleStringProperty("tag1"));
				add(new SimpleStringProperty("tag2"));
				add(new SimpleStringProperty("tag3"));
			}
		}, true));
		
		this.serverFiles.add(new CodeSnippet("Name2", "Description2", "SomeCode2", new ArrayList<StringProperty>() {

			private static final long serialVersionUID = 1L;

			{
				add(new SimpleStringProperty("tag1"));
				add(new SimpleStringProperty("tag5"));
				add(new SimpleStringProperty("tag4"));
			}
		}, false));
		
		this.serverFiles.add(new CodeSnippet("Name3", "Description3", "SomeCode3", new ArrayList<StringProperty>() {

			private static final long serialVersionUID = 1L;

			{
				add(new SimpleStringProperty("tag6"));
				add(new SimpleStringProperty("tag2"));
				add(new SimpleStringProperty("tag5"));
			}
		}, true));
		
		this.serverFiles.add(new CodeSnippet("Name4", "Description4", "SomeCode4", new ArrayList<StringProperty>() {

			private static final long serialVersionUID = 1L;

			{
				add(new SimpleStringProperty("tag4"));
				add(new SimpleStringProperty("tag6"));
				add(new SimpleStringProperty("tag7"));
			}
		}, false));
		
		this.serverFiles.add(new CodeSnippet("Name5", "Description5", "SomeCode5", new ArrayList<StringProperty>() {

			private static final long serialVersionUID = 1L;

			{
				add(new SimpleStringProperty("tag7"));
				add(new SimpleStringProperty("tag1"));
				add(new SimpleStringProperty("tag3"));
			}
		}, true));
		
		this.serverFiles.add(new CodeSnippet("Name6", "Description6", "SomeCode6", new ArrayList<StringProperty>() {

			private static final long serialVersionUID = 1L;

			{
				add(new SimpleStringProperty("tag1"));
				add(new SimpleStringProperty("tag2"));
				add(new SimpleStringProperty("tag3"));
			}
		}, false));
		
		this.serverFiles.add(new CodeSnippet("Name7", "Description7", "SomeCode7", new ArrayList<StringProperty>() {

			private static final long serialVersionUID = 1L;

			{
				add(new SimpleStringProperty("tag5"));
				add(new SimpleStringProperty("tag7"));
				add(new SimpleStringProperty("tag3"));
			}
		}, true));
		


	}

}
