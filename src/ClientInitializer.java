import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ClientInitializer extends Application {
    public static void main(String [] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(FXMLLoader.load(this.getClass().getResource("views/loginForm.fxml"))));
        primaryStage.setTitle("live Chat");
        primaryStage.show();
    }
}