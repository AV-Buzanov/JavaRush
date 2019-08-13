package com.javarush.games.snake;
import com.javarush.engine.cell.*;

public class SnakeGame extends Game{
    private int score;
    private static final int GOAL=28;
    private boolean isGameStopped;
    private int turnDelay;
    private Snake snake;
    private Apple apple;
    public static final int WIDTH=15;
    public static final int HEIGHT=15;

    @Override
    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive) {
            score+=5;
            setScore(score);
            turnDelay-=10;
            setTurnTimer(turnDelay);
            createNewApple();
        }
        if (!snake.isAlive)
            gameOver();
        if (snake.getLength()>GOAL)
            win();
        drawScene();
    }

    @Override
    public void initialize(){
        setScreenSize(WIDTH, HEIGHT);
        createGame();
    }
    
    private void createGame(){
        snake=new Snake(WIDTH/2, HEIGHT/2);
        //apple=new Apple(5,5);
        turnDelay = 300;
        setTurnTimer(turnDelay);
        createNewApple();
        isGameStopped=false;
        score=0;
        setScore(score);
        drawScene();
        //Apple apple = new Apple(7, 7);
        //apple.draw(this);
    }

    @Override
    public void onKeyPress(Key key) {
        switch (key){
            case DOWN:
                snake.setDirection(Direction.DOWN);
                break;
            case LEFT:
                snake.setDirection(Direction.LEFT);
                break;
            case RIGHT:
                snake.setDirection(Direction.RIGHT);
                break;
            case UP:
                snake.setDirection(Direction.UP);
                break;
            case SPACE:
                if (isGameStopped)
                    createGame();

        }
    }

    private void drawScene(){
        for (int i = 0; i<WIDTH; i++) {
            for (int j=0; j<HEIGHT;j++){
                setCellValueEx(i, j, Color.DARKSEAGREEN,"");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    private void createNewApple(){
        do {
            apple=new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        }
        while(snake.checkCollision(apple));

    }

    private void gameOver(){
        stopTurnTimer();
        isGameStopped=true;
        showMessageDialog(Color.NONE,"Game_Over!",Color.RED,75);
    }
    private void win(){
        stopTurnTimer();
        isGameStopped=true;
        showMessageDialog(Color.NONE,"YOU_WIN!",Color.GREEN,75);
    }


}