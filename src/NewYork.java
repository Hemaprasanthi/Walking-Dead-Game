import greenfoot.*;  //imports Actor, World, Greenfoot, GreenfootImage

public class NewYork extends World 
{   
    Creator creator;
    Human h1;
    ItemCollectionObserver ic1 = ItemCollectionObserver.getInstance();
    
    public NewYork() 
    {
        super(1000, 500, 1); // Setting the size of the world, 1000 is the width of world and 500 is height of the world
        ItemCollectionObserver ic = ItemCollectionObserver.getInstance();
        ic.setValue();
        prepare();
    }
    /**
     * Prepare the world for the start of the program. That is: create the initial
     * objects and add them to the world.
     */
    private void prepare()
    {
       
       Message m = Message.getInstance();
       m.setMessage();
       addObject(m, 900, 60);
       
       
        //addScoreBox(); // adds a score box at the top right
       addZombiesToWorld(); // adds zombies to the world at random places
       addItems(); // adds Food, Kit, Sword to the world
       h1 = addHumanToWorld(); // adds Human to the world and returns a reference to attach the observers
       attachObservers(h1); // attaches itemCollectionObserver and soundObserver to the human h1.
    }
    /**
     * Add items to the world
     */
    public void addItems(){
       Creator c1 = new KitFactory(); // This factory returns a kit
       Creator c2 = new SwordFactory(); // This factory returns a sword
       Creator c3 = new GunFactory(); // This factory returns a gun
       
       addObject(c1.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500)); // adds kit at a random place to the world
       populateFood();
       
       Gun g1 = (Gun) c3.getActor(); // getting a sword as an actor and casting it into a sword.
       addObject(g1, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
       GreenfootImage image1 = new GreenfootImage("gun.png");
       image1.scale(image1.getWidth(), image1.getHeight());
       g1.setImage("gun.png"); // setting the image of the sword.
       
       Sword s1 = (Sword) c2.getActor(); // getting a sword as an actor and casting it into a sword.
       addObject(s1, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
       s1.setImage("handle.png"); // setting the image of the sword.
       
       Sword s2 = (Sword) c2.getActor();
       addObject(s2, Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
       s2.setImage("blade.png");
    }
    
    /**
     * Add Scorebox to the world
     */
    
    public void addScoreBox(){
        // adds a score box at the coordinates x = 900, y = 60
    }
    
    /**
     * Add Human to the world
     */
    
    public Human addHumanToWorld(){
       Human h1;
       
        
       h1 = new Human();
       addObject(h1, 50, 420);
       return h1;
    }
    
    /**
     * Add Zombies to the world
     */
    public void addZombiesToWorld(){
       creator = new ZombieFactory(); // This factory returns a zombie
       for(int i=0;i<5;i++)
           {
              addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(250));
           }
    }
    
    /**
     * Add Food to the world
     */
    public void populateFood(){
       creator = new FoodFactory(); // This factory returns a Food
       
       addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
       addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
       addObject(creator.getActor(), Greenfoot.getRandomNumber(1000), Greenfoot.getRandomNumber(500));
    }
    /**
     * Attach itemcollectionobserver to the Human created
     */
    
    public void attachObservers(Human h1){
        h1.attach(ic1); //attaching the ItemCollectionObserver
        h1.attach(new SoundObserver()); // attaching the SoundObserver
    }
    
    
}