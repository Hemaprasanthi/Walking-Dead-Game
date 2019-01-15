/**
 * Write a description of class LevelContext here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class LevelContext  
{
    // instance variables - replace the example below with your own
    private LevelState currentState;
    private LevelOneState levelOneState;
    private LevelTwoState levelTwoState;
    private LevelThreeState levelThreeState;
    
    
    /**
     * Constructor for objects of class LevelContext
     */
    public LevelContext()
    {
        levelOneState=new LevelOneState();
        levelTwoState=new LevelTwoState();
        levelThreeState=new LevelThreeState();
        this.currentState=levelOneState;
        
    }

    /**
     * getCurrentState method to get state of game
     */
    public String getCurrentState()
    {
        return currentState.getClass().getName();
    }
    
    /**
     * setCurrentState method to set state of game
     */
    public void setCurrentState(LevelState state)
    {
        currentState=state;
    }
    
    public void doAction(World world)
    {
        currentState.doAction(world);
    }
}
