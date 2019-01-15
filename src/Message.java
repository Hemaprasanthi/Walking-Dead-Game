import greenfoot.*;  //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Message extends Actor
{
    GreenfootImage gi;
    private static Message instance;
    
    public static Message getInstance() {     
        if (null==instance)
            instance = new Message();
        return instance;
    }
    private Message(){
        
    }
    
    /**
     * Initialize message object
     */
    
    public void setMessage()
    {
        gi = new GreenfootImage(350, 120); // create a new greenfoot image of size width = 350, height = 120
        gi.clear();
        gi.setColor(Color.YELLOW);
        //gi.setFont(new java.awt.Font("default", Font.BOLD, 16));
        gi.drawString("KIT : Not Available\nFood: 0\nSword: Not Available\nZombies Killed = 0\nGun: Not Available", 10, 30); // Initialize the message with zero food, kits etc.
        setImage(gi);
    }
    
    /**
     * Act of message
     */
    
    public void act() 
    {
    }
    
    /**
     * Changing the text of message
     */
    public void setText(String msg){ // updates the message passed into it in the score box
        gi.clear();
        gi.setColor(Color.YELLOW);
        //gi.setFont(new java.awt.Font("default", Font.BOLD, 16));
        gi.drawString(msg, 10, 30);
    }
}
