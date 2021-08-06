package com.hackathon.ZBHelpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AssetLoader {

	public static Texture texture;
	public static TextureRegion bg, grass;
	public static Texture wheelTexture;
	public static Texture backgroundTexture;
	public static Texture streetTexture;

	public static Animation birdAnimation;
	public static TextureRegion bird, birdDown, birdUp;

	public static TextureRegion skullUp, skullDown, bar;

	public static Sound dead, flap, coin;

	public static BitmapFont font, shadow;

	private static Preferences prefs;

	public static void load() {

		texture = new Texture(Gdx.files.internal("data/texture.png"));
		texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);

		backgroundTexture = new Texture(Gdx.files.internal("test5.png"));

		wheelTexture = new Texture(Gdx.files.internal("chico.png"));

		streetTexture = new Texture(Gdx.files.internal("street3.png"));

		bg = new TextureRegion(backgroundTexture, 0, 0, 768, 1024);
		bg.flip(false, true);

		grass = new TextureRegion(streetTexture, 0, 0, 143, 11);
		grass.flip(false, true);

		birdDown = new TextureRegion(wheelTexture, 0, 0, 270, 185);
		birdDown.flip(false, true);

		bird = new TextureRegion(wheelTexture, 0, 0, 270, 185);
		bird.flip(false, true);

		birdUp = new TextureRegion(wheelTexture, 0, 0, 270, 185);
		birdUp.flip(false, true);

		TextureRegion[] birds = { birdDown, bird, birdUp };
		birdAnimation = new Animation(0.06f, birds);
		birdAnimation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);

		skullUp = new TextureRegion(texture, 192, 0, 24, 14);
		// Create by flipping existing skullUp
		skullDown = new TextureRegion(skullUp);
		skullDown.flip(false, true);

		bar = new TextureRegion(texture, 136, 16, 22, 3);
		bar.flip(false, true);

		dead = Gdx.audio.newSound(Gdx.files.internal("WW_Bomb_Blow.wav"));
		flap = Gdx.audio.newSound(Gdx.files.internal("WW_Link_Hop3.wav"));
		coin = Gdx.audio.newSound(Gdx.files.internal("WW_Get_Heart.wav"));

		font = new BitmapFont(Gdx.files.internal("data/text.fnt"));
		font.getData().setScale(.25f, -.25f);
		shadow = new BitmapFont(Gdx.files.internal("data/shadow.fnt"));
		shadow.getData().setScale(.25f, -.25f);

		// Create (or retrieve existing) preferences file
		prefs = Gdx.app.getPreferences("RodaViva");

		if (!prefs.contains("highScore")) {
			prefs.putInteger("highScore", 0);
		}
	}

	public static void setHighScore(int val) {
		prefs.putInteger("highScore", val);
		prefs.flush();
	}

	public static int getHighScore() {
		return prefs.getInteger("highScore");
	}

	public static void dispose() {
		// We must dispose of the texture when we are finished.
		texture.dispose();
		backgroundTexture.dispose();
		wheelTexture.dispose();
		// Dispose sounds
		dead.dispose();
		flap.dispose();
		coin.dispose();

		font.dispose();
		shadow.dispose();
	}

}