package zuul.server.commands;
import zuul.server.GameStatus;

public class Beamer extends Command
{
    public Beamer(String parameters){
        super(parameters);
    }

    public String commandImplementation(GameStatus gameStatus){
        if(!hasParameter()){
            return "to use the beamer, charge it with the current room ('beamer charge').\n"
            + "You can then go back to this room by typing 'beamer fire'\n";
        }

        switch(getParameter()){
            case "charge":
                gameStatus.getPlayer().chargeBeamer(); 
                return "The beamer was loaded with your current location. \n";
            case "fire" : 
                if (gameStatus.getPlayer().fireBeamer()) 
                return "The beamer beamed you back.\n"+gameStatus.getPlayer().getLocationDescription()+"\n";
                else return "The beamer was not loaded.\n";
            default: 
                return "The beamer can be charge d or fire d.\n";
            }
        }
    }
