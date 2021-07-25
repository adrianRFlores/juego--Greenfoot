import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class malvados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class malvados extends Actor
{
    private int rotation, cooldown;
    public void act() 
    {
        move(2);
        if (Greenfoot.getRandomNumber(100) <= 10)
        {
            turn(Greenfoot.getRandomNumber(180) - 45);
        }
        
        if(cooldown > 0) {
            cooldown -= 1;
        }
        
        if ((Greenfoot.getRandomNumber(1000) <= 20)  && (cooldown == 0))
        {
           getWorld().addObject(new bulletM(), getX(), getY());
           if (Greenfoot.getRandomNumber(1000) <= 20)
           {
               getWorld().addObject(new bulletM(), getX(), getY());
           }
           cooldown = 30;
        }
        
        checkCollisionM();
        
    }  
    
    public void checkCollisionM()
    {
        Actor bala = getOneIntersectingObject(bullet.class);
        if (bala != null)
        {
            getWorld().removeObject(this);
        }
    }
    
}
