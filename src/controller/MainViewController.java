package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.CodeSnippet;
import model.LocalDemoMediator;

/**
 * Controller for the main view.
 * 
 * @author David Jarrett
 * @version 2/12/2018
 */
public class MainViewController {

	private LocalDemoMediator mediator;
	private ObservableList<CodeSnippet> observableData;
	private ObservableList<CodeSnippet> unfilteredData;
	private ObservableList<CodeSnippet> filteredData;
	private ObservableList<CodeSnippet> flaggedData;
	private ObservableList<CodeSnippet> toBeRemoved;

	/**
	 * Initializes the controller by loading the code snippet data from the
	 * data-store.
	 * 
	 * @preconditions: filename != null
	 * @postconditions: Code snippet data will be loaded into the data-store.
	 * @param filename
	 *            The name of the code snippet data file.
	 */
	public MainViewController() {
		this.mediator = new LocalDemoMediator();
		this.unfilteredData = FXCollections.observableArrayList(CodeSnippet.extractor());
		this.toBeRemoved = FXCollections.observableArrayList();
		this.flaggedData = FXCollections.observableArrayList(CodeSnippet.extractor());
		this.loadObservableData();
		this.loadFlaggedData();
	}

	private void loadObservableData() {
		this.unfilteredData = FXCollections.observableArrayList(CodeSnippet.extractor());
		for (CodeSnippet current : this.mediator.requestServerDump()) {
			this.unfilteredData.add(current);
		}
		this.observableData = this.unfilteredData;
	}

	private void loadFlaggedData() {
		this.flaggedData = FXCollections.observableArrayList(CodeSnippet.extractor());
		for (CodeSnippet current : this.mediator.requestServerDump()) {
			if (current.isFlagged()) {

				this.flaggedData.add(current);
			}

		}
	}

	/**
	 * Returns the tags associated with the specified snippet.
	 * 
	 * @param snippet
	 *            the code snippet
	 * @return An observable list of the tags of the specified snippet.
	 */
	public ObservableList<String> loadTagData(CodeSnippet snippet) {
		ArrayList<String> allTags = new ArrayList<String>();
		for (StringProperty tag : snippet.getTags()) {
			String aTag = tag.getValueSafe();
			allTags.add(aTag);
		}
		return FXCollections.observableArrayList(allTags);
	}

	/**
	 * Returns the flagged code snippets
	 * 
	 * @return the flagged code snippets
	 */
	public ObservableList<CodeSnippet> getFlaggedData() {
		return this.flaggedData;
	}

	/**
	 * Returns the observable CodeSnippet list.
	 * 
	 * @preconditions: None
	 * @return An observable list of code snippets.
	 */
	public ObservableList<CodeSnippet> getObservableList() {
		return this.observableData;
	}

	/**
	 * Relays the approval or denial of a snippet to the mediator.
	 * 
	 * @param snippet
	 *            the snippet
	 * 
	 * @postcondition If approved the snippet remains in the server, If denied the
	 *                snippet is removed.
	 */
	public void relaySnippetUpdate(CodeSnippet snippet) {
		this.mediator.requestServerUpdateSnippet(snippet);
		this.loadObservableData();
		this.loadFlaggedData();
	}

	/**
	 * Sets the current observable list to either the standard unfiltered list, or
	 * to a filtered version of the standard list that is filtered on the provided
	 * text.
	 * 
	 * @preconditions: text != null
	 * @postconditions: The current observable list will either be filtered or
	 *                  unfiltered.
	 * @param text
	 *            The text to filter with.
	 */
	public void filterListWith(String text) {
		Objects.requireNonNull(text, "Filter text was null.");
		if (text.equals("")) {
			this.observableData = this.unfilteredData;
		} else {
			this.filteredData = this.unfilteredData.filtered((snippet) -> {
				return snippet.getCode().containsText(text);
			});
			this.observableData = this.filteredData;
		}
	}

	/**
	 * Sets the current observable list to either the standard unfiltered list, or
	 * to a filtered version of the standard list that is filtered on the provided
	 * tag.
	 * 
	 * @preconditions: text != null
	 * @postconditions: The current observable list will either be filtered or
	 *                  unfiltered.
	 * @param text
	 *            The text to filter with.
	 */
	public void filterListWithTag(String filterString) {
		this.filteredData = this.unfilteredData.filtered((snippet) -> {
			boolean[] containsTag = { false };
			List<StringProperty> tags = snippet.getTags();
			tags.forEach(tagProperty -> {
				if (tagProperty.get().equals(filterString))
					containsTag[0] = true;
			});
			return containsTag[0];
		});
		this.observableData = this.filteredData;
	}

}
