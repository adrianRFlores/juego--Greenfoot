import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class bullet extends Actor
{
    private boolean cont = true;
    /**
     * Act - do whatever the bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(cont)
        {
            Actor videojugador = getOneIntersectingObject(player.class);
            setRotation(videojugador.getRotation());
            cont = false;
        }
        move(10);
        
        if (isAtEdge())
        {
            getWorld().removeObject(this);
        }
        
    }
    
}
