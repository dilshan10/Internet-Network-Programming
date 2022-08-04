import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Client3Initializer extends Application {
    public static void main(String []args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("views/loginForm3.fxml"))));
        primaryStage.setTitle("ChatApp Test");
        primaryStage.show();
    }
}