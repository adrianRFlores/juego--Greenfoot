import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class spawner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class spawner extends Actor
{
    private int timer = 0, cooldown = 10;
    private Contador contador = new Contador();
    
    public void act() 
    {
        timer++;
        if(timer == 10){
            cooldown--;
            timer = 0;
        }
        if(cooldown == 0){
            spawnMalevolos();
            cooldown=10;
        }
    }    
    
    private void spawnMalevolos(){
        Malvados malvado = new Malvados();
        getWorld().addObject(malvado, getRandX(), getRandY());
    }

    private int getRandX(){
        return Greenfoot.getRandomNumber(1000);
    }
    private int getRandY(){
        return Greenfoot.getRandomNumber(900);
    }
}
