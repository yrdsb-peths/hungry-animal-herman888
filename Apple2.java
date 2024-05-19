import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Apple2 food
 * 
 * @herman 
 * @version April 2024
 */
public class Apple2 extends Actor
{
    int speed = 1;
    int scoreValue;
    

    /**
     * Act - do whatever the Apple2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        MyWorld world = (MyWorld) getWorld();
        if (getY() >= world.getHeight())
        {
            world.gameOver();
            world.removeObject(this);
        }
    }

    public int getScoreValue()
    {
        return scoreValue;
    }
}