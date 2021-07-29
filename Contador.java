import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//Contador de puntos
public class Contador extends Actor
{
    int contador = 0;
    private int timer = 0; //Variable que define qué tan rápido se aumentan los puntos del jugador de manera pasiva
    public void act() 
    {
        setImage(new GreenfootImage("Puntuación: " + contador, 30, Color.BLACK, Color.GREEN)); //Se muestra la puntuacion
        puntuacion(); //Incrementa la puntuacion del jugador pasivamente
    }
    
    //Incrementa la puntuacion del jugador pasivamente
    private void puntuacion(){
        timer++;
        if(timer == 10){
            contador++;
            timer = 0;
        }
    }
    
    //Agrega 100pts a la puntuacion
    public void add(){
        contador += 100;
    }
}
