import greenfoot.*;  //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Food extends Actor // Food is the pizza slice that appears on the game.
{
    
    public Food(){
        GreenfootImage image1 = new GreenfootImage("Food.png");
        image1.scale(image1.getWidth() - 20, image1.getHeight() - 20);
        setImage(image1);
    }
    /**
     * Act of Food
     */
    public void act(){}
}
