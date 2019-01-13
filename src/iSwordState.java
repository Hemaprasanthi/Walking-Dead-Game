public interface iSwordState 
{
    /**
     * Sword state
     */
    public  boolean hasFull();
    public boolean hasHalf();
    public boolean hasNoSword();
    public void setState();
    public void display();
}
