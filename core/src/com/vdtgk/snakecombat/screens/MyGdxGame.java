package com.vdtgk.snakecombat.screens;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.vdtgk.snakecombat.utils.Food;
import com.vdtgk.snakecombat.utils.LeftBox;
import com.vdtgk.snakecombat.utils.MySnake;
import com.vdtgk.snakecombat.utils.RightBox;
import com.vdtgk.snakecombat.utils.ScoreBoard;


public class MyGdxGame implements Screen{
	MySnake snake;
	Food food;
	LeftBox leftBox;
	RightBox rightBox;
	ScoreBoard scoreBoard;
	public static MainGame mainGame;


	public MyGdxGame(MainGame mainGame){
		
		this.mainGame = mainGame;
		snake = new MySnake();
		snake.setColor(Color.YELLOW);
		food = new Food();
		leftBox = new LeftBox();
		rightBox = new RightBox();
		scoreBoard = new ScoreBoard();
		
		System.out.println("Snake start pozition = "+ snake.pozition[0][0]+"-"+snake.pozition[0][1]);
		System.out.println("Food start pozition = "+ food.pozition[0]+"-"+food.pozition[1]);

		


	}

	@Override
	public void render(float delta) {

		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		
		//ekrandaki hareket butonları
		leftBox.leftBox();
		rightBox.rigthBox();
		
		//scoreboard
		scoreBoard.stage.draw();
		
		//yemek ve yılan çizdirme
		food.getFood();
		snake.paintSnake();
		
		snake.rotation();
		Gdx.input.setInputProcessor(snake);
		
		//yeme kontrolü
		if(food.pozition[0] == snake.pozition[0][0] && food.pozition[1] == snake.pozition[0][1]){
			food.getNewFood();
			snake.length++;
			
			scoreBoard.updateScore();
		
		}
		
		//oyun biterse GameOver class ı çağıralacak
		if(snake.isStroke){
			mainGame.setScreen(new GameOver(mainGame));
		}


	}

	

	
	

	@Override
	public void dispose () {

		snake.dispose();
		food.dispose();
		leftBox.dispose();
		rightBox.dispose();

	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

}
