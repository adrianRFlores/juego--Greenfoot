import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    Contador contador = new Contador(); //Se toma el contador
    Player player = new Player();  //Se crea una instancia de player

    public MyWorld()
    {    
        super(1000, 900, 1); 
        prepare();
        if(Inicio.cancion.isPlaying()){} //Revisa si se acabó la canción para repetirla de ser necesario
        else{
            Inicio.cancion.play();
        }
    }

    //Métods para acortar el proceso de conseguir un numero aleatorio en el rango de las dimensiones del mundo
    private int getRandX(){
        return Greenfoot.getRandomNumber(1000);
    }
    private int getRandY(){
        return Greenfoot.getRandomNumber(900);
    }

    //Metodo para obtener el contador actual
    public Contador getContador(){
        return contador;
    }
    
    //Metodo para obtener al jugador que se creó al inicio del mundo
    public Player getPlayer(){
        return player;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        obstacle obstacle = new obstacle();
        addObject(obstacle,getRandX(),getRandY());
        obstacle obstacle2 = new obstacle();
        addObject(obstacle2,getRandX(),getRandY());
        obstacle obstacle3 = new obstacle();
        addObject(obstacle3,getRandX(),getRandY());
        addObject(contador,895,847);
        addObject(player,500,450);
        spawner spawner = new spawner();
        addObject(spawner,999,0);
        ContHP contHP = new ContHP();
        addObject(contHP,499,494);
        Malvados m1 = new Malvados();
        addObject(m1,getRandX(),getRandY());
        Malvados m2 = new Malvados();
        addObject(m2,getRandX(),getRandY());
    }
}
