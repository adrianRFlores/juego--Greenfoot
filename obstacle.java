import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//obstáculo que bloquea balas y hace daño
public class obstacle extends Actor
{
    private int rotation;
    public void act() 
    {
        setRotation(rotation);
        move(5);
        //Hace que el actor se mueva lentamente en direcciones aleatorias
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
        
        Actor bala;
        bala = getOneIntersectingObject(Bullet.class); //Revisa si colisiona con una bala para poder eliminarla
        if (bala != null)
        {
            getWorld().removeObject(bala);
        }
        
    }    
}
