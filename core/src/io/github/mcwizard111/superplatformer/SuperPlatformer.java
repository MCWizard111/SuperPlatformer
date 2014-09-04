package io.github.mcwizard111.superplatformer;

import com.badlogic.gdx.Game;
import io.github.mcwizard111.superplatformer.screen.ScreenLevel;

public class SuperPlatformer extends Game {
    public ScreenLevel screenLevel;

    @Override
    public void create() {
        screenLevel = new ScreenLevel(this);

        setScreen(screenLevel);
    }
}
