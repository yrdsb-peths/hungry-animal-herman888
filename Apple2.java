import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Apple2 class for the game.
 * 
 * @herman 
 * @version April 2024
 */
public class Apple2 extends Actor
{
    private int speed = 1;

    /**
     * Act - do whatever the Apple2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int y = getY() + speed;
        setLocation(x, y);
        
        if (getY() >= getWorld().getHeight())
        {
            getWorld().removeObject(this);
        }
    }

    public void setSpeed(int spd)
    {
        speed = spd;
    }
}