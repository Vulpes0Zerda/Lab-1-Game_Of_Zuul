package zuul.items;

public class Equippables extends Item {
    private int durability;
    private String slot;

    public Equippables(String name, String description, int weight, int durability, String slot) {
        super (name, description, weight);
        this.durability = durability;
        this.slot = slot;
    }

    public String getSlot() {
      return slot;
    }

    public int getDurability() {
      return durability;
    }

}
