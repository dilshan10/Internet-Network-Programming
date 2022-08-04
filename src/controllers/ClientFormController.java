package controllers;

import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.*;
import java.net.Socket;
import java.time.LocalTime;

public class ClientFormController {
    public TextArea txtChatArea;
    public Label lbltime;

    final int PORT= 5000;
    public TextField txtMassege;
    public Label lblUserName;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    String massage = "";

    public void initialize(){
        setTime();
        while (true) {
            new Thread(() -> {
                try {
                    socket = new Socket("localhost", 5000);

                    dataInputStream = new DataInputStream(socket.getInputStream());
                    dataOutputStream = new DataOutputStream(socket.getOutputStream());

                    while (!massage.equals("exit")) {
                        massage = dataInputStream.readUTF();
                        txtChatArea.appendText("\n Server : " + massage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }

    public void btnSendOnAction(ActionEvent actionEvent) throws IOException {
        dataOutputStream.writeUTF(txtMassege.getText().trim());
        dataOutputStream.flush();
        txtMassege.clear();
    }

    private void setTime(){
        Timeline Clock =new Timeline(new KeyFrame(Duration.ZERO, e ->{
            LocalTime currentTime = LocalTime.now();
            lbltime.setText(currentTime.getHour()+":"+
                    currentTime.getMinute()+":"+
                    currentTime.getSecond());
        }),
                new KeyFrame(Duration.seconds(1))
        );
        Clock.setCycleCount(Animation.INDEFINITE);
        Clock.play();
    }

    public void AddPhoto(MouseEvent mouseEvent) {
    }
}
