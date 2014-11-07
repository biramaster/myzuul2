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
public class TakeAction implements Action
{

    @Override
    public boolean performAction(Command command) {
        System.out.println("You take the " + command.getSecondWord());
        return true;
    }
    
}
