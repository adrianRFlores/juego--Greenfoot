import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MyWorld extends World
{
    Contador contador = new Contador();
    private int timer = 0, cooldown = 150;

    public MyWorld()
    {    
        super(1000, 900, 1); 
        prepare();
    }

    private void spawnMalevolos(){
        Malvados malvado = new Malvados();
        addObject(malvado, getRandX(), getRandY());
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

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Player player = new Player();
        addObject(player,500,450);
        spawner spawner = new spawner();
        addObject(spawner,999,0);
        ContHP contHP = new ContHP();
        addObject(contHP,499,492);
        Contador contador = new Contador();
        addObject(contador,895,847);
    }
}
