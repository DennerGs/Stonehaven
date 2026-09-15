package com.stonehaven;

import com.stonehaven.controller.MainMenuController;
import com.stonehaven.view.MainMenuView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StonehavenApp extends Application {

    @Override
    public void start(Stage stage) {

        MainMenuController controller = new MainMenuController(stage);

        MainMenuView mainMenuView = new MainMenuView(controller);

        Scene scene = new Scene(
                mainMenuView.create(),
                800,
                600
        );

        stage.setTitle("Stonehaven");
        stage.setScene(scene);
        stage.show();
    }
}