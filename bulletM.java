import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class bulletM extends Actor
{
    private boolean cont = true;
    public void act() 
    {
        if(cont)
        {
            setRotation(Greenfoot.getRandomNumber(360));
            cont = false;
        }
        
        move(5);
        
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }   
}
