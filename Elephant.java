import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, Hero
 * 
 * @Herman Isayenka April 2024
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    public Elephant()
    {
        setImage(idle);
    }
    
    
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootImage idle = new GreenfootImage("images/elephant_idle/idle0.png");
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-1);
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(1);
        }
        
        eat();
       
    }
    
    public void eat()
    {
        if(isTouching(Apple.class))
        {
            removeTouching(Apple.class);
            MyWorld world = (MyWorld) getWorld();
            world.createApple();
            world.increaseScore();
            elephantSound.play();
        }
        
        
    }
}
