import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    private int cooldown;
    private int hp = 100;
    public void act() 
    {
        
        checkCollision();
        
        if(cooldown > 0) {
            cooldown -= 1;
        }
        
        if (Greenfoot.isKeyDown("a"))
        {
           turn(-3); 
        }
        if (Greenfoot.isKeyDown("d"))
        {
           turn(3); 
        }
        if (Greenfoot.isKeyDown("w"))
        {
           move(5); 
        }
        if (Greenfoot.isKeyDown("s"))
        {
           move(-5); 
        }
        
        if (Greenfoot.isKeyDown("space") && (cooldown == 0))
        {
           getWorld().addObject(new bullet(), getX(), getY());
           cooldown = 15;
           
        }
    }
    
    public void checkCollision()
    {
        Actor obstaculo, malvado, balaM;
        obstaculo = getOneIntersectingObject(obstacle.class);
        malvado = getOneIntersectingObject(malvados.class);
        balaM = getOneIntersectingObject(bulletM.class);
        
        if (obstaculo != null && malvado != null)
        {
            hp -= 1;
        }
        
        if (balaM != null) {hp -= 5;}
        
        if (hp <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}
