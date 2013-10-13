package net.cniangel.gen.entity;

import net.cniangel.gen.Art;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Floor {

	Sprite tile = new Sprite();
	
	public Floor(float x, float y) {
		tile.set(new Sprite(Art.floor));
		tile.setBounds(x, y, 16, 16);
	}
	
	public void render(SpriteBatch b) {
		tile.draw(b);
	}

}
