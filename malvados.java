import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class malvados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Malvados extends Actor
{
    private int rotation, cooldown;
    
    public void act() 
    {
        move(2);
        if (Greenfoot.getRandomNumber(100) <= 10)
        {
            turn(Greenfoot.getRandomNumber(180) - 45);
        }
        
        if(cooldown > 0) {
            cooldown -= 1;
        }
        
        if ((Greenfoot.getRandomNumber(1000) <= 20)  && (cooldown == 0))
        {
           bulletM b1 = new bulletM();
           getWorld().addObject(b1, getX(), getY());
           b1.turnTowards(getRandX(), getRandY());
           if (Greenfoot.getRandomNumber(1000) <= 20)
           {
               bulletM b2 = new bulletM();
               getWorld().addObject(b2, getX(), getY());
               b2.turnTowards(getRandX(),getRandY());
               if (Greenfoot.getRandomNumber(1000) <= 20)
               {
                   bulletM b3 = new bulletM();
                   getWorld().addObject(b3, getX(), getY());
                   b3.turnTowards(getRandX(), getRandY());
                }
           }
           cooldown = 30;
        }
        
        checkCollisionM();
        
    }  
    
    public void checkCollisionM()
    {
        Actor bala = getOneIntersectingObject(Bullet.class);
        if (bala != null)
        {
            MyWorld mundo = (MyWorld)getWorld();
            Contador contador = mundo.getContador();
            contador.add();
            getWorld().removeObject(this);
        }
    }
    
    public int getRandX(){
        return Greenfoot.getRandomNumber(1000);
    }
    
    public int getRandY(){
        return Greenfoot.getRandomNumber(900);
    }
}
