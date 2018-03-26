package view;

import controller.MainViewController;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import model.CodeSnippet;

/**
 * Code behind for the AdminView
 * 
 * @author Tyler Vega
 *
 */
public class AdminViewCodeBehind {

    @FXML
    private ListView<CodeSnippet> snippetListView;

    @FXML
    private Button approveSnippetButton;

    @FXML
    private Button denySnippetButton;

    @FXML
    private Button loadFlaggedSnippetBtn;

    @FXML
    private TextArea snippetDetailsTxtArea;
    
    private MainViewController controller;
    
    private CodeSnippet selected;
    
    @FXML
    private void initialize() {
    	this.controller = new MainViewController("testing.dat");
    	this.selected = null;
    	this.initializeListView();
    	this.initializeListeners();
    	this.updateView(null);
    }
    
	private void initializeListView() {
		this.snippetListView.setItems(this.controller.getObservableList());
		this.snippetListView.getSelectionModel().selectFirst();
	}
    
	private void initializeListeners() {
		ChangeListener<Boolean> updateSnippetOnLoseFocus = (observable, oldState, hasFocus) -> {
			if (!hasFocus) {
				this.controller.storeCodeSnippet(this.selected);
			}
		};
		this.snippetDetailsTxtArea.focusedProperty().addListener(updateSnippetOnLoseFocus);
	}

    @FXML
    void approveSnippetButtonClick(ActionEvent event) {

    }

    @FXML
    void denySnippetButtonClick(ActionEvent event) {

    }

    @FXML
    void loadFlaggedButtonClick(ActionEvent event) {

    }

    @FXML
    void updateView(MouseEvent event) {

    }

}
