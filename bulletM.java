import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class bulletM extends Actor
{
    private int vel = Greenfoot.getRandomNumber(7)+1;
    private int timer = 0;  
    public void act() 
    {
        timer++;
        if(timer == 10){
            vel++;
            timer = 0;
        }
        move(vel);
        
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
    }   
}
