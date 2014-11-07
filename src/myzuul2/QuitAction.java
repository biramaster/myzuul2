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
public class QuitAction implements Action
{
    @Override
    public boolean performAction(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return true;
        }
        else {
            return false;  // signal that we want to quit
        }
    }
}
