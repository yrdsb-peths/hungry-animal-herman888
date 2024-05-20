import greenfoot.*;

/**
 * The World
 * 
 * @ Authour Herman Isayenka 
 * @version April 2024
 */
public class MyWorld extends World
{
    public static int highestScore = 0;
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
        
       
        
        levelLabel = new Label(1,80);
        addObject(levelLabel, 550,50);
    }
    
    public void gameOver()
    {
        
        if (score > highestScore)
        {
            highestScore = score;
        }
        
        Label gameOverLabel = new Label("Game Over", 100);
        addObject(gameOverLabel, 300, 200);
        
        Greenfoot.stop();
        
        Greenfoot.delay(100); 
        
        Greenfoot.setWorld(new TitleScreen());
    }
    
    public void increaseScore() 
    {
        score++;
        scoreLabel.setValue(score);
        
        if (score % 7 == 0) 
        {   
            createApple2();
        }

        if (score % 5 == 0) 
        {
            level+=1;
            levelLabel.setValue(level);
            createBanana();
        }
    }      
    public void createApple2()
    {
        Apple2 apple2 = new Apple2();
        apple2.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(apple2, x, y);
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
    
    public void createRandomApple()
    {
        int randomNumber = Greenfoot.getRandomNumber(2); // Random number between 0 and 1
        Actor fruit; 
    
        if (randomNumber == 0) 
        {   
            fruit = new Apple();
        } 
        else
        {
           fruit = new Banana(); 
        }
        
        

    
        //fruit.setSpeed(level); // Set speed based on the level
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(fruit, x, y); // Add the fruit to the world
    }
    
    public void createBanana()
    {
        Banana banana = new Banana();
        banana.setSpeed(level);
        int x = Greenfoot.getRandomNumber(600);
        int y = 0;
        addObject(banana, x, y);
    }
    
    public int getLevel()
    {
        return level;
    }
    
    public static int getHighestScore()
    {
        return highestScore;
    }
    
}