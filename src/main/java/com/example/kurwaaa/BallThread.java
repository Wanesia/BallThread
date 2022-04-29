package com.example.kurwaaa;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BallThread extends Thread{
    Random rand = new Random();

    Circle testBall=new Circle();
    double dx = 5;
    double dy = 5;
    ArrayList<Circle> balls = new ArrayList<Circle>();
    Boolean decision=false;
    BallMethods ballMethodsStart = new BallMethods();



    public void run() {
        while(true) {
            System.out.println("Threads: "+Thread.activeCount());
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (Thread.interrupted()) {
                return;
            }
        }
    }


    public void setBall(Pane pane){
        Circle ball=new Circle();
        ball.setFill(Color.DARKCYAN);

        ball.setCenterX(rand.nextInt(50,100));
        ball.setCenterY(rand.nextInt(50,100));
        ball.setRadius(rand.nextInt(20,30));


        pane.getChildren().add(ball);
        for(Circle ballInArray:balls){
            System.out.println(ballInArray.toString());
            System.out.println("array size: "+balls.size());
        }


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(20),
                new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent t) {
                        //move the ball
                        ball.setLayoutX(ball.getLayoutX() + dx);
                        ball.setLayoutY(ball.getLayoutY() + dy);



                        Bounds bounds = pane.getBoundsInLocal();

                        double xMin = ball.getBoundsInParent().getMinX();
                        double yMin = ball.getBoundsInParent().getMinY();
                        double xMax = ball.getBoundsInParent().getMaxX();
                        double yMax = ball.getBoundsInParent().getMaxY();
                        if(true){
                            ballMethodsStart.ballMethodsStart();
                        }

                        // Collision - boundaries
                        if (xMin < 0 || xMax > pane.getWidth()) {
                            dx = dx * -1;
                        }
                        if (yMin < 0 || yMax > pane.getHeight()) {
                            dy = dy * -1;
                        }

                        ball.setTranslateX(ball.getTranslateX() + dx);
                        ball.setTranslateY(ball.getTranslateY() + dy);


                    }

                }));

        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
