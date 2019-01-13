public class fullSwordState implements iSwordState   
{
  public Sword sword;
    public fullSwordState(Sword sword)
    {
    
    this.sword = sword;
    }

    public  boolean hasFull()
    {
        return true;
    }
    
    public boolean hasHalf()
    {
        return false;
    }
    
     public boolean hasNoSword()
    {
        return false;
    }
     
    public void setState()
    {
       sword.setState(sword.getNoSwordState());
    }
    
    public void display()
    {
        System.out.println("Full sword is taken");
    }
}