package net.cniangel.gen.entity;

import java.util.Random;

import net.cniangel.gen.screen.MapScreen;

import com.badlogic.gdx.math.Vector2;

public class Digger {

	// TODO: Comment my code
	
	MapScreen map;
	Vector2 position = new Vector2();
	boolean isDead;
	Random rand = new Random();
	int life, dir, chances;
	float originX, originY;
	
	public Digger(MapScreen map, float spawnX, float spawnY) {
		this.map = map;
		position.set(spawnX, spawnY);
		originX = spawnX; originY = spawnY;
		life = rand.nextInt(11) + 5;
		chances = rand.nextInt(3) + 2;
		System.out.println("Digger Spawned");
	}
	
	public void update(float delta) {
		if (isDead != true) {
			map.addFloor(position.x, position.y);
			dir = rand.nextInt(4);
			switch (dir) {
			case 0: position.x += 16; break;
			case 1: position.y -= 16; break;
			case 2: position.x -= 16; break;
			case 3: position.y += 16; break;
			}
			life--;
		}
		
		if (life <= 0) {
			isDead = true;
			if (chances != 0) {
				if (rand.nextFloat() < 0.45f) {
					chances--;
					isDead = false;
					life = rand.nextInt(7) + 3;
					System.out.println("DIGGER REZZED!");
				}
			}
		}
		
	}

}
