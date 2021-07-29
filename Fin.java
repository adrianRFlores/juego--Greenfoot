import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// Mundo que se muestra cuando muere el jugador
public class Fin extends World
{

    public static int pts;
    public Fin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 900, 1); 
        prepare();
        if(Inicio.cancion.isPlaying()){} //Revisa si se acabó la canción para repetirla de ser necesario
        else{
            Inicio.cancion.play();
        }
    }

    public void act(){
        if(Greenfoot.isKeyDown("enter")){
            for(int i=0;i<1000;i++){ //Esto sirve para evitar que al presionar enter se salten la pantalla de inicio

            }
            Greenfoot.setWorld(new Inicio());
        }
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ptsFinal ptsFinal = new ptsFinal();
        addObject(ptsFinal,500,450);
        end end = new end();
        addObject(end,500,760);
        staticObstaculo staticObstaculo = new staticObstaculo();
        addObject(staticObstaculo,795,149);
        staticObstaculo staticObstaculo2 = new staticObstaculo();
        addObject(staticObstaculo2,132,277);
        staticMalevolo staticMalevolo = new staticMalevolo();
        addObject(staticMalevolo,476,246);
        staticMalevolo staticMalevolo2 = new staticMalevolo();
        addObject(staticMalevolo2,192,92);
        staticMalevolo staticMalevolo3 = new staticMalevolo();
        addObject(staticMalevolo3,938,77);
        staticMalevolo staticMalevolo4 = new staticMalevolo();
        addObject(staticMalevolo4,801,591);
        staticObstaculo staticObstaculo3 = new staticObstaculo();
        addObject(staticObstaculo3,318,599);
    }
}
