package com.stonehaven.view;

import com.stonehaven.controller.MainMenuController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class MainMenuView {

    private final MainMenuController controller;

    public MainMenuView(MainMenuController controller) {
        this.controller = controller;
    }

    public VBox create() {

        Label title = new Label("STONEHAVEN");

        Button newGameButton = new Button("NOVO JOGO");
        Button exitButton = new Button("SAIR");

        newGameButton.setOnAction(event -> controller.startNewGame());

        exitButton.setOnAction(event -> controller.exitGame());

        VBox menu = new VBox(20);

        menu.setAlignment(Pos.CENTER);

        menu.getChildren().addAll(
                title,
                newGameButton,
                exitButton
        );

        return menu;
    }
}