package com.javarush.games.snake;
import com.javarush.engine.cell.*;
import java.util.*;
public class Snake {
    private Direction direction = Direction.LEFT;
    public boolean isAlive=true;
    private static final String HEAD_SIGN= "\uD83D\uDC7E";
    private static final String BODY_SIGN= "\u26AB";
    private List<GameObject> snakeParts = new ArrayList<>();
    public Snake(int x, int y) {
        GameObject go1 = new GameObject(x, y);
        GameObject go2 = new GameObject(x+1, y);
        GameObject go3 = new GameObject(x+2, y);
        snakeParts.add(go1);
        snakeParts.add(go2);
        snakeParts.add(go3);
    }
    public void move(Apple apple){
        GameObject go =createNewHead();
        if (go.x>=SnakeGame.WIDTH||go.x<0||go.y>=SnakeGame.HEIGHT||go.y<0){
            isAlive=false;
        return;}
        if (checkCollision(go)) {
            isAlive = false;
            return;
        }


         if (go.x==apple.x&&go.y==apple.y) {
            apple.isAlive=false;
            snakeParts.add(0, go);
        }

            else {
            snakeParts.add(0, go);
            removeTail();
        }

    }

    public void draw(Game game){
        for(GameObject go:snakeParts){
            if (snakeParts.indexOf(go)==0)
                if(isAlive)
            game.setCellValueEx(go.x,go.y,Color.NONE,HEAD_SIGN, Color.BLACK, 75);
                else
                    game.setCellValueEx(go.x,go.y,Color.NONE,HEAD_SIGN, Color.RED, 75);

            else
            if(isAlive)
                game.setCellValueEx(go.x,go.y,Color.NONE,BODY_SIGN, Color.BLACK, 75);
            else
                game.setCellValueEx(go.x,go.y,Color.NONE,BODY_SIGN, Color.RED, 75);

        }
    }

    public GameObject createNewHead(){
        GameObject go;
        switch (direction) {
            case DOWN:
                    go = new GameObject((snakeParts.get(0).x),(snakeParts.get(0).y)+1);
                    break;
            case LEFT:
                go = new GameObject((snakeParts.get(0).x)-1,(snakeParts.get(0).y));
                break;
            case UP:
                go = new GameObject(snakeParts.get(0).x,(snakeParts.get(0).y)-1);
                break;
            case RIGHT:
                go = new GameObject((snakeParts.get(0).x)+1,snakeParts.get(0).y);
                break;
                default:go = new GameObject((snakeParts.get(0).x),snakeParts.get(0).y);
        }
        return go;
    }

    public void removeTail(){
        snakeParts.remove(snakeParts.size()-1);
    }

    public void setDirection(Direction dir){
        if ((dir==Direction.UP&&direction!=Direction.DOWN)
                ||(dir==Direction.LEFT&&direction!=Direction.RIGHT)
                || (dir==Direction.DOWN&&direction!=Direction.UP)
                ||(dir==Direction.RIGHT&&direction!=Direction.LEFT)) {
            if ((direction == Direction.UP && snakeParts.get(0).y != snakeParts.get(1).y)||
                    (direction == Direction.DOWN && snakeParts.get(0).y != snakeParts.get(1).y)||
                    (direction == Direction.LEFT && snakeParts.get(0).x != snakeParts.get(1).x)||
                    (direction == Direction.RIGHT && snakeParts.get(0).x != snakeParts.get(1).x))
                this.direction = dir;
        }

    }
    public boolean checkCollision(GameObject go){
        for (GameObject gob:snakeParts){
            if (go.x==gob.x&&go.y==gob.y)
                return true;
        }
        return false;
    }

    public int getLength(){
        return snakeParts.size();
    }
    
}