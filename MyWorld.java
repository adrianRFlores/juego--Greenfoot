import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    Contador contador = new Contador();
    Player player = new Player();
    private int timer = 0, cooldown = 150;

    public MyWorld()
    {    
        super(1000, 900, 1); 
        prepare();
    }

    private int getRandX(){
        return Greenfoot.getRandomNumber(1000);
    }
    private int getRandY(){
        return Greenfoot.getRandomNumber(900);
    }

    public Contador getContador(){
        return contador;
    }
    
    public Player getPlayer(){
        return player;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        addObject(contador,895,847);
        addObject(player,500,450);
        spawner spawner = new spawner();
        addObject(spawner,999,0);
        ContHP contHP = new ContHP();
        addObject(contHP,499,492);
    }
}
