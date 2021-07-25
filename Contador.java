import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Contador extends Actor
{
    int contador = 0;
    private int timer = 0;
    public void act() 
    {
        setImage(new GreenfootImage("Puntuación: " + contador, 30, Color.BLACK, Color.GREEN));
        puntuacion();
    }
    
    private void puntuacion(){
        timer++;
        if(timer == 10){
            contador++;
            timer = 0;
        }
    }
    
    public void add(){
        contador += 100;
    }
}
