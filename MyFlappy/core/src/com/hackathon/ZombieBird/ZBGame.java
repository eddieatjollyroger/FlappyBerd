package com.hackathon.ZombieBird;

import com.badlogic.gdx.Game;
import com.hackathon.Screens.GameScreen;
import com.hackathon.ZBHelpers.AssetLoader;

public class ZBGame extends Game {

    @Override
    public void create() {
        System.out.println("ZBGame Created!");
        AssetLoader.load();
        setScreen(new GameScreen());
    }

    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }

}