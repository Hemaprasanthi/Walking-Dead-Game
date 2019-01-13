import greenfoot.*; 


public class ItemCollectionObserver implements Observer
{
    
    static int foodCount, swordParts, zombieCount,zombieKilled;
    String foodString, kitString, zombieString, swordString, gunString;
    public static boolean hasKit,hasGun ;
    public static boolean hasSword ;
    Creator creator;
    private static ItemCollectionObserver instance;
    private iItemCollectionFacade facade;
    
    
    private ItemCollectionObserver()
    {
        foodCount=0;
        swordParts=0;
        zombieCount=3;
        foodString="Foodic : 0";
        kitString = "Kit : Not Available";
        zombieString = "Zombies Killed: 0";
        swordString = "Sword : Not Available";
        gunString = "Gun : Not Available";
        hasKit=false;
        hasSword=false;
        zombieKilled=0;
        hasGun=false;
    }
    
    /**
     * Get Instance ItemCollectionObserver
     */
    
    public static ItemCollectionObserver getInstance() {     
        if (null==instance)
            instance = new ItemCollectionObserver();
        return instance;
    }
    
    /**
     * Set the value of ItemCollectionObserver at the time of creating New York
     */
    public void setValue()
    {
        foodCount=0;
        swordParts=0;
        zombieCount=3;
        foodString="Foodic : 0";
        kitString = "Kit : Not Available";
        zombieString = "Zombies Killed: 0";
        swordString = "Sword : Not Available";
        gunString = "Gun : Not Available";
        hasKit=false;
        hasSword=false;
        zombieKilled=0;
        hasGun=false;
    }
    
    /**
     * Update the item and message
     */
    
    public void update(String item, Message m)
    {
        Human h1 = (Human) m.getWorld().getObjects(Human.class).get(0);
        if(item=="kit")
        {
            facade = new KitFacade();
            facade.doAction();
            
        }
        else if(item=="food"){
            facade=new FoodFacade();
            facade.doAction();
            
        }
        else if(item=="sword"){
            facade=new SwordFacade();
            facade.doAction();
            
        }
        else if(item=="zombie"){
            facade=new ZombieFacade();
            facade.doAction();
            
           
        }
        else if (item=="zombieBullet")
        {
            facade=new ZombieBulletFacade();
            facade.doAction();
            
        }
        else if(item=="gun")
        {
            facade=new GunFacade();
            facade.doAction();
            
       
        }
        
        m.setText(kitString +"\n"+ foodString +"\n"+ swordString + "\n" + zombieString+ "\n" + gunString);
    }
        
        
        
}
    
    
    
