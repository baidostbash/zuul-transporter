import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a game scenario including connected rooms and items
 * 
 * @author Cara Tang
 * @version 2013.02.16
 */
public class Scenario
{
    private ArrayList<Room> rooms;
    private Room startRoom;
    private Random random;
    private Room outside, snake, frozen, spikes, fire, dark, quiet;

    /**
     * Constructor for objects of class Scenario
     */
    public Scenario()
    {
        random = new Random();
        
        // Set up your rooms, exits, and items
        // Move code from Game.createRooms here
        /**
         * Create all the rooms and link their exits together.
         */

        // create the rooms
        outside = new Room("outside! You won! ");
        snake = new Room("in snake room");
        frozen = new Room("in the frozen room");
        spikes = new Room("in the spikes room");
        fire = new Room("in the fire room");
        dark = new Room("in the dark room");
        quiet = new Room("in the quiet room");

        // initialise room exits
        snake.setExit("east", frozen);
        frozen.setExit("north", fire);
        frozen.setExit("south", spikes);
        spikes.setExit("north",frozen);
        fire.setExit("east", dark);
        fire.setExit("south", frozen);
        dark.setExit("south", quiet);
        dark.setExit("west", fire);
        quiet.setExit("north", dark);
        quiet.setExit("east", outside);
        quiet.setExit("west", frozen);

        // initialise room items
        fire.addItem("torch", 2.0);

        // Set the start room
        startRoom = frozen;  // start game in a frozen room




        // Create the rooms ArrayList and add all your rooms to it

    }

    /**
     * @return  the start room for this scenario
     */
    public Room getStartRoom()
    {
        return startRoom;
    }
    
    /**
     * @return  a random room from this scenario
     */
/**
*  public Room getRandomRoom()
*    {
*    // complete this method
*}
*/

}
