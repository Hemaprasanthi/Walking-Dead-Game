public class halfSwordState implements iSwordState 
{
  
    public Sword sword;
    public halfSwordState(Sword sword)
    {
    
    this.sword = sword;
    }
    
    /**
     * Hasfull
     */

    public  boolean hasFull()
    {
        return false;
    }
    
    /**
     * HasHalf
     */
    
    public boolean hasHalf()
    {
        return true;
    }
    
    /**
     * HasNoSword
     */
     public boolean hasNoSword()
    {
        return false;
    }
     
    /**
     * Set state
     */
    public void setState()
    {
        sword.setState(sword.getFullSwordState());
    }
    
    /**
     * Display
     */
    public void display()
    {
        System.out.println("Half sword is taken");
    }


}