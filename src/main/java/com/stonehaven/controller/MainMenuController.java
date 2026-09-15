package com.stonehaven.controller;

import javafx.stage.Stage;

public class MainMenuController {

    private final Stage stage;

    public MainMenuController(Stage stage) {
        this.stage = stage;
    }

    public void startNewGame() {

        CharacterCreationController controller =
                new CharacterCreationController(stage);

        controller.show();
    }

    public void exitGame() {
        stage.close();
    }
}