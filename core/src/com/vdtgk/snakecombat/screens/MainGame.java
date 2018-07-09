package com.vdtgk.snakecombat.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;

public class
MainGame extends Game{

	@Override
	public void create() {
		
		setScreen(new MyGdxGame(this));
		//setScreen(new GameOver());
		
	}

	@Override
	public void render(){
		super.render();
		
	}
	
	@Override
	public void dispose(){
		
		
	}
	
	public void newScreen(int screenID){
		
		switch (screenID) {
		case 0:
			setScreen((Screen) new GameOver(this));
			break;

		default:
			break;
		}
		
	}

}
