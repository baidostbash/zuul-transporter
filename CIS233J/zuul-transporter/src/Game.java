/**
 *  The Game class is the class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. 
 *  
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises the game: it creates all
 *  rooms, and items, and all classes to play the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Sam Shokrollahi
 * @version 2017.10.09
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;


        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        parser = new Parser();
        Scenario scenario = new Scenario();
        currentRoom = scenario.getStartRoom();
    }


    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly kill time game when you're bore.");
        System.out.println("Type 'help' if you need help.");
        System.out.println("you are in dangerous situation, find you way out to a safe palce, many room in the building and each on connect ot another, type go to start the game.");
        System.out.println("type the direction you want to go 'north', 'south', 'east', 'west'");
        System.out.println();
        printLocationInfo();
        System.out.println();
    }
    
    /**
     * Print information about the current location.
     */
    private void printLocationInfo() 
    {
       System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean endGame = false;

        if(command.isUnknown()) {
            System.out.println("I don't know what you mean...");
            printLocationInfo();
            System.out.println();
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
            printLocationInfo();
            System.out.println();
        }
        else if (commandWord.equals("go")) {
             goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            endGame = quit(command);
        }
        else if (commandWord.equals("look")) {
            look();
        }
        else if (commandWord.equals("rest")) {
            rest();
        }

        return endGame;
    }

    // implementations of user commands:

    /**
     * Print out room information.
     */
    private void look() {
        printLocationInfo();
        System.out.println();
    }
    
    /**
     * Print out rest information.
     */
    private void rest() {
        System.out.println("It too scary to rest here. You need to go outside to save your life!");
        System.out.println();
    }
    
    /**
     * Print out some help information.
     */
    private void printHelp() 
    {
        String[] commandWords;
        
        System.out.println("You are lost in dangours rooms. if you want to be free, you need to go outside");
        System.out.println();
        System.out.println("Your command words are:");
        commandWords = parser.getCommands(); 
        for(String word: commandWords) {
            System.out.print(word + " ");
        }
        System.out.println();
        System.out.println();
        //System.out.println("go north, go east, go south, go west, quit, help");
        
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     * @param command The command for direction.
     * @return boolean if game is finish.
     */
    private void goRoom(Command command)
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");

        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);
        

        if (nextRoom == null) {
            System.out.println("There is no door!");
            System.out.println();
        }
        else {
            currentRoom = nextRoom;
            printLocationInfo();
            System.out.println();
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @param command The command for Quit.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
