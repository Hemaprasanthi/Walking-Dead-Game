import greenfoot.*;

public class FoodFactory extends Creator  
{
   public Actor getActor(){
    return new Food();
    }
}
