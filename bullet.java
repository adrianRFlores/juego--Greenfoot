import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// Bala del jugador
public class Bullet extends Actor
{
    public void act() 
    {
        move(10); //Velocidad estandar
        if (isAtEdge())
        {
            getWorld().removeObject(this); //Si la bala se sale del mundo, se elimina
        }
        
    }
    
}
