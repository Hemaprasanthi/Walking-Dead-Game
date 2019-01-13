/** 
 * Write a description of class FoodFacade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class FoodFacade implements iItemCollectionFacade
{
    // instance variables - replace the example below with your own
    private ItemCollectionObserver ic=ItemCollectionObserver.getInstance();
    private Creator creator;
    private Message m;
    /**
     * Constructor for objects of class FoodFacade
     */
    public FoodFacade()
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
        
        ItemCollectionObserver.foodCount++;
            ic.foodString = "Food : "+ItemCollectionObserver.foodCount;
            if(ItemCollectionObserver.foodCount%3 == 0){
                creator = new FoodFactory();
                Message.getInstance().getWorld().addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500)); // Add food at random places.
                Message.getInstance().getWorld().addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
                Message.getInstance().getWorld().addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
            }
    }
}
