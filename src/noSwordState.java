public class noSwordState implements iSwordState 
{
  
    public Sword sword;
    public noSwordState(Sword sword)
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
        return false;
    }
    
    /**
     * HasNoSword
     */   
    public boolean hasNoSword()
    {
        return true;
    }
     
    /**
     * set state
     */
    public void setState()
    {
        sword.setState(sword.getHalfSwordState());
    }
    
    /**
     * Display
     */
    public void display()
    {
        System.out.println("No sword is taken");
    }


}