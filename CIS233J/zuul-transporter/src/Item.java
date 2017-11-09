
/**
 * This is a Item class which creates an item for the rooms.
 *
 * @author (Sam Shokrollahi)
 * @version (2017/10/12)
 */
public class Item
{
    // instance variables 
    private String description;
    private double weight;
    

    /**
     * Constructor for objects of class Item.
     * @param description and weight.
     */
    public Item(String description, double weight )
    {
        // initialise instance variables
        this.description = description;
        this.weight = weight;
        
    }
    
    /**
     * @return description of item.
     */
    public String getDescription()
    {
        return description;
    }
}
