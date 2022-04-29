package com.example.kurwaaa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Bollz extends Application {

    @Override
    public void start(final Stage primaryStage) {

        Pane root = new Pane();
        ButtonMenu button = new ButtonMenu();
        Scene scene = new Scene(root, 450, 250);
        primaryStage.setTitle("Boooooollzzz");
        primaryStage.setScene(scene);
        primaryStage.show();
        button.toDo(root);


    }

    public static void main(String[] args) {
        launch(args);
    }

}
