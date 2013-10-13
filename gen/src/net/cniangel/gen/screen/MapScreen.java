package net.cniangel.gen.screen;

import java.util.ArrayList;

import net.cniangel.gen.GenGame;
import net.cniangel.gen.entity.Digger;
import net.cniangel.gen.entity.Floor;
import net.cniangel.gen.entity.Wall;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MapScreen implements Screen {

	GenGame game;
	SpriteBatch batch;
	ArrayList<Floor> tiles = new ArrayList<Floor>();
	ArrayList<Digger> diggers = new ArrayList<Digger>();
	ArrayList<Wall> walls = new ArrayList<Wall>();
	
	public MapScreen(GenGame game) {
		// TODO Auto-generated constructor stub
		this.game = game;
		this.batch = game.batch;
		
		// Just checking
		System.out.println("Map Screen Loaded");
		
		tiles.clear();
		diggers.clear();
		walls.clear();
		
		for (int i = 0; i < game.w / 16; i++) {
			for (int j = 0; j < game.h / 16; j++) {
				Wall wall = new Wall(i * 16, j * 16);
				walls.add(wall);
			}
		}
		
		for (int i = 0; i < 10; i++) {
			Digger digger = new Digger(this, game.w / 2, game.h / 2);
			diggers.add(digger);
		}
		
	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		if (Gdx.input.isKeyPressed(Keys.R)) {
			game.mapScreen = new MapScreen(game);
			game.setScreen(game.mapScreen);
		}
		
		for (Digger digger: diggers) {
			digger.update(delta);
		}
		
		batch.begin();
		for (Wall wall: walls) {
			wall.render(batch);
		}
		
		for (Floor floor: tiles) {
			floor.render(batch);
		}
		
		batch.end();
	}
	
	public void addFloor(float x, float y) {
		Floor floor = new Floor(x, y);
		tiles.add(floor);
	}

	@Override
	public void resize(int width, int height) {
	}
	@Override
	public void show() {
	}
	@Override
	public void hide() {
	}
	@Override
	public void pause() {
	}
	@Override
	public void resume() {
	}
	@Override
	public void dispose() {
	}
}
