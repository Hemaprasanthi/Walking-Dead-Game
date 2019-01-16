import greenfoot.*;

public class HumanMovement implements iStrategy
{
    /**
     * Human movemment
     */
    public void movement(Actor a){
        int x = 0; // local field to hold m ovement along the x-axis
        int y = 0; // local field to hold movement along the y-axis
        
        
        
        if (Greenfoot.isKeyDown("up"))
        y=y-4; // adjust y-axis movement upward
        if (Greenfoot.isKeyDown("down"))
        y=y+4; // adjust y-axis movement downward
        if (Greenfoot.isKeyDown("left"))
        x=x-4; // adjust x-axis movement toward left
        if (Greenfoot.isKeyDown("right"))
        x=x+4; // adjust x-axis movement toward right
        if (x * y == 0) 
        {
            a.setLocation(a.getX()+x, a.getY()+y);
            
            if(a.isAtEdge())
            {
                a.setLocation(a.getX()-x, a.getY()-y);
            }
        }
    }
}
