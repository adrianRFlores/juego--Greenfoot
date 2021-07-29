import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class bulletM extends Actor
{
    private int vel = Greenfoot.getRandomNumber(7)+1; //Velocidad aleatoria dentro de un rango
    private int timer = 0;  
    public void act() 
    {
        timer++;
        if(timer == 10){ //Incrementa la velocidad de la bala
            vel++;
            timer = 0;
        }
        move(vel);
        
        if (isAtEdge())
        {
            getWorld().removeObject(this); //Revisa si se sale del mundo para eliminarlo
        }
    }   
}
