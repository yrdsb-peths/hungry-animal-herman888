import greenfoot.*;

/**
 * A banana actor.
 * 
 * @author [Your Name]
 * @version [Date]
 */
public class Banana extends Actor
{
    int speed = 1; // Default speed

    /**
     * Act - do whatever the Banana wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Move the banana downwards
        setLocation(getX(), getY() + speed);
        
        // Check if the banana is at the bottom of the world
        if (getY() >= getWorld().getHeight())
        {
            // If so, remove the banana from the world
            getWorld().removeObject(this);
        }
    }

    /**
     * Set the speed of the banana.
     * 
     * @param spd The speed to set.
     */
    public void setSpeed(int spd)
    {
        speed = spd;
    }
}

