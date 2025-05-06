package zuul.server.commands;

import zuul.server.commands.Command;
import zuul.server.GameStatus;

/**
 * A zuul.commands.SimpleCommand just returns its output,
 * The gameStatus is never changed.
 */
public class SimpleCommand extends Command
{
    String output;
    public SimpleCommand(String parameters, String output){
        super(parameters);
        this.output = output;
    }
    @Override
    public String commandImplementation(GameStatus _gameStatus){
        return output;
    }

}
