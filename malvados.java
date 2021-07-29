import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class malvados here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Malvados extends Actor
{
    private int rotation, cooldown; //Se crean valores de cooldown y de rotacion
    
    public void act() 
    {
        move(2); //Siempre está en movimiento
        if (Greenfoot.getRandomNumber(100) <= 10)
        {
            turn(Greenfoot.getRandomNumber(180) - 45); //Gira en direcciones aleatorias
        }
        
        if(cooldown > 0) {
            cooldown -= 1; //Misma manera de manejar cooldown con Player
        }
        
        //Si no hay cooldown, se hay un 2% de probabilidad que se dispare una bala por ciclo
        if ((Greenfoot.getRandomNumber(1000) <= 20)  && (cooldown == 0))
        {
           bulletM b1 = new bulletM();
           getWorld().addObject(b1, getX(), getY());
           b1.turnTowards(getRandX(), getRandY()); //Se crea la bala dirigida a una direccion aleatoria
           if (Greenfoot.getRandomNumber(1000) <= 20) //Si se dispara la bala, hay otro roll para determinar si se disparan 2
           {
               bulletM b2 = new bulletM();
               getWorld().addObject(b2, getX(), getY());
               b2.turnTowards(getRandX(),getRandY()); //Se dispara la segunda bala en una direccion diferente a la primera
               if (Greenfoot.getRandomNumber(1000) <= 20) //Si se dispara la bala, hay otro roll para determinar si se disparan 3
               {
                   bulletM b3 = new bulletM();
                   getWorld().addObject(b3, getX(), getY());
                   b3.turnTowards(getRandX(), getRandY()); //Se dispara la tercera bala en una direccion diferente 
                }
           }
           cooldown = 30; //Se resetea el cooldown del disparo
        }
        
        checkCollisionM(); //Al igual que player, se deben revisar colisiones
        
    }  
    
    //Metodo pára revisar las colisiones 
    public void checkCollisionM()
    {
        Actor bala = getOneIntersectingObject(Bullet.class); //Se revisa si la bala que dispara player intersecta al actor
        if (bala != null) //Si da la bala:
        {
            MyWorld mundo = (MyWorld)getWorld();
            Contador contador = mundo.getContador();
            contador.add(); //Se obtiene el contador y se llama el metodo para agregarle 100pts
            getWorld().removeObject(this); //Se quita el actor del mundo
        }
    }
    
    //Metodo para obtener coordenadas aleatorias
    public int getRandX(){
        return Greenfoot.getRandomNumber(1000);
    }
    public int getRandY(){
        return Greenfoot.getRandomNumber(900);
    }
}
