package zuul.commands;

import zuul.GameStatus;
import zuul.items.Equippables;

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

        Equippables item = gameStatus.getInventory().getEquippable(itemName);
        if (item == null) {
            return "item " + itemName + " does not exist or is not in your inventory";
        }

        gameStatus.getPlayer().equipItem(item); //getPlayer muss noch in die Player Klasse
        return item.getName() + " equipped";
    }
}
