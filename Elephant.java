import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{
    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("d")) {
            move(2);
        }
        if (Greenfoot.isKeyDown("a")) {
            move(-2);
        }
    }    
    
    public void eat()
    {
        if (isTouching(Apple.class)){
            removeTouching(Apple.class);
            
            MyWorld world = (MyWorld) getWorld();
            world.spawnApple;
        }
