import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class obstacle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class obstacle extends Actor
{
    private int rotation;
    public void act() 
    {
        setRotation(rotation);
        move(5);
        if (Greenfoot.getRandomNumber(100) >= 50)
        {
            turn(Greenfoot.getRandomNumber(180));
            rotation = getRotation();
            setRotation(0);
        }
        else
        {
            turn( - Greenfoot.getRandomNumber(180)); 
            rotation = getRotation();
            setRotation(0);
        }
        
        Actor bala, nave;
        bala = getOneIntersectingObject(Bullet.class);
        nave = getOneIntersectingObject(Player.class);
        if (bala != null)
        {
            getWorld().removeObject(bala);
        }
        
    }    
}
