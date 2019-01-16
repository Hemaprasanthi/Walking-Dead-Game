public class HumanAliveState implements iHumanState   
{
    public Human human;
    
    public HumanAliveState(Human human)
    {
        this.human = human;
    }
    
    /**
     * Human is alive
     */

    public  boolean isAlive()
    {
        return true;
    }
    
    /**
     * Human is dead
     */
    
    public boolean isDead()
    {
        return false;
    }
    
    /**
     * Set state
     */
     
    public void setState()
    {
        human.setState(human.getHumanDeadState());
    }
    
    /**
     * Display
     */
    
    public void display()
    {
        human.getWorld().addObject(new FinalBanner("youwin.png"), 500, 125);
    }
}
