package com.stonehaven.controller;

import javafx.geometry.Rectangle2D;

import java.util.ArrayList;
import java.util.List;

public class CollisionSystem {

    private final List<Rectangle2D> collisions;

    public CollisionSystem() {

        collisions = new ArrayList<>();

        createMapCollisions();
    }

    private void addCollision(
            double x,
            double y,
            double width,
            double height
    ) {

        collisions.add(
                new Rectangle2D(
                        x,
                        y,
                        width,
                        height
                )
        );
    }

    public boolean canMove(
            double x,
            double y,
            double width,
            double height
    ) {

        Rectangle2D playerBounds =
                new Rectangle2D(
                        x,
                        y,
                        width,
                        height
                );

        for (Rectangle2D collision : collisions) {

            if (playerBounds.intersects(collision)) {
                return false;
            }
        }

        return true;
    }

    private void createMapCollisions() {

        createTreeCollisions();
        createRockCollisions();
        createHouseCollisions();
    }

    private void createTreeCollisions() {

        addCollision(500, 365, 40, 20);
    }

    private void createRockCollisions() {

    }

    private void createHouseCollisions() {
        addCollision(350, 375, 40, 60);
        addCollision(420, 375, 50, 60);
    }
}