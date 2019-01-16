import greenfoot.*; 

public class ZombieMovement implements iStrategy
{
    /**
     * Zombie Movement
     */
    public void movement(Actor a){
        Zombie z = (Zombie) a;
        z.move(1);
        z.turnAtEdge();
        z.randomTurn();
    }
}
