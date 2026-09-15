package com.stonehaven.controller;

import com.stonehaven.view.CharacterCreationView;
import javafx.scene.Scene;
import javafx.stage.Stage;
import com.stonehaven.model.Player;

public class CharacterCreationController {

    private final Stage stage;
    private Player player;

    public CharacterCreationController(Stage stage) {
        this.stage = stage;
    }

    public void show() {

        CharacterCreationView view =
                new CharacterCreationView(this);

        Scene scene = new Scene(
                view.create(),
                800,
                600
        );

        stage.setScene(scene);
    }

    public void confirmName(String name) {

        player = new Player(name);

        IntroductionController controller =
                new IntroductionController(stage, player);

        controller.show();
    }
}