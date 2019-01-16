import greenfoot.*;  //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Zombie extends Actor
{
    
    Context context = new Context(new ZombieMovement());
    private Actor human;
    
    /**
     * Act of Zombie
     */
    public void act()
    {  
       context.executeMovement(this);
    }

    /**
     * Check whether we are at the edge of the world. If we are, turn a bit.
     * If not, do nothing.
     */
    
    public boolean atWorldEdge()
    {
        if(getX() < 10 || getX() > getWorld().getWidth() - 10)
            return true;
        if(getY() < 10 || getY() > getWorld().getHeight() - 10)
            return true;
        else
            return false;
    }
    
    /**
     * Turn at edge
     */
    public void turnAtEdge()
    {
        if ( atWorldEdge() ) 
        {
            turn(17);
        }
    }

    /**
     * Randomly decide to turn from the current direction, or not. If we turn
     * turn a bit left or right by a random degree.
     */
    public void randomTurn()
    {
        if (Greenfoot.getRandomNumber(100) > 90) {
        int randomNum = Greenfoot.getRandomNumber(90)-45;
        turn(randomNum);
    }

    
}
       
}
