import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private int cooldown;
    public int hp = 100;
    public void act() 
    {
        
        checkCollision();
        
        if(cooldown > 0) {
            cooldown -= 1;
        }
        
        if (Greenfoot.mouseClicked(null) && (cooldown == 0))
        {
           MouseInfo mouse = Greenfoot.getMouseInfo();
           if (mouse == null) return;
           int x = mouse.getX();
           int y = mouse.getY();
           Bullet bullet = new Bullet();
           getWorld().addObject(bullet, getX(), getY());
           bullet.turnTowards(x, y);
           cooldown = 15;
           
        }
        
        
        
        try{movimiento();}
        catch(Exception e){}
        /*Si el actor se moría mientras se mueve causaba un error, aunque creo que se soluciona poniendolo antes del checkCollision() jajaja
          lamenteblamente, ya me tomé el tiempo de hacer esto y tengo demasiado orgullo como para moverlo. */
        
    }
    
    private void movimiento(){
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
    
    private void checkCollision()
    {
        Actor obstaculo, malvado, balaM;
        obstaculo = getOneIntersectingObject(obstacle.class);
        malvado = getOneIntersectingObject(Malvados.class);
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
