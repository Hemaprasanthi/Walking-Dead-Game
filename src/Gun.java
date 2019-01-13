import greenfoot.*;  //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Gun extends Actor // Food is the pizza slice that appears on the game.
{
    
    public Gun(){
        GreenfootImage image1 = new GreenfootImage("gun.png");
        image1.scale(image1.getWidth() - 30, image1.getHeight() - 30);
        setImage(image1);
    }
    
    /**
     * Act of Gun
     */
    public void act(){}
}
