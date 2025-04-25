package zuul.commands;

import zuul.GameStatus;
import zuul.items.Item;
import zuul.world.Player;

public class Take extends Command
{
    public Take(String parameter){
        super(parameter);
    }

    @Override
    public String commandImplementation(GameStatus gameStatus){

        if(!hasParameter()) {
            // if there is no second word, we don't know what to take...
            return "zuul.commands.Take what?";
        }

        String itemName = getParameter();

        // Try to take the item.
        Item item = gameStatus.getPlayer().getLocation().removeItem(itemName);

        if (item == null) {
            return "There is no "+itemName+"!";
        }

        Player player = gameStatus.getPlayer();

        if (player.addItemToInventory(item)){
            return "You cannot pick up the "+item.getName()+" - it's too heavy.("+item.getWeight()+")\nYou are already carrying "+player.getInventory().getWeight()+" kg!\n";
        }
        else {
            return "You took the "+ item.getName()+"\n";
        }
    }
}
