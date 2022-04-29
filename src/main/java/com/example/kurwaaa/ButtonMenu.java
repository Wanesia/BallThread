package com.example.kurwaaa;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ButtonMenu extends Application {

    public void toDo(Pane pane){
        ArrayList<Circle> ball= new ArrayList<>();
        Button button = new Button();
        button.setText("spawn ball");
        button.setLayoutX(250);
        button.setLayoutY(220);
        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                BallThread ballThread = new BallThread();
                System.out.println("button pressed");

                ballThread.start();

                ballThread.setBall(pane);
                System.out.println(Thread.activeCount());
            }
        });
        pane.getChildren().add(button);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
