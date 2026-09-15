package com.stonehaven.view;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayerView {

    private final ImageView imageView;

    private static final int FRAME_SIZE = 64;

    public PlayerView() {

        Image spriteSheet = new Image(
                getClass().getResourceAsStream(
                        "/image/player/player_sprite.png"
                )
        );

        System.out.println("Largura: " + spriteSheet.getWidth());
        System.out.println("Altura: " + spriteSheet.getHeight());

        imageView = new ImageView(spriteSheet);

        // Primeiro frame: olhando para baixo
        imageView.setViewport(
                new Rectangle2D(
                        0,
                        0,
                        FRAME_SIZE,
                        FRAME_SIZE
                )
        );

        // Tamanho visual do personagem
        imageView.setFitWidth(60);
        imageView.setFitHeight(60);

        imageView.setSmooth(false);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setDirection(int row) {

        imageView.setViewport(
                new Rectangle2D(
                        0,
                        row * FRAME_SIZE,
                        FRAME_SIZE,
                        FRAME_SIZE
                )
        );
    }
}