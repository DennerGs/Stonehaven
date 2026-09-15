package com.stonehaven.view;

import com.stonehaven.controller.CharacterCreationController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class CharacterCreationView {

    private final CharacterCreationController controller;

    public CharacterCreationView(CharacterCreationController controller) {
        this.controller = controller;
    }

    public VBox create() {

        Label title = new Label("STONEHAVEN");

        Label question = new Label("Qual é o seu nome?");

        TextField nameField = new TextField();
        nameField.setPromptText("Digite seu nome");

        Button confirmButton = new Button("CONFIRMAR");

        confirmButton.setOnAction(event -> {

            String name = nameField.getText();

            controller.confirmName(name);
        });

        VBox layout = new VBox(20);

        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(
                title,
                question,
                nameField,
                confirmButton
        );

        return layout;
    }
}