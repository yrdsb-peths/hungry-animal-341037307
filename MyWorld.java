import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    
    
    SimpleTimer timeClass = new SimpleTimer();
    boolean rythmMode = false;
    boolean gameEnded = false;
    
    public static int score = 0;
    public Label scoreLabel;
    int level = 1;

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false);
        
        
        Elephant elephant = new Elephant();
        addObject(elephant, 300, 300);
        
        scoreLabel = new Label(0, 70);
        addObject(scoreLabel, 20, 20);
        
        timeClass.mark();
        spawnApple();
        score = 0;
    }
    public void act()
    {   
        if (timeClass.millisElapsed() > 500 && rythmMode)
        {
            spawnApple();
            timeClass.mark();
        }
        
        if (gameEnded == true && Greenfoot.isKeyDown("space"))
        {
            gameEnded = false;
            spawnApple();
            //timeClass.mark();
        }
    }

    public void increaseScore()
    {
        score += 1;
        scoreLabel.setValue(score);
    
        if(score % 5 == 0)
        {
            level += 1;
        }
    }
    public void gameOver()
    {
        Label gameOverLabel = new Label("Space to Restart", 100);
        addObject(gameOverLabel, getWidth()/2, getHeight()/2);
        Label subtext = new Label("Subtext", 80);
        addObject(gameOverLabel, getWidth()/3, getHeight()/3);
        gameEnded = true;
    }    

    public void spawnApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = (Greenfoot.getRandomNumber(4)+1)*100;
        int y = 0;
        addObject(apple, x, y);
    }
}
