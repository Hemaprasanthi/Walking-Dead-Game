import greenfoot.*; 

public class Context  
{
   
    private iStrategy strategy;
 
    public Context(iStrategy strategy) {
        this.strategy = strategy;
    }
    
    /**
     * Execution of movement
     */
    public void executeMovement(Actor a) {
        this.strategy.movement(a);
    }

}
