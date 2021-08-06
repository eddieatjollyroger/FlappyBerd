package com.hackathon.ZBHelpers;

import com.badlogic.gdx.InputProcessor;
import com.hackathon.GameObjects.Bird;
import com.hackathon.GameWorld.GameWorld;

public class InputHandler implements InputProcessor {
	private Bird myBird;
	private GameWorld myWorld;

	// Ask for a reference to the Bird when InputHandler is created.
	public InputHandler(GameWorld myWorld) {
		// myBird now represents the gameWorld's bird.
		this.myWorld = myWorld;
		myBird = myWorld.getBird();
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {

		if (myWorld.isReady()) {
			myWorld.start();
		}

		myBird.onClick();

		if (myWorld.isGameOver()) {
			// Reset all variables, go to GameState.READ
			myWorld.restart();
		}

		return true;
	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float x, float y) {
		return false;
	}

}
