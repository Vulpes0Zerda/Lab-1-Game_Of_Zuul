package zuul.server.commands;

import zuul.server.items.Equippables;
import zuul.server.GameStatus;

public class Equip extends Command {

    public Equip(String parameter) {
        super (parameter);
    }

    @Override
    public String commandImplementation(GameStatus gameStatus) {
        if (!hasParameter()) {
            return "what would you like to equip?";
        }
        String itemName = getParameter(); //jacket, hat?

        Equippables item = gameStatus.getPlayer().getInventory().getEquippable(itemName);
        if (item == null) {
            return itemName + " does not exist or is not in your inventory.\n";
        }else{
            if(gameStatus.getPlayer().equipItem(item)){
                return itemName + " is equipped now.\n";
            }else{
                return itemName + " could not be equipped.\n";
            }
        }
    }
}
