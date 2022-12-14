

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Elephant.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Elephant extends Actor
{

    GreenfootSound elephantSound = new GreenfootSound("sounds/elephantcub.mp3");
    SimpleTimer animTimer = new SimpleTimer();
    GreenfootImage[] idleRight = new GreenfootImage[8];
    GreenfootImage[] idleLeft = new GreenfootImage[8];

    String facing = "right";

    public Elephant(){
        
	for (int i = 0; i < idleRight .length; i++)
	{
	    idleRight[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
	    idleRight[i].scale(80, 80);

	    idleLeft[i] = new GreenfootImage("images/elephant_idle/idle" + i + ".png");
	    idleLeft[i].mirrorHorizontally();
	    idleLeft[i].scale(80, 80);
	}
	idleLeft[i].scale(80, 80);
	animTimer.mark();
    }
    

    /**
     * Act - do whatever the Elephant wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 

    {
        GreenfootSound elephantSound = new GreenfootSound("sounds/elephantcub.mp3");
        elephantSound.play();
        // Add your action code here.
        if (Greenfoot.isKeyDown("d")) {
            move(25);
	    facing = "right";
        }
        if (Greenfoot.isKeyDown("a")) {
            move(-25);
	    facing = "left";
        }
        
        if (Greenfoot.isKeyDown("z")) {
            setLocation(100, getY());
            
            
        }
        else if (Greenfoot.isKeyDown("x")) {
            setLocation(200, getY());
        }
        else if (Greenfoot.isKeyDown("c")) {
            setLocation(300, getY());
        }
        else if (Greenfoot.isKeyDown("v")) {
            setLocation(400, getY());
        }
        else
        {
            //setLocation(600, getY());
        }
        //
        
        eat();
	animate();
    }    

    /* 
     * Animates its default animation
     */

    int i = 0;
    public void animate()
    {
	// function here
	
        if (animTimer.millisElapsed() > 200)
        {
	    if(facing.equals("right"))
	    {
		setImage(idleRight[i]);
		i = (i + 1) % idleRight.length;
	    }
	    else
	    {
		setImage(idleLeft[i]);
		i = (i + 1) % idleLeft.length;
	    }

	    
	    animTimer.mark();
	}
    }

    /* 
     * Elephant eats apple when it makes contact
     */
    public void eat()
    {
        if (isTouching(Apple.class)){
            removeTouching(Apple.class);
            
            MyWorld world = (MyWorld) getWorld();
            //world.spawnApple();
            world.increaseScore();
            elephantSound.play();
        }
    }
}
