package zuul.server.commands;

import zuul.server.GameStatus;
import zuul.server.items.Item;

public class Drop extends Command
{
    public Drop(String parameter){
        super(parameter);
    }

    @Override
    public String commandImplementation(GameStatus gameStatus){

        if(!hasParameter()) {
            // if there is no second word, we don't know what to take...
            return "zuul.commands.Drop what?";
        }

        String itemName = getParameter();

        // Try to take the item.
        Item item = gameStatus.getPlayer().getInventory().remove(itemName);
        

        if (item == null) {
            return"You have no "+itemName+"!";
        }
        else {
            gameStatus.getPlayer().getLocation().addItem(item);
            return "You dropped the "+ item.getName();
        }
    }
}
