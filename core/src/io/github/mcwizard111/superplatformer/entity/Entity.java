package io.github.mcwizard111.superplatformer.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by MCWizard111 on 9/4/2014.
 */
public abstract class Entity extends InputAdapter {
    public float x, y;
    public static float speedMultiplier = 1;

    public Entity(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void update() {
        y -= 7 * Gdx.graphics.getDeltaTime();
    }

    public void handleInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.SHIFT_LEFT) || Gdx.input.isKeyPressed(Input.Keys.SHIFT_RIGHT)) {
            speedMultiplier = 3;
        } else {
            speedMultiplier = 1;
        }

        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            x += 5 * speedMultiplier;
        } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            x -= 5 * speedMultiplier;
        }
    }

    public void render(ShapeRenderer renderer) {
        renderer.setColor(Color.ORANGE);
        renderer.box(x, y, 0, 32, 32, 1);
    }
}
