import greenfoot.*;

public class ZombieFactory  extends Creator
{
    public Actor getActor(){
        Zombie z = new Zombie();
        GreenfootImage image1 = new GreenfootImage("Zombie1.png");
        image1.scale(image1.getWidth() - 10, image1.getHeight() - 10);
        z.setImage(image1);
        return z;
    }
}
