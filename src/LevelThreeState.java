/**
 * Write a description of class LevelThreeState here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class LevelThreeState implements LevelState  
{
    
    Creator creator;

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void doAction(World world)
    {
        FinalBanner fb=new FinalBanner("three.png");
        world.addObject(fb, 500, 125);
        Greenfoot.delay(20);
        world.removeObject(fb);
        creator=new ZombieFactory();
        for(int i=0;i<10;i++)
            {
                world.addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(250));
            }
    }
}
