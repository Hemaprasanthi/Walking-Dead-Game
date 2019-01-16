/** 
 * Write a description of class ZombieBulletFacade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class ZombieBulletFacade implements iItemCollectionFacade
{
    // instance variables - replace the example below with your own
    private ItemCollectionObserver ic=ItemCollectionObserver.getInstance();
    private Creator creator;
    private Message m;
    /**
     * Constructor for objects of class ZombieBulletFacade
     */
    public ZombieBulletFacade()
    {
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void doAction()
    {
        // put your code here
        ItemCollectionObserver.zombieKilled++;
        ic.zombieString = "Zombies Killed: "+ItemCollectionObserver.zombieKilled;
        
    }
}
