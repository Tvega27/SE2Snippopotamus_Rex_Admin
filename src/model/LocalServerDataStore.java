package model;

import java.util.Date;
import java.util.List;

public class LocalServerDataStore extends TextFileDataStoreImplementation {

	private Date dateCreated;

	public LocalServerDataStore(String filename) {
		super(filename);
		this.setDateCreated(new Date());

	}

	public LocalServerDataStore(String filename, List<CodeSnippet> snippets, boolean overwrite) {
		super(filename, snippets, overwrite);
		this.setDateCreated(new Date());

	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
}
