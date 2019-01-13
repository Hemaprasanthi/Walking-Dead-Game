/**
 * Write a description of class KitFacade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class KitFacade implements iItemCollectionFacade
{
    // instance variables - replace the example below with your own
    private ItemCollectionObserver ic=ItemCollectionObserver.getInstance();
    private Creator creator;
    private Message m;
    /**
     * Constructor for objects of class KitFacade
     */
    public KitFacade()
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
        
        ItemCollectionObserver.hasKit = !ItemCollectionObserver.hasKit;
            if(ItemCollectionObserver.hasKit)
            ic.kitString = "Kit : Available";
            else
            ic.kitString = "Kit : Not Available";
            if(ItemCollectionObserver.hasKit==false)
            {
                creator = new KitFactory();
                Message.getInstance().getWorld().addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500)); // Add kit to the world after it has been used.
            }
    }
}
