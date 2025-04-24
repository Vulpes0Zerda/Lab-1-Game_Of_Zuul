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
            return "was möchtest du ausrüsten?";
        }
        String itemName = getParameter(); //jacket, hat?

        Equippables item = gameStatus.getInventory().getEquippable(itemName);
        if (item == null) {
            return "item " + itemName + " existiert nicht oder ist nicht in deinem Inventar";
        }

        gameStatus.getPlayer().equipItem(item); //getPlayer muss noch in die Player Klasse
        return item.getName() + " ausgeüstet";
    }
}
