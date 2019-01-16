/** 
 * Write a description of class SwordFacade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class SwordFacade implements iItemCollectionFacade
{
    // instance variables - replace the example below with your own
    private ItemCollectionObserver ic=ItemCollectionObserver.getInstance();
    private Creator creator;
    private Message m;
    /**
     * Constructor for objects of class SwordFacade
     */
    public SwordFacade()
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
        ItemCollectionObserver.swordParts++;
            ic.swordString = "Sword parts : "+ItemCollectionObserver.swordParts+" out of 2";
            if(h1.swordState.hasFull()){ // Human has collected two parts of sword.
                ic.swordString = "sword : Available";
                ItemCollectionObserver.swordParts = 0;
                ItemCollectionObserver.hasSword = true;
                GreenfootImage image1 = new GreenfootImage("Human with sword.png");
                image1.scale(image1.getWidth() - 30, image1.getHeight() - 30);
                h1.setImage(image1);
            }
    }
}
