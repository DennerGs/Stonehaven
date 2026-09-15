package com.stonehaven.view;

import com.stonehaven.model.Player;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;

public class GameView {

    private final PlayerView playerView;
    private final Player player;
    private Group world;

    private static final double ZOOM = 2.0;

    public GameView(Player player) {
        this.player = player;
        playerView = new PlayerView();
    }

    public void setDirection(int row) {
        playerView.setDirection(row);
    }

    public StackPane create() {

        Image mapImage = new Image(
                getClass().getResourceAsStream(
                        "/image/maps/gonlar_start.png"
                )
        );

        ImageView mapView = new ImageView(mapImage);

        world = new Group();

        world.getChildren().addAll(
                mapView,
                playerView.getImageView()
        );

        world.getTransforms().add(
                new Scale(ZOOM, ZOOM, 0, 0)        );

        StackPane game = new StackPane();

        game.setAlignment(Pos.TOP_LEFT);

        // Área visível do jogo
        game.setClip(new Rectangle(800, 600));

        player.setPosition(200, 200);

        game.getChildren().add(world);

        updatePlayerPosition();
        updateCamera();

        return game;
    }

    public void updatePlayerPosition() {

        playerView.getImageView().setTranslateX(player.getX());
        playerView.getImageView().setTranslateY(player.getY());

        updateCamera();
    }

    private void updateCamera() {

        if (world == null) {
            return;
        }

        double playerCenterX = player.getX() + 64;
        double playerCenterY = player.getY() + 64;

        double cameraX = 400 - (playerCenterX * ZOOM);
        double cameraY = 300 - (playerCenterY * ZOOM);

        world.setTranslateX(cameraX);
        world.setTranslateY(cameraY);
    }
}