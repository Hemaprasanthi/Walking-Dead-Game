/**
 * Write a description of class LevelTwoState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class LevelTwoState implements LevelState 
{
    

    /**
     * Constructor for objects of class LevelTwoState
     */

    Creator creator;
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void doAction(World world)
    {
        FinalBanner fb=new FinalBanner("two.png");
        world.addObject(fb, 500, 125);
        Greenfoot.delay(20);
        world.removeObject(fb);
        creator=new ZombieFactory();
        for(int i=0;i<8;i++)
            {
                world.addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(250));
                
            }
        
        
            
    }
}
