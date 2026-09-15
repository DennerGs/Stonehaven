package com.stonehaven.view;

import com.stonehaven.controller.IntroductionController;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class IntroductionView {

    private final IntroductionController controller;

    public IntroductionView(IntroductionController controller) {
        this.controller = controller;
    }

    public VBox create() {

        Label title = new Label("STONEHAVEN");

        Label story = new Label(
                "Bem-vindo a Stonehaven.\n\n" +
                        "Seu pai está esperando por você..."
        );

        Button continueButton = new Button("CONTINUAR");

        continueButton.setOnAction(event ->
                controller.continueStory()
        );

        VBox layout = new VBox(20);

        layout.setAlignment(Pos.CENTER);

        layout.getChildren().addAll(
                title,
                story,
                continueButton
        );

        return layout;
    }
}