/**
 * Write a description of class GunFacade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class GunFacade implements iItemCollectionFacade
{
    // instance variables - replace the example below with your own
    private ItemCollectionObserver ic=ItemCollectionObserver.getInstance();
    private Creator creator;
    private Message m;
    /**
     * Constructor for objects of class GunFacade
     */
    public GunFacade()
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
        Human h1 = (Human) Message.getInstance().getWorld().getObjects(Human.class).get(0);
        ItemCollectionObserver.hasGun = true;
        ic.gunString = "Gun : Available";
            GreenfootImage image1 = new GreenfootImage("Human with gun.png");
                image1.scale(image1.getWidth() - 30, image1.getHeight() - 30);
                h1.setImage(image1);
    }
}
