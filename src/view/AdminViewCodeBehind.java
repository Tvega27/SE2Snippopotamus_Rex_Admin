package view;

import controller.MainViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
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
    
    @FXML
    private RadioButton rbtnFlaggedFilter;
    
    @FXML
    private ListView<String> tagListView;
    
    @FXML
    private TitledPane tagsTitlePane;

    @FXML
    private Button btnAddTag;

    @FXML
    private Button btnRemoveTag;

    @FXML
    private TitledPane detailsTitlePane;

    @FXML
    private TextField nameTextField;
    
    @FXML
    private Accordion detailsAccordian;
    
    private MainViewController controller;
    
    private CodeSnippet selected;
    
    @FXML
    private void initialize() {
    	this.controller = new MainViewController();
    	this.selected = null;
    	this.detailsAccordian.setExpandedPane(tagsTitlePane);
    	this.initializeListView();
    	this.updateView(null);
    }
    
	private void initializeListView() {
		this.snippetListView.setItems(this.controller.getObservableList());
		this.snippetListView.getSelectionModel().selectFirst();
	}

    @FXML
    private void approveSnippetButtonClick(ActionEvent event) {

    }

    @FXML
    private void denySnippetButtonClick(ActionEvent event) {

    }

    @FXML
    private void loadFlaggedButtonClick(ActionEvent event) {
    	if(this.rbtnFlaggedFilter.isSelected()) {
    		this.snippetListView.setItems(this.controller.getFlaggedData());
        	this.approveSnippetButton.setDisable(false);
        	this.denySnippetButton.setDisable(false);
    	} else {
    		this.snippetListView.setItems(this.controller.getObservableList());
    		this.approveSnippetButton.setDisable(true);
        	this.denySnippetButton.setDisable(true);
    	}
    }

    @FXML
    private void updateView(MouseEvent event) {
		if (this.selected != null) {
			this.lblSnippetName.textProperty().unbindBidirectional(this.selected.getNameProperty());
			this.nameTextField.textProperty().unbindBidirectional(this.selected.getNameProperty());
		}
		this.selected = this.snippetListView.selectionModelProperty().getValue().getSelectedItem();
		this.lblSnippetName.textProperty().bindBidirectional(this.selected.getNameProperty());
		this.snippetDetailsTxtArea.textProperty().setValue(this.selected.getCode().getCodeText());
		this.nameTextField.textProperty().bindBidirectional(this.selected.getNameProperty());
		this.tagListView.setItems(this.controller.loadTagData(this.selected));
    }

}
