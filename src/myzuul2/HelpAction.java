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
public class HelpAction implements Action
{
    private Parser mParser;
    
    public HelpAction(Parser parser)
    {
        mParser = parser;
    }
    
    @Override
        public boolean performAction(Command command) {
            System.out.println("You are lost. You are alone. You wander");
            System.out.println("around at the university.");
            System.out.println();
            System.out.println("Your command words are:");
            mParser.showCommands();
            return true;
        }
}
