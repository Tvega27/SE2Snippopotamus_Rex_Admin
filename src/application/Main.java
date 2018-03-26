package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(Main.class.getResource("/view/AdminView.fxml"));
			Scene mainScene = new Scene(root);
			primaryStage.setScene(mainScene);
			primaryStage.setTitle("Snippopotamus Rex Admin");
			Parent root = FXMLLoader.load(Main.class.getResource("/view/AdminView.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("What The Hell Tyler :)");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}