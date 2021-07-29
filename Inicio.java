import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Inicio extends World
{
    public static GreenfootSound cancion = new GreenfootSound("cancion.mp3"); //Se crea la variable estática para facilitar el uso entre mundos
    public Inicio()
    {    
        // Create a new world with 1000x900 cells with a cell size of 1x1 pixels.
        super(1000, 900, 1); 
        prepare();
        if(cancion.isPlaying()){} //Revisa si se acabó la canción para repetirla de ser necesario
        else{
            cancion.play();
        }
    }

    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            Greenfoot.setWorld(new MyWorld()); //Avanza a la siguiente pantalla
        }
    }

    private void prepare()
    {
        titulo titulo = new titulo();
        addObject(titulo,500,460);
        controles controles = new controles();
        addObject(controles,542,575);
        staticPlayer sp = new staticPlayer();
        addObject(sp, 510,530);
        staticMalevolo sm1 = new staticMalevolo();
        addObject(sm1, 810,440);
        staticMalevolo sm2 = new staticMalevolo();
        addObject(sm2, 650,300);
        staticMalevolo sm3 = new staticMalevolo();
        addObject(sm3, 400,690);
        staticObstaculo so1 = new staticObstaculo();
        addObject(so1, 750,640);
        staticObstaculo so2 = new staticObstaculo();
        addObject(so2, 190,510);
    }
}
