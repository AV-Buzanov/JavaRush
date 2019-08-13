package com.javarush.games.minesweeper;
import com.javarush.engine.cell.*;
import java.util.ArrayList;


public class MinesweeperGame extends Game {
    private static final int SIDE = 9;
    private GameObject[][] gameField = new GameObject[SIDE][SIDE];
    private int countMinesOnField = 0;
    private static final String MINE = "\uD83D\uDCA3";
    private static final String FLAG = "\uD83D\uDEA9";
    private int countFlags=0;
    public boolean openTileRecurs=false;

    
    //Устанавливаем размер экрана SIDExSIDE, вызываем createGame
    public void initialize() {
        setScreenSize(SIDE, SIDE);
        createGame();
    }
    
    //Создаем поле, вызываем countMineNeighbors
    private void createGame() {
        boolean mine = false;
        
        for (int i=0;i!=SIDE;i++)
        {
            for (int j=0;j!=SIDE;j++)
            {
                
                if (getRandomNumber(10)==5)
                {
                mine = true;
                countMinesOnField++;
                }
                else
                {
                mine = false;
                }
                
                gameField[j][i] = new GameObject(i,j,mine);
                setCellColor(i,j, Color.ORANGE);
            }
            
        }
        
        countMineNeighbors();
        countFlags=countMinesOnField;
    }
    
    //Считаем кол-во мин на соседних ячейках, заносим кол-во в соответствующий объект
    private void countMineNeighbors() {
        GameObject neighborsFromList = getNeighbors(gameField[0][0]).get(0);
        int counterOfMines=0;
         for (int i=0;i!=SIDE;i++) {
            for (int j=0;j!=SIDE;j++) {
                for (int k=0;k!=getNeighbors(gameField[j][i]).size();k++) {
                    if (gameField[j][i].isMine==false)
                    {
                    neighborsFromList = getNeighbors(gameField[j][i]).get(k);
                    if (neighborsFromList.isMine==true)
                    counterOfMines++;
                    }    
                    
                }
                gameField[j][i].countMineNeighbors=counterOfMines;
                counterOfMines=0;
                
            }
        }
        
        
        
        
    }
    
    //Возвращаем список соседей ячейки 
    public ArrayList<GameObject> getNeighbors(GameObject xxx) {
        ArrayList<GameObject> neighbors = new ArrayList<>();
        neighbors.clear();
        int x = xxx.x;
        int y = xxx.y;

        if (x==0&&y==0)
        {
            neighbors.add(gameField[y][x+1]);
            neighbors.add(gameField[y+1][x]);
            neighbors.add(gameField[y+1][x+1]);
        }
        
    
        
        if (x==0&&y==SIDE-1)
        {
            neighbors.add(gameField[y-1][x]);
            neighbors.add(gameField[y-1][x+1]);
            neighbors.add(gameField[y][x+1]);
        }
            
        
        
        if (x==0&&y!=0&&y!=SIDE-1)
        {
            neighbors.add(gameField[y][x+1]);
            neighbors.add(gameField[y-1][x]);
            neighbors.add(gameField[y-1][x+1]);
            neighbors.add(gameField[y+1][x]);
            neighbors.add(gameField[y+1][x+1]);
        }
                
        
        
        
        if (x==SIDE-1&&y==0)
        {
            neighbors.add(gameField[y][x-1]);
            neighbors.add(gameField[y+1][x]);
            neighbors.add(gameField[y+1][x-1]);
        }
        
        
        
        if (x==SIDE-1&&y==SIDE-1)
        {
            neighbors.add(gameField[y][x-1]);
            neighbors.add(gameField[y-1][x]);
            neighbors.add(gameField[y-1][x-1]);
        }
            
        
            
        if (x==SIDE-1&&y!=0&&y!=SIDE-1)
        {
            neighbors.add(gameField[y][x-1]);
            neighbors.add(gameField[y-1][x]);
            neighbors.add(gameField[y-1][x-1]);
            neighbors.add(gameField[y+1][x]);
            neighbors.add(gameField[y+1][x-1]);
        }
            
        

        if (y==0&&x!=0&&x!=SIDE-1)    
        {
            neighbors.add(gameField[y][x-1]);
            neighbors.add(gameField[y][x+1]);
            neighbors.add(gameField[y+1][x]);
            neighbors.add(gameField[y+1][x-1]);
            neighbors.add(gameField[y+1][x+1]);
        }
        
        
        
        if (y==SIDE-1&&x!=0&&x!=SIDE-1)
        {
            neighbors.add(gameField[y][x-1]);
            neighbors.add(gameField[y][x+1]);
            neighbors.add(gameField[y-1][x]);
            neighbors.add(gameField[y-1][x-1]);
            neighbors.add(gameField[y-1][x+1]);
        }
        
        if (y!=SIDE-1&&y!=0&&x!=SIDE-1&&x!=0)
        {
            neighbors.add(gameField[y][x-1]);
            neighbors.add(gameField[y][x+1]);
            neighbors.add(gameField[y-1][x]);
            neighbors.add(gameField[y-1][x-1]);
            neighbors.add(gameField[y-1][x+1]);
            neighbors.add(gameField[y+1][x]);
            neighbors.add(gameField[y+1][x-1]);
            neighbors.add(gameField[y+1][x+1]);
            
        }
        
        
        return neighbors;

    }
    
    private void openTile(int x, int y) {
        
        
         if (gameField[y][x].isMine) {
            setCellValue(x, y, MINE);
            gameField[y][x].isOpen = true;
            setCellColor(x, y, Color.GREEN);
        } else if (gameField[y][x].countMineNeighbors > 0 && !gameField[y][x].isMine){
            setCellNumber(x, y, gameField[y][x].countMineNeighbors);
            gameField[y][x].isOpen = true;
            setCellColor(x, y, Color.GREEN);
        } else if (gameField[y][x].countMineNeighbors == 0 && !gameField[y][x].isMine && !gameField[y][x].isOpen) {
            setCellValue(x, y, "");
            gameField[y][x].isOpen = true;
            setCellColor(x, y, Color.GREEN);
            ArrayList<GameObject> list = getNeighbors(gameField[y][x]);
            for(GameObject gameObject : list) {
                if (gameObject.countMineNeighbors == 0 && !gameObject.isMine && !gameObject.isOpen) {
                    openTile(gameObject.x, gameObject.y);
                }
            }
        }
        
       
    }
    
    public void onMouseLeftClick(int x, int y)
    {
        openTile(x,y);
    }
    
    
    
    
}
