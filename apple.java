import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class apple here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apple extends Actor
{
    /**
     * Act - do whatever the apple wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int speed = 1;
    public void act() 
    {
        // Add your action code here.
        setLocation(getX(), getY() + 3);
        int bottomY = getWorld().getHeight();
        if (getY() > bottomY)
        {
            MyWorld world = (MyWorld) getWorld();
            world.gameOver();
	    world.removeObject(this);
        }
    }
    
    public void setSpeed(int spd) 
    {
	speed = spd;
    }
}
