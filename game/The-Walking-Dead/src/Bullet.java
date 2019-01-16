import greenfoot.*;  //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends Actor implements Subject
{
    /**
     * Act - do whatever the Bullet wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private Message m;
    private Actor blood;
    
    private ArrayList<Observer> observers =  new ArrayList<Observer>();
    public void act() 
    {
       //m = (Message) getWorld().getObjects(Message.class).get(0);
       m = Message.getInstance();
        setLocation(getX() + speed, getY());
        blood=new Blood();
       //checkBoundaries();
       destroyEnemies();
    } 
    
    //we add a method "checkBoundaries()" that destroys bullets that are off screen.
   public void checkBoundaries()
   {
       if(getX() > getWorld().getWidth() - 1) 
            getWorld().removeObject(this);
       else if(getX() < 1) 
            getWorld().removeObject(this);
       if(getY() > getWorld().getHeight() - 1) 
            getWorld().removeObject(this);
       else if(getY() < 1) 
            getWorld().removeObject(this);
   }
   //"destroyEnemies()" destroys enemies.
   public void destroyEnemies()
   {
       //"Enemy" can be any class that you want the bullet to destroy. 
       Actor enemy = getOneIntersectingObject(Zombie.class);
       if(enemy != null) {
           notifyObservers("zombieBullet", m);
           getWorld().addObject(blood, enemy.getX(), enemy.getY());
           Greenfoot.delay(5);
           getWorld().removeObject(blood);
           getWorld().removeObject(enemy);
           getWorld().removeObject(this);
           
       }
   }
   
   // OBSERVER PATTERN
    public void attach(Observer obj){
        observers.add(obj);
     }
   
    public void detach(Observer obj){
        observers.remove(obj);
     }
    
    public void notifyObservers(String item, Message m){
        for(Observer obj : observers)
        {
            obj.update(item, m);
        }
    }
 
   private int speed = 10;
}
