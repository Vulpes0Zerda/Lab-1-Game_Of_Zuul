package zuul.commands;
import zuul.GameStatus;

public class Back extends Command
{
    public Back(String parameters){
        super(parameters);
    }

    @Override
    public String commandImplementation(GameStatus gameStatus){
        
        if (isNumeric(getParameter())){
            int convertedInt = Integer.parseInt(getParameter());
            if(gameStatus.goBack(convertedInt))
                return gameStatus.getLocationDescription();
            return "You cannot go back any further.";
        }else if(!hasParameter()){
            if(gameStatus.goBack(1))
                return gameStatus.getLocationDescription();
            return "You cannot go back any further.";
        }else{
            return getParameter()+" is not a Number.\nPlease enter the number steps you wanna go back or leave it blank to go back one room.";
        }
    }
    public boolean isNumeric(String checkString) {
        try {
            Integer.parseInt(checkString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
