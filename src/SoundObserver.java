import greenfoot.*; 


public class SoundObserver implements Observer
{
    
    public SoundObserver()
    {
    }
    
    /**
     * Update the item and message
     */
    
    public void update(String item, Message m)
    {
        
        if(item=="kit")
        {
            //play(sound)
            Greenfoot.playSound("kit.wav");
        }
        else if(item=="food"){
            //play(sound)
            Greenfoot.playSound("food.wav");
        }
        else if(item=="sword" && ItemCollectionObserver.hasSword==true){
            
            //play(sound)
            Greenfoot.playSound("Aftersword.wav");
        }
        else if(item=="zombie"){
            //play(sound)
            Greenfoot.playSound("zombiekill.wav");
        }
        
        
    }
        
        
        
}
    
    
    
