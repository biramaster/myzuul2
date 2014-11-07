package myzuul2;

/**
 * A TransporterRoom is a room that will automatically transport you 
 * to another room when you try to leave it.
 * 
 * @author  Michael Kolling and David J. Barnes (modified by Thomas Ejnefj�ll)
 * @version 2013.10.25
 */
public class TransporterRoom extends Room
{
	private Scenario scene;

	/**
	 * Create a room that can beam you anywhere.
	 * 
	 * @param description The room's description
	 * @param scene The current scenario
	 */
	public TransporterRoom(String description, Scenario scene)
	{
	    super(description);
	    this.scene = scene;
	}

    /*
     * Describe the exits. Since this is a transporter room, you see no
     * clear exits.
     */
	@Override
    public String getExitString()
    {
        return "You feel quite dizzy. Something is strange.\n" +
               "You cannot really see the exits...";
    }

    /**
     * Returns a random room independent of the
     * direction
     * @param direction The exit's direction.
     * @return A random room.
     */
    public Room getExit(String direction) 
    {
        return scene.getRandomRoom();
    }
}