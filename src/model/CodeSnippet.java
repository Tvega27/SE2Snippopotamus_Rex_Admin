package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javafx.beans.Observable;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.util.Callback;

/**
 * Represents a CodeSnippet.
 * 
 * @author David Jarrett & Andrew Weems
 * @version 2/12/2018
 */
public class CodeSnippet {

	private StringProperty name;
	private StringProperty description;
	private ObjectProperty<Code> code;
	private List<StringProperty> tags;
	private boolean flagged;
	private boolean toBeRemoved;
	private int codeHash;

	/**
	 * Any ObservableList created with this callback will automatically refresh
	 * itself when its list items change by reading each property in the CodeSnippet
	 * that changed. Pass as a parameter to an ObservableList constructor.
	 * 
	 * @return A lambda expression that refreshes the list.
	 */
	public static Callback<CodeSnippet, Observable[]> extractor() {
		return (s) -> new Observable[] { s.getNameProperty(), s.getDescriptionProperty(), s.getCodeProperty() };
	}

	/**
	 * Initializes a new CodeSnippet.
	 * 
	 * @preconditions: name != null && description != null && codeText != null
	 * @postconditions: Object will be initialized and ready for use.
	 * @param name
	 *            The name of the CodeSnippet.
	 * @param description
	 *            A description of what the CodeSnippet is/does.
	 * @param codeText
	 *            The actual code stored in the CodeSnippet.
	 * @param tags
	 *            A list of tags belonging to the code snippet
	 * @param flagged
	 *            indicates if the snippet has been flagged for review
	 * @param toBeRemoved
	 *            indicates if the snippet is to be removed from the server. It is
	 *            not recommended that this param be used in constructing a code
	 *            snippet
	 */
	public CodeSnippet(String name, String description, String codeText) {
		this(name, description, codeText, new ArrayList<StringProperty>());
	}

	public CodeSnippet(String name, String description, String codeText, List<StringProperty> tags) {
		this(name, description, codeText, tags, false);
	}

	public CodeSnippet(String name, String description, String codeText, List<StringProperty> tags, boolean flagged) {

		this(name, description, codeText, tags, flagged, false);
	}

	public CodeSnippet(String name, String description, String codeText, List<StringProperty> tags, boolean flagged,
			boolean toBeRemoved) {

		this.name = new SimpleStringProperty(Objects.requireNonNull(name, "Name was null."));
		this.description = new SimpleStringProperty(Objects.requireNonNull(description, "Description was null."));
		Code theCode = new Code(Objects.requireNonNull(codeText, "Code text was null."));
		this.code = new SimpleObjectProperty<>(theCode);
		this.tags = tags;
		this.toBeRemoved = Objects.requireNonNull(toBeRemoved);
		this.flagged = (Objects.requireNonNull(flagged));
		if (isToBeRemoved()) {
			this.hashCodeText();
		} else {
			this.codeHash = -1;
		}

	}

	/**
	 * Gets the name of the CodeSnippet.
	 * 
	 * @preconditions: None
	 * @return The name of the CodeSnippet.
	 */
	public final String getName() {
		return this.name.get();
	}

	/**
	 * Sets the name of the CodeSnippet.
	 * 
	 * @preconditions: name != null
	 * @param name
	 *            The new name of the CodeSnippet.
	 */
	public final void setName(String name) {
		this.name.set(Objects.requireNonNull(name, "Name was null."));
	}

	/**
	 * Gets the name property of the CodeSnippet.
	 * 
	 * @preconditions: None
	 * @return The name property of the CodeSnippet.
	 */
	public StringProperty getNameProperty() {
		return this.name;
	}

	/**
	 * Gets the description of the CodeSnippet.
	 * 
	 * @preconditions: None
	 * @return The description of the CodeSnippet.
	 */
	public final String getDescription() {
		return this.description.get();
	}

	/**
	 * Sets the description of the CodeSnippet.
	 * 
	 * @preconditions: description != null
	 * @param description
	 *            The new description of the CodeSnippet.
	 */
	public final void setDescription(String description) {
		this.description.set(Objects.requireNonNull(description, "Description was null."));
	}

	/**
	 * Gets the description property of the CodeSnippet.
	 * 
	 * @preconditions: None
	 * @return The description property of the CodeSnippet.
	 */
	public StringProperty getDescriptionProperty() {
		return this.description;
	}

	/**
	 * Gets the Code object of this CodeSnippet.
	 * 
	 * @preconditions: None
	 * @return The Code object of this snippet.
	 */
	public final Code getCode() {
		return this.code.get();
	}

	/**
	 * Sets the Code object of this CodeSnippet.
	 * 
	 * @preconditions: code != null
	 * @param code
	 *            The new Code object.
	 */
	public final void setCode(Code code) {
		this.code.set(Objects.requireNonNull(code, "The code was null."));
	}

	/**
	 * Gets the code property of this CodeSnippet.
	 * 
	 * @preconditions: None
	 * @return The code property of this CodeSnippet.
	 */
	public ObjectProperty<Code> getCodeProperty() {
		return this.code;
	}

	/**
	 * Returns a String representation of this CodeSnippet.
	 * 
	 * @preconditions: None
	 * @return A String consisting of the name of this CodeSnippet.
	 */
	@Override
	public String toString() {
		return this.getName();
	}

	/**
	 * Adds a tag to this CodeSnippet.
	 * 
	 * @preconditions: tag isn't null, and the code Snippet has been initialized
	 * @param tag
	 *            the tag to be applied
	 * @postconditions the passed tag is added to this object as a tag
	 */
	public void addTag(String tag) {
		if (!this.containsTag(tag)) {
			this.tags.add(new SimpleStringProperty(Objects.requireNonNull(tag, "The tag was null")));
		}
	}

	/**
	 * Adds a tag to this CodeSnippet.
	 * 
	 * @preconditions: tag isn't null, and the code Snippet has been initialized
	 * @param tag
	 *            the tag to be applied
	 * @postconditions the passed tag is added to this object as a tag
	 */
	public void addTag(StringProperty tag) {
		this.tags.add(Objects.requireNonNull(tag, "The tag was null"));
	}

	/**
	 * removes a tag from this CodeSnippet.
	 * 
	 * @preconditions: tag isn't null, and the code Snippet has been initialized
	 * @param tag
	 *            the tag to be removed
	 * @postconditions the passed tag is removed this object
	 */
	public void removeTag(String tag) {
		this.tags.removeIf(aTag -> aTag.get().equals(tag));
	}

	/**
	 * removes a tag from this CodeSnippet.
	 * 
	 * @preconditions: tag isn't null, and the code Snippet has been initialized
	 * @param tag
	 *            the tag to be removed
	 * @postconditions the passed tag is removed this object
	 */
	public void removeTag(StringProperty tag) {
		if (this.tags.contains(Objects.requireNonNull(tag))) {
			this.tags.remove(tag);
		}
	}

	private boolean containsTag(String tag) {
		boolean toReturn = false;
		for (int i = 0; i < tags.size(); i++) {
			if (this.tags.get(i).getValue().equals(tag)) {
				toReturn = true;
			}
		}
		return toReturn;
	}

	private void hashCodeText() {
		if (this.code == null) {
			throw new IllegalStateException("CodeSnippet has no code, this shouldn't be possible");
		}
		this.codeHash = this.code.get().getCodeText().replaceAll("\\s", "").hashCode();
	}

	/**
	 * Gets the tags of the CodeSnippet.
	 * 
	 * @preconditions: None
	 * @return The tags of the CodeSnippet.
	 */
	public List<StringProperty> getTags() {
		return this.tags;
	}

	/**
	 * Gets the state of the flag for this snippet
	 * 
	 * @preconditions: the code Snippet has been initialized
	 * @return the flag state for the snippet.
	 */
	public boolean isFlagged() {
		return flagged;
	}

	/**
	 * Sets the flag for this snippet.
	 * 
	 * @preconditions: flagged isn't null, and the code Snippet has been initialized
	 * @param flagged
	 *            the tag to be applied
	 * @postconditions the passed flag is set on this object
	 */
	public void setFlagged(boolean flagged) {
		Objects.requireNonNull(flagged);

		this.flagged = flagged;
	}

	/**
	 * Gets the state of the Removal value for this snippet
	 * 
	 * @preconditions: the code Snippet has been initialized
	 * @return The state of the codes removal value .
	 */
	public boolean isToBeRemoved() {
		return toBeRemoved;
	}

	/**
	 * Sets if the snippet is marked for removal.
	 * 
	 * @preconditions: toBeRemoved isn't null, and the code Snippet has been
	 *                 initialized
	 * @param toBeRemoved
	 *            the value for removal
	 * @postconditions the passed removal toggle is set on this object
	 */
	public void setToBeRemoved(boolean toBeRemoved) {
		Objects.requireNonNull(toBeRemoved);
		this.toBeRemoved = toBeRemoved;
	}
	/**
	 * gets the hash of the code snippet.
	 * 
	 * @preconditions: the code Snippet has been
	 *                 initialized
	 * @return returns the hash of the code text / -1 if the code hasn't been hashed.
	 */
	public int getCodeHash() {

		return codeHash;
	}

	/**
	 * Marks the snippet for deletion, and hashes the codetext.
	 * 
	 * @preconditions: The code Snippet has been initialized
	 * @postconditions the snippet's codetext is hashed, and the snippet is marked
	 *                 for removal
	 */
	public void markForDeletion() {
		this.hashCodeText();
		this.toBeRemoved = true;
	}

}