import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ptsFinal extends Actor
{
    public void act() 
    {
        //Muestra la puntuación final
        setImage(new GreenfootImage("Puntuación final: " +  Fin.pts, 70, Color.BLACK, Color.GREEN));
    }    
}
