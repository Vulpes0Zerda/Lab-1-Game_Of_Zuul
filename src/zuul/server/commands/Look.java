package zuul.server.commands;

import zuul.server.GameStatus;

public class Look extends Command
{
    public Look(String parameters){
        super(parameters);
    }
    public String commandImplementation(GameStatus gameStatus){
        return gameStatus.getPlayer().getLocationDescription();
    }
}
