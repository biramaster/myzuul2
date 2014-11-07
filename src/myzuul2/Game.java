package myzuul2;

import java.util.HashMap;
import java.util.Map;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael K�lling and David J. Barnes
 * @version 2011.08.10
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private Scenario scenario;
    
    private Map<CommandWord, Action> mActions;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        scenario = new Scenario();
        parser = new Parser();
        currentRoom = scenario.getStartRoom();
        
        mActions = new HashMap<>();
        mActions.put(CommandWord.GO, new GoAction(currentRoom));
        mActions.put(CommandWord.UNKNOWN, new UnknownAction());
        mActions.put(CommandWord.HELP, new HelpAction(parser));
        mActions.put(CommandWord.QUIT, new QuitAction());
        mActions.put(CommandWord.TAKE, new TakeAction());
    }
    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
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
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        CommandWord commandWord = command.getCommandWord();

        return !mActions.get(commandWord).performAction(command);
    }
}
