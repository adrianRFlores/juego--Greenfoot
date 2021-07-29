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
        Player player = mundo.getPlayer(); //Se obtiene el jugador actual
        setImage(new GreenfootImage("HP: " + player.getHP(), 30, Color.GREEN, Color.BLACK)); //Se muestra la vida del jugador a través del metodo getHP()
        movimiento(); //Se llama el metodo de movimiento del jugador
    }    
    
    //Método de movimiento idéntico al del jugador
    private void movimiento(){ //Probablemente hay soluciones más elegantes pero no soy tan inteligente
        if (Greenfoot.isKeyDown("a") && (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s"))){
            if (Greenfoot.isKeyDown("w")){
                setLocation(getX()-4, getY()-4);
            }
            
            else if (Greenfoot.isKeyDown("s")){
                setLocation(getX()-4, getY()+4);
            }
        }
        
        else if (Greenfoot.isKeyDown("d") && (Greenfoot.isKeyDown("w") || Greenfoot.isKeyDown("s"))){
            if (Greenfoot.isKeyDown("w")){
                setLocation(getX()+4, getY()-4);
            }
            
            else if (Greenfoot.isKeyDown("s")){
                setLocation(getX()+4, getY()+4);
            }
        }
        
        else {
            if (Greenfoot.isKeyDown("a"))
            {
                setLocation(getX()-5, getY()); 
            }
            if (Greenfoot.isKeyDown("d"))
            {
                setLocation(getX()+5, getY());
            }
            if (Greenfoot.isKeyDown("w"))
            {
                setLocation(getX(), getY()-5); 
            }
            if (Greenfoot.isKeyDown("s"))
            {
                setLocation(getX(), getY()+5); 
            }
        }
    }
}
