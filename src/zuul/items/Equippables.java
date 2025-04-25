package zuul.items;

public class Equippables extends Item {
    private int someValue;
    private String slot;

    public Equippables(String name, String description, int weight, int someValue, String slot) { //welchen Value wollen wir?
        super (name, description, weight);
        this.someValue = someValue;
        this.slot = slot;
    }
}
