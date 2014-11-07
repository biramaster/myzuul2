package myzuul2;

/**
 * Representations for all the valid command words for the game
 * 
 * @author  Michael K�lling and David J. Barnes (Modified by Thomas Ejnefj�ll)
 * @version 2013.10.25
 */
public enum CommandWord
{
    // A value for each command word along with its
    // corresponding user interface string.
    GO("go"), QUIT("quit"), HELP("help"), UNKNOWN("?"), TAKE("take");
    
    // The command string.
    private String commandString;
    
    /**
     * Initialise with the corresponding command string.
     * @param commandString The command string.
     */
    private CommandWord(String commandString)
    {
        this.commandString = commandString;
    }
    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public static CommandWord getCommandWord(String commandWord)
    {
        CommandWord command = CommandWord.UNKNOWN;
        
        for(CommandWord c : CommandWord.values()) {
            if(c.toString().equalsIgnoreCase(commandWord)) {
                command = c;
            }
        }        
        return command;
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if the String is a valid command word, false if it is not
     */
    public static boolean isCommand(String aString)
    {
        boolean isCommand = false;
        
        for(CommandWord command : CommandWord.values()) {
            if(command.toString().equalsIgnoreCase(aString)) {
                isCommand = true;
            }
        }
        return isCommand;
    }

    /**
     * Returns all valid commands
     */
    public static String allCommands() 
    {
        String commandWords = "";
        for(CommandWord command : CommandWord.values()) {
            commandWords += command + "  ";
        }
        return commandWords;
    }
    /**
     * @return The command word as a string.
     */
    public String toString()
    {
        return commandString;
    }
}
