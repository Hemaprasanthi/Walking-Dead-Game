import greenfoot.*;  //(World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
public class Human extends Actor implements Subject
{
    iHumanState humanAliveState, humanDeadState, humanState;
    public Sword swordState;
    private Actor food, kit, sword, zombie, blood, bullet, gun;
    private World world;
    private Message m;
    private int delayCount2 = 0;
    private boolean startDelay = false;
    private ArrayList<Observer> observers =  new ArrayList<Observer>();
    private Context context;
    ItemCollectionObserver ic = ItemCollectionObserver.getInstance();
    private LevelContext levelContext; 
    Creator creator;
    private int count = 0;
    boolean eightZombieAdded=false;
    boolean tenZombieAdded=false;
    
    //constructor 
    public Human(){
        //world = getWorld();
        GreenfootImage image1 = new GreenfootImage("Human.png");
        image1.scale(image1.getWidth() - 30, image1.getHeight() - 30);
        setImage(image1);
        levelContext=new LevelContext();
        blood = new Blood();
        
        humanAliveState = new HumanAliveState(this); // * state pattern 1*
        humanDeadState = new HumanDeadState(this); // * state pattern 1*
        humanState = humanAliveState; // * state pattern 1*
        swordState = new Sword(); // * state pattern 2*
        
        context = new Context(new HumanMovement()); // Strategy Pattern
    }
    
    /**
     * Act of Human
     */
    
    public void act() 
    {
        m = Message.getInstance();
        /**
         * Check if human is intersecting any object
        */
        checkForFood();
        checkForKit();
        checkForSword();
        checkForZombie();
        checkForGun();
        startDelayHumanWithKit();
        checkFire();
        context.executeMovement(this);
        setGameLevel();
        checkGameOver();// Strategy Pattern for moving human across the world.
    } 
    
    /**
     * Set Game Level State
     */
    public void setGameLevel()
    {
        creator=new ZombieFactory();
        if(ItemCollectionObserver.zombieKilled==5 && eightZombieAdded==false)
        {
            levelContext.setCurrentState(new LevelTwoState());
            levelContext.doAction(m.getWorld());
            eightZombieAdded=true;

        }
        else if(ItemCollectionObserver.zombieKilled==13&& tenZombieAdded==false)
        {
            levelContext.setCurrentState(new LevelThreeState());
            levelContext.doAction(m.getWorld());
            tenZombieAdded=true;
        }
    }
    
    /**
     * Check for game over
     */
    public void checkGameOver()
    {
        if(ItemCollectionObserver.zombieKilled ==23){ // If number of zombies == 0, display "You Win" message! and stop the game.
            calculateScore();
            display();
            Greenfoot.stop();
        }
    }
    
    /**
     * Check for food
     */
    public void checkForFood() 
    {
      food = getOneIntersectingObject(Food.class);
      if(food != null){
            
            notifyObservers("food", m); // check if human intersects food and notify observers *Observer Pattern*
            getWorld().removeObject(food); // Human eats the food, so food should disppear from the world
        }
    }
    /**
     * Check for gun and fire bullets
     */
    public void checkFire()
    {
        
        if(Greenfoot.isKeyDown("space") && ItemCollectionObserver.hasGun) {
            Greenfoot.delay(5);
            Bullet bullet = new Bullet();
            bullet.attach(ic); //attaching the ItemCollectionObserver
            bullet.setRotation(180*Greenfoot.getRandomNumber(2));
            getWorld().addObject(bullet, getX(), getY());
        }
    }
    /**
     * Check for kit
     */
    public void checkForKit()
    {
        kit = getOneIntersectingObject(Kit.class);
        if(kit != null){
             notifyObservers("kit", m); // notify observers for playing sound and updating score box.
             getWorld().removeObject(kit);
        }
    }
    
    /**
     * Check for Gun
     */
    public void checkForGun()
    {
        gun = getOneIntersectingObject(Gun.class);
        if(gun != null){
             notifyObservers("gun", m); // notify observers for playing sound and updating score box.
             getWorld().removeObject(gun);
        }
    }
    
    /**
     * Check for Sword
     */
    public void checkForSword()
    {
        sword = getOneIntersectingObject(Sword.class);
        if(sword != null){
            swordState.setSwordState(); // set the sword state to either half or full depending on the current state of sword.
            notifyObservers("sword", m);
            getWorld().removeObject(sword);
        }
    }
    
    /**
     * Check for Zombie
     */
    public void checkForZombie()
    {
        zombie = getOneIntersectingObject(Zombie.class);
        if(zombie != null)
        {
            if(ItemCollectionObserver.hasSword){ // If human has a sword, kill and remove zombie
                notifyObservers("zombie", m);
                getWorld().addObject(blood, zombie.getX(), zombie.getY());
                getWorld().removeObject(zombie);
                swordState.setSwordState(); //set swordState = No Sword
                

            }
            else if(!ItemCollectionObserver.hasKit && !startDelay) // If the human does not have a kit to protect himself.
            {
                setImage("Blood Splatter.png");
                humanState.setState(); // Set humanState to deadState and display "Game Over" message and stop the game.
                //System.out.println(humanState);
                calculateScore();
                display();
                Greenfoot.stop();
            }
            else{ // if the human has a kit, start delay to give some time for human and zombie to move away from each other.
                startDelay = true;
                startDelayHumanWithKit();
            }
        }
    }
    
    /**
     * Calculate score when game is over
     */
    public void calculateScore(){
        int score = 0;
        int food = ItemCollectionObserver.foodCount;
        int foodScore = food*5;
        int zombiesKilled = ItemCollectionObserver.zombieKilled;
        int zombieScore = zombiesKilled*10;
        StringBuilder s = new StringBuilder();
        
        s.append("Food Collected : "+food+" X 5 = "+foodScore+"\n");
        s.append("Zombies Killed : "+zombiesKilled+" X 10 = "+zombieScore+"\n");
        s.append("Total Score = "+(foodScore+zombieScore));
        //System.out.println(s.toString());
        m.setText(s.toString());
        m.setLocation(550, 350);
    }
    
    /**
     * Start delay Human with Kit
     */
    public void startDelayHumanWithKit() // if the human has a kit, start delay to give some time for human and zombie to move away from each other.
    {
         if(startDelay){
            delayCount2++;
        }
        
        if(delayCount2==1)
            notifyObservers("kit", m);
        
            if(delayCount2 > 100){
            startDelay = false;
            delayCount2 = 0;
        }
    }

    /**
     * Observer pattern
     */
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
    
    
    /**
     * State pattern for Human state
     */
    public void display() {
        humanState.display();
    }
    void setState(iHumanState state) {
        //System.out.println("received"+state);
        this.humanState = state;
    }
    iHumanState getHumanAliveState()
    {
        return humanAliveState;
    }    
    iHumanState getHumanDeadState()
    {
        return humanDeadState;
    }
    
    
}