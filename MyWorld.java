import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The World
 * 
 * @ Authour Herman Isayenka 
 * @version April 2024
 */
public class MyWorld extends World
{
    public int score = 0;
    Label scoreLabel;
    Label levelLabel;
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
        addObject(elephant, 300, 200);
        
        scoreLabel = new Label(0, 80);
        addObject(scoreLabel, 50, 50);
    
        createApple();
        
        levelLabel = new Label(0,80);
        addObject(levelLabel, 550,50);
        
        
    }
    
    public void gameOver()
    {
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
    }
    
    
    
    
    
    public void increaseScore()
    
    
    {
        score++;
        scoreLabel.setValue(score);
        
        
        
        if(score % 5 == 0)
        {
            level +=1;
            levelLabel.setValue(level);
            
        }
    }
    
    
    
    /**
     * Create a new apple at random location
     */
    public void createApple()
    {
        Apple apple = new Apple();
        apple.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple, x, y);
    }
}
