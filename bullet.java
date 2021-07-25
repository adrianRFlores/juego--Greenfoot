import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor
{
    private boolean cont = true;
    
    
    
    public void act() 
    {
        move(10);
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
        
    }
    
}
