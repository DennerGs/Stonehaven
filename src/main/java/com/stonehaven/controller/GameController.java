package com.stonehaven.controller;

import com.stonehaven.model.Player;
import com.stonehaven.view.GameView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameController {

    private final Stage stage;
    private final Player player;
    private final CollisionSystem collisionSystem;

    public GameController(Stage stage, Player player) {
        this.stage = stage;
        this.player = player;
        this.collisionSystem = new CollisionSystem();
    }

    public void show() {

        GameView view = new GameView(player);

        Scene scene = new Scene(
                view.create(),
                800,
                600
        );

        stage.setScene(scene);

        scene.setOnKeyPressed(event -> {

            switch (event.getCode()) {

                case UP -> {

                    double newX = player.getX();
                    double newY = player.getY() - 5;

                    if (collisionSystem.canMove(newX, newY, 60, 60)) {
                        player.move(0, -5);
                    }

                    view.setDirection(3);
                }

                case DOWN -> {

                    double newX = player.getX();
                    double newY = player.getY() + 5;

                    if (collisionSystem.canMove(newX, newY, 60, 60)) {
                        player.move(0, 5);
                    }

                    view.setDirection(0);
                }

                case LEFT -> {

                    double newX = player.getX() - 5;
                    double newY = player.getY();

                    if (collisionSystem.canMove(newX, newY, 60, 60)) {
                        player.move(-5, 0);
                    }

                    view.setDirection(1);
                }

                case RIGHT -> {

                    double newX = player.getX() + 5;
                    double newY = player.getY();

                    if (collisionSystem.canMove(newX, newY, 60, 60)) {
                        player.move(5, 0);
                    }

                    view.setDirection(2);
                }
            }

            view.updatePlayerPosition();
        });
    }
}