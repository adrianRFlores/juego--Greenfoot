import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//Actor que maneja la frecuencia en la que aparecen nuevos enemigos
public class spawner extends Actor
{
    private int timer = 0, cooldown = 10;
    
    public void act() 
    {
        //Maneja un cooldown para definir los intervalos de tiempo en los que aparecen nuevos enemigos
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
    
    //Método para agregar un enemigo al mundo
    private void spawnMalevolos(){
        Malvados malvado = new Malvados();
        getWorld().addObject(malvado, getRandX(), getRandY());
    }
    
    //Métodos para obtener posiciones aleatorias
    private int getRandX(){
        return Greenfoot.getRandomNumber(1000);
    }
    private int getRandY(){
        return Greenfoot.getRandomNumber(900);
    }
}
