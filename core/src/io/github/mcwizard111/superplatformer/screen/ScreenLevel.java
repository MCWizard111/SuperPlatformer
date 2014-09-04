package io.github.mcwizard111.superplatformer.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import io.github.mcwizard111.superplatformer.SuperPlatformer;
import io.github.mcwizard111.superplatformer.entity.Player;

/**
 * Created by MCWizard111 on 9/4/2014.
 */
public class ScreenLevel extends ScreenAdapter {
    public SuperPlatformer game;
    public Byte[][] grid = new Byte[10][10];
    public OrthographicCamera camera;
    public ShapeRenderer renderer;
    public Player player;

    public ScreenLevel(SuperPlatformer game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false);
        renderer = new ShapeRenderer();
    }

    @Override
    public void show() {
        player = new Player(100, 100);
        Gdx.input.setInputProcessor(player);

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                if (y == 0) {
                    grid[y][x] = 1;
                } else {
                    grid[y][x] = 0;
                }
            }
        }
    }

    @Override
    public void render(float delta) {
        renderer.setProjectionMatrix(camera.combined);

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        renderer.begin(ShapeRenderer.ShapeType.Filled);

        for (int y = 0; y < grid.length; y++) {
            for (int x = 0; x < grid[y].length; x++) {
                renderer.setColor(getColor(grid[y][x]));
                renderer.box((x + 1) * 35, (y + 1) * 35, 0, 32, 32, 1);
            }
        }

        player.handleInput();
        player.update();
        player.render(renderer);

        renderer.end();
    }

    private Color getColor(Byte aByte) {
        switch (aByte) {
            case 0:
                return Color.BLUE;
            case 1:
                return Color.RED;
            default:
                return Color.GREEN;
        }
    }

    public boolean playerIntersects(int x, int y) {
        Rectangle playerRect = new Rectangle(player.x, player.y, 32, 32);
        Rectangle rectangle = new Rectangle((x + 1) * 35, (y + 1) * 35, 32, 32);

        if (rectangle.contains(playerRect)) {
            player.x = playerRect.x;
        }
        return false;
    }
}
