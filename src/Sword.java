import greenfoot.*;
public class Sword extends Actor
{
    iSwordState halfsword;
    iSwordState fullsword;
    iSwordState nosword;
    
    iSwordState state;
     public Sword(){
        nosword = new noSwordState(this);
        halfsword = new halfSwordState(this);
        fullsword = new fullSwordState(this);
        state = nosword;
    }
    
    /**
     * Hasfull
     */
    public boolean hasFull() {
        return state.hasFull();
    }
    
    /**
     * HasHalf
     */

    public boolean hasHalf() {
        return state.hasHalf();
    }
    
    /**
     * HasNoSword state
     */
    
    public boolean hasNoSword() {
        return state.hasNoSword();
    }
    
    
    /**
     * State Display
     */
    
    public void display() {
        state.display();
    }
    
    /**
     * Set state 
     */
    
    void setState(iSwordState state) {
        this.state = state;
    }
    
    /**
     * Set sword state
     */
    public void setSwordState(){ 
        state.setState();
    }
    
    /**
     * Get full Sword state
     */
    iSwordState getFullSwordState(){
        return fullsword;
    }
    
    /**
     * Get half sword state
     */
       
    iSwordState getHalfSwordState(){
        return halfsword;
    }
    
    /**
     * Get No sword state
     */
    iSwordState getNoSwordState()
	{
	    return nosword;
	}
	
	/**
     * Act of sword
     */
    public void act() 
    {
        // Add your action code here.
    }
}