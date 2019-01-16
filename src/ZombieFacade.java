/** 
 * Write a description of class ZombieFacade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;
public class ZombieFacade implements iItemCollectionFacade
{
    // instance variables - replace the example below with your own
    private ItemCollectionObserver ic=ItemCollectionObserver.getInstance();
    private Creator creator;
    private Message m;
    /**
     * Constructor for objects of class ZombieFacade
     */
    public ZombieFacade()
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
            ItemCollectionObserver.zombieKilled++;
            ic.zombieString = "Zombies Killed: "+ItemCollectionObserver.zombieKilled;
            
            ItemCollectionObserver.swordParts = 0; // Reset sword as it is used to kill the zombie
            ItemCollectionObserver.hasSword = false;
            ic.swordString = "Sword : "+ItemCollectionObserver.swordParts+" out of 2";
            if(ItemCollectionObserver.hasGun)
            {
                GreenfootImage image1 = new GreenfootImage("Human with gun.png");
                image1.scale(image1.getWidth() - 30, image1.getHeight() - 30);
                h1.setImage(image1);
            }
            else
            {
                GreenfootImage image2 = new GreenfootImage("Human.png");
                image2.scale(image2.getWidth() - 30, image2.getHeight() - 30);
                h1.setImage(image2);
            }
            
            
            creator = new SwordFactory(); // Add new Sword parts for the human to collect and kill another zombie
            Actor s1 = creator.getActor();
            Message.getInstance().getWorld().addObject(s1, 80, 229);
            s1.setImage("handle.png");

            int x = Greenfoot.getRandomNumber(800);
            int y = Greenfoot.getRandomNumber(100);
            
            Actor s2 = creator.getActor();
            Message.getInstance().getWorld().addObject(s2, x+15, y+5);
            s2.setImage("blade.png");

    }
}
