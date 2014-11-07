/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myzuul2;

/**
 *
 * @author E44
 */
public class GoAction implements Action
{
    private Room mRoom;
    
    public GoAction(Room currentRoom)
    {
        mRoom = currentRoom;
    }
    
    @Override
        public boolean performAction(Command command) {
            if(!command.hasSecondWord()) {
                // if there is no second word, we don't know where to go...
                System.out.println("Go where?");
                return true;
            }

            String direction = command.getSecondWord();

            // Try to leave current room.
            Room nextRoom = mRoom.getExit(direction);

            if (nextRoom == null) {
                System.out.println("There is no door!");
            }
            else {
                mRoom = nextRoom;
                System.out.println(mRoom.getLongDescription());
            }
            return true;
        }
}
