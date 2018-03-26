package view;

import controller.MainViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    
    @FXML
    private Label lblSnippetName;
    
    private MainViewController controller;
    
    private CodeSnippet selected;
    
    @FXML
    private void initialize() {
    	this.controller = new MainViewController("../data.dat");
    	this.selected = null;
    	this.initializeListView();
    	this.updateView(null);
    }
    
	private void initializeListView() {
		this.snippetListView.setItems(this.controller.getObservableList());
		this.snippetListView.getSelectionModel().selectFirst();
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
		if (this.selected != null) {
			this.lblSnippetName.textProperty().unbindBidirectional(this.selected.getNameProperty());
		}
		this.selected = this.snippetListView.selectionModelProperty().getValue().getSelectedItem();
		this.lblSnippetName.textProperty().bindBidirectional(this.selected.getNameProperty());
    }

}
