import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleScreen extends World
{
    Label titleLabel = new Label("The Elephant", 60);
    /**
     * Constructor for objects of class TitleScreen.
     * 
     */
    public TitleScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Label highestScoreLabel = new Label("Highest Score: " + MyWorld.getHighestScore(), 60);
        addObject(highestScoreLabel, getWidth() / 2, getHeight() / 2 + 25);

        
        prepare();
    }

    public void act()
    {
        if(Greenfoot.isKeyDown("space"))
        {
            MyWorld gameWorld = new MyWorld();
            Greenfoot.setWorld(gameWorld);
        }

    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        Elephant elephant = new Elephant();
        addObject(elephant,312,97);

        Label label = new Label("Press <space> to Start", 40);
        addObject(label,291,317);

        Label label2 = new Label("Use \u2190 and \u2192 to Move", 40);
        addObject(label2,290,376);

        Label label3 = new Label("Hungry Elephant", 60);
        addObject(label3,253,69);

      
        label.setLocation(329,320);
        label2.setLocation(320,366);
        
        elephant.setLocation(311,143);
        label3.setLocation(301,40);
    }
    
    public void highScore()
    {
        
    }
}
