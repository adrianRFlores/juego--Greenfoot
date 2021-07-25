import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ContHP here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ContHP extends Actor
{
    
    public void act() 
    {
        MyWorld mundo = (MyWorld)getWorld();
        Player player = mundo.getPlayer();
        setImage(new GreenfootImage("HP: " + player.getHP(), 30, Color.GREEN, Color.BLACK));
        movimiento();
    }    
    
    private void movimiento(){ //Probablemente hay soluciones más elegantes pero no soy tan inteligente
        if (Greenfoot.isKeyDown("a") && (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s"))){
            if (Greenfoot.isKeyDown("w")){
                setLocation(getX()-3, getY()-3);
            }
            
            else if (Greenfoot.isKeyDown("s")){
                setLocation(getX()-3, getY()+3);
            }
        }
        
        else if (Greenfoot.isKeyDown("d") && (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s"))){
            if (Greenfoot.isKeyDown("w")){
                setLocation(getX()+3, getY()-3);
            }
            
            else if (Greenfoot.isKeyDown("s")){
                setLocation(getX()+3, getY()+3);
            }
        }
        
        else {
            if (Greenfoot.isKeyDown("a"))
            {
                setLocation(getX()-4, getY()); 
            }
            if (Greenfoot.isKeyDown("d"))
            {
                setLocation(getX()+4, getY());
            }
            if (Greenfoot.isKeyDown("w"))
            {
                setLocation(getX(), getY()-4); 
            }
            if (Greenfoot.isKeyDown("s"))
            {
                setLocation(getX(), getY()+4); 
            }
        }
    }
}
