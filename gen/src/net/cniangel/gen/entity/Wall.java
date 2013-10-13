package net.cniangel.gen.entity;

import net.cniangel.gen.Art;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Wall {

	Sprite wall = new Sprite();
	
	public Wall(float x, float y) {
		// TODO Auto-generated constructor stub
		wall.set(new Sprite(Art.wall));
		wall.setBounds(x, y, 16, 16);
	}
	
	public void render (SpriteBatch b) {
		wall.draw(b);
	}

}
