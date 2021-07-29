import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

//Jugador principal
public class Player extends Actor
{
    private int cooldown;
    int hp = 100; //Se crean las variables necesarias de Player
    
    public void act() 
    {
        
        checkCollision(); //Se llama el metodo para revisar si el jugador recibe daño o no
        
        if(cooldown > 0) {
            cooldown -= 1; //Reduce el cooldown del disparo
        }
        
        //Revisa si se cumplen las condiciones para poder disparar
        if (Greenfoot.mouseClicked(null) && (cooldown == 0))
        {
           MouseInfo mouse = Greenfoot.getMouseInfo(); //Se crea una variable que almacene los datos del mouse
           if (mouse == null) return;
           int x = mouse.getX();
           int y = mouse.getY(); //Se obtienen las coordenadas XY del puntero del mouse
           Bullet bullet = new Bullet();
           getWorld().addObject(bullet, getX(), getY()); 
           bullet.turnTowards(x, y); //se crea una bala que se diriga a la posicion actual del mouse
           cooldown = 15; //Se resetea el cooldown del disparo
           
        }
        
        
        
        try{movimiento();}
        catch(Exception e){}
        /*Si el actor se moría mientras se mueve causaba un error, aunque creo que se soluciona poniendolo antes del checkCollision() jajaja
          lamenteblamente, ya me tomé el tiempo de hacer esto y tengo demasiado orgullo como para moverlo. */
        
    }
    
    //Método para definir el sistema de movimiento del jugador
    private void movimiento(){
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
    
    //Método para revisar colisiones y monitorear la vida del jugador
    private void checkCollision()
    {
        Actor obstaculo, malvado, balaM;
        obstaculo = getOneIntersectingObject(obstacle.class);
        malvado = getOneIntersectingObject(Malvados.class);
        balaM = getOneIntersectingObject(bulletM.class); //Se obtienen los objetos en la misma posicion que player
        
        //Si se detecta colisión, reduce la vida actual del jugador
        if (obstaculo != null || malvado != null)
        {
            hp -= 1;
        }
        
        if (balaM != null) {hp -= 3;} //Se revisa si colisiona con una bala enemiga
        
        if (hp <= 0) //Si el usuario se muere, ejecuta lo siguiente
        {
            MyWorld mundo = (MyWorld)getWorld();
            Contador contador = mundo.getContador(); //Se obtiene el contador actual para almacenarlo en ua variable
            int ptsfinal = (int)contador.contador; //Se convierte el valor de tipo contador a int, y se almacena en una variable
            Fin.pts = ptsfinal; //Se pasa el valor de la puntuación a la variable estática en el mundo Fin
            getWorld().removeObject(this); //Se quita el jugador del mundo
            Greenfoot.setWorld(new Fin()); //Se cambia de mundo
            return;
        }
    }
    
    //Metodo para obtener la vida del jugador
    public int getHP(){
        return hp;
    }
    
}
