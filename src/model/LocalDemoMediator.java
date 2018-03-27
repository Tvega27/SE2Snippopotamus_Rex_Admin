package model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LocalDemoMediator implements Mediator {

	private List<CodeSnippet> serverFiles;

	/**
	 * Initializes a new LocalDemoMediator.
	 * 
	 * @preconditions: name != null && description != null && codeText != null
	 * 
	 * @param name
	 *            The name of the CodeSnippet.
	 * 
	 * @postconditions: Object will be initialized and ready for use.
	 */
	public LocalDemoMediator() {
		this(new ArrayList<CodeSnippet>(0));
	}

	public LocalDemoMediator(List<CodeSnippet> toPopulate) {
		this.serverFiles = Objects.requireNonNull(toPopulate);
		if (toPopulate.size() == 0) {
			this.populate();
		}

	}
	/**
	 * Gets the list of snippets stored in the demo mediator.
	 * 
	 * @preconditions: the DemoMediator has been initialized
	 * @return The list of snippets stored in the demo mediator.
	 */
	@Override
	public List<CodeSnippet> requestServerDump() {
		return this.serverFiles;
	}
	/**
	 * Requests that the mediator update it's list of snippits.
	 * 
	 * @preconditions: the DemoMediator has been initialized && toUpdate!= null
	 * @return false if the snippet isn't contained in the mediator, otherwise true
	 */
	@Override
	public boolean requestServerUpdateSnippet(CodeSnippet toUpdate) {

		Objects.requireNonNull(toUpdate);
		int snippetIndex = this.serverFiles.indexOf(toUpdate);
		if (snippetIndex == -1) {
			return false;
		}
		if (toUpdate.isToBeRemoved()) {
			this.serverFiles.remove(snippetIndex);
		} else {
			this.serverFiles.set(snippetIndex, toUpdate);
		}

		return true;
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
