package com.example.javafxchat;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("hello-view.fxml"));
        Parent load = fxmlLoader.load();
        Scene scene = new Scene(load);
        stage.setTitle("GeekBrains");
        stage.setScene(scene);
        HelloController controller = fxmlLoader.getController();
        controller.userList.getItems().addAll("User 1", "User 2", "User 3");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}