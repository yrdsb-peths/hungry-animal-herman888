import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant, Hero
 * 
 * @Herman Isayenka April 2024
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    private int speed = 2;
    GreenfootSound elephantSound = new GreenfootSound("elephantcub.mp3");
    GreenfootSound elephantSound1 = new GreenfootSound("elephantdefeat.mp3");
    GreenfootImage[] idleRight = new GreenfootImage[7];
    GreenfootImage[] idleLeft = new GreenfootImage[7];
    
    
    
    String facing = "right";
    
    SimpleTimer animationTimer = new SimpleTimer();
    public Elephant()
    {
        for(int i = 0; i < idleRight.length; i++)
        {
            idleRight[i] = new GreenfootImage("images/elephantIdle/idle" + i + ".png");
            idleRight[i].scale(100,100);
        }
        for(int i = 0; i < idleLeft.length; i++)
        {
            idleLeft[i] = new GreenfootImage("images/elephantIdle/idle" + i + ".png");
            idleLeft[i].mirrorHorizontally();
            idleLeft[i].scale(100,100);
        }
        animationTimer.mark();
        setImage(idleRight[0]);
    }
    int imageIndex = 0;
    public void animateElephant()
    {
        if(animationTimer.millisElapsed() < 300)
        {
            return;
        }
        animationTimer.mark();
        if(facing.equals("right"))
        {
            setImage(idleRight[imageIndex]);
            imageIndex = (imageIndex + 1) % idleRight.length;
        }
        else
        {
            setImage(idleLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % idleLeft.length;
        }
            
        
    }
  
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-speed);
            facing = "left";
        }
        else if(Greenfoot.isKeyDown("right"))
        {
            move(speed);
            facing = "right";
        }
        
        if (Greenfoot.mouseClicked(null))
        {
            MouseInfo mouse = Greenfoot.getMouseInfo();
            if (mouse != null)
            {
                int mouseX = mouse.getX();
                if (mouseX < getX())
                {
                    move(-speed);
                    facing = "left";
                }
                else if (mouseX > getX())
                {
                    move(speed);
                    facing = "right";
                }
            }
        }
        
        eat();
        
        animateElephant();
       
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
        
        if(isTouching(Banana.class))
        {
            eatBanana();
            removeTouching(Banana.class);
            MyWorld world = (MyWorld) getWorld();
            world.increaseScore();
            elephantSound.play();
        }
        
        if(isTouching(Apple2.class))
        {   
            elephantSound1.play();
        
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
            
        }
    }
    
    private void eatBanana()
    {
        MyWorld world = (MyWorld) getWorld();
        int currentLevel = world.getLevel();
        
        
        speed = 2 * currentLevel;
        
       
    }
    
   
}
