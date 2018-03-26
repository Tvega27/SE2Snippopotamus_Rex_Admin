package controller;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.AdminTextFileDataStoreImplementation;
import model.CodeSnippet;
import model.CodeSnippetDataStore;
import model.LocalDemoMediator;
import model.TagIndex;

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
	private TagIndex tagIndex;

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
		for (CodeSnippet current : this.mediator.getServerFiles()) {
			this.unfilteredData.add(current);
		}
		this.observableData = this.unfilteredData;
	}

	private void loadFlaggedData() {
		for (CodeSnippet current : this.mediator.getServerFiles()) {
			if (current.isFlagged()) {

				this.flaggedData.add(current);
			}

		}
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
	 * Returns the TagIndex object in this controller.
	 * 
	 * @preconditions: None
	 * @return The TagIndex
	 */
	public TagIndex getTagIndex() {
		return tagIndex;
	}

	/**
	 * Gets a list of all tags that currently exist in the program.
	 * 
	 * @preconditions: None
	 * @return The list of tags.
	 */
	public ObservableList<String> getAllExistingTags() {
		HashSet<String> tags = this.tagIndex.getAllTags();
		ObservableList<String> allTags = FXCollections.observableArrayList();
		tags.forEach(tag -> allTags.add(tag));
		return allTags;
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
