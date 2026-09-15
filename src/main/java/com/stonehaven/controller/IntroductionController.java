package com.stonehaven.controller;

import com.stonehaven.model.Player;
import com.stonehaven.view.IntroductionView;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IntroductionController {

    private final Stage stage;
    private final Player player;

    public IntroductionController(Stage stage, Player player) {
        this.stage = stage;
        this.player = player;
    }

    public void show() {

        IntroductionView view =
                new IntroductionView(this);

        Scene scene = new Scene(
                view.create(),
                800,
                600
        );

        stage.setScene(scene);
    }

    public void continueStory() {

        GameController controller =
                new GameController(stage, player);

        controller.show();
    }
}