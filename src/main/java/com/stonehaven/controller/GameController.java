package com.stonehaven.controller;

import com.stonehaven.model.Player;
import com.stonehaven.view.GameView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameController {

    private final Stage stage;
    private final Player player;

    public GameController(Stage stage, Player player) {
        this.stage = stage;
        this.player = player;
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
                    player.move(0, -5);
                    view.setDirection(3);
                }

                case DOWN -> {
                    player.move(0, 5);
                    view.setDirection(0);
                }

                case LEFT -> {
                    player.move(-5, 0);
                    view.setDirection(1);
                }

                case RIGHT -> {
                    player.move(5, 0);
                    view.setDirection(2);
                }
            }

            view.updatePlayerPosition();
        });
    }
}