package net.cniangel.gen;

import net.cniangel.gen.screen.MapScreen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GenGame extends Game {
	public OrthographicCamera camera;
	public SpriteBatch batch;
	public float w;
	public float h;
	public MapScreen mapScreen;
	public Input input;
	
	
	@Override
	public void create() {		
		Texture.setEnforcePotImages(false);
		w = Gdx.graphics.getWidth();
		h = Gdx.graphics.getHeight();
		
		Art.loadAll();
		input = new Input();
		Gdx.input.setInputProcessor(input);
		
		camera = new OrthographicCamera(1, h/w);
		batch = new SpriteBatch();
		
		
		
		if (mapScreen == null) mapScreen = new MapScreen(this);
		setScreen(mapScreen);
	}

	@Override
	public void dispose() {
		super.render();
		batch.dispose();
	}

	@Override
	public void render() {		
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}
