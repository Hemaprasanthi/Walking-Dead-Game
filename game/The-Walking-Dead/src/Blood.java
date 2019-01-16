import greenfoot.*;  //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Blood extends Actor
{
    int delayCount = 0;
    public Blood()
    {
        GreenfootImage image1 = new GreenfootImage("Blood Splatter.png");
        image1.scale(image1.getWidth() - 10, image1.getHeight() - 10);
        setImage(image1);
    }
    
    /**
     * Act of blood
     */
    public void act() 
    {
        // By default, this act method gets executed again and again and increments delaycount,
        // when delaycount reaches 100, blood actor removes itself.
        delayCount++;
        if(delayCount > 100)
        {
            getWorld().removeObject(this);
        }
    }   
}
