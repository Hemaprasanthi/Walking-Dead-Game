/** 
 * Write a description of class humanDead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HumanDeadState implements iHumanState
{
    
    public Human human;
    public HumanDeadState(Human human)
    {
        this.human = human;
    }
    
    /**
     * Human is alive
     */

    public  boolean isAlive()
    {
        return false;
    }
    
    /**
     * Human is dead
     */
    
    public boolean isDead()
    {
        return true;
    }
    
    /**
     * Set state
     */
    
    public void setState() { 
    
    }
    
    /**
     * Display
     */
    public void display()
    {
        human.getWorld().addObject(new FinalBanner("gameover1.png"), 500, 230);
    }
}
