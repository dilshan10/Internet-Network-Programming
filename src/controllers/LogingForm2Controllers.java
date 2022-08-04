package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LogingForm2Controllers {
    public TextField txtUserName;
    public AnchorPane root;

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException {
        if(txtUserName.getText().equals("")){
            new Alert(Alert.AlertType.ERROR,"Please Enter the UserName").show();
        }else {
            Parent parent = FXMLLoader.load(this.getClass().getResource("../views/ClientForm.fxml"));
            Scene scene = new Scene(parent);
            Stage primaryStage = (Stage) this.root.getScene().getWindow();
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        }
    }
}
