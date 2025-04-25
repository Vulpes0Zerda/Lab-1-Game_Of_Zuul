package zuul;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import zuul.items.Inventory;
import zuul.items.Item;
import zuul.world.Room;

public class GameStatus
{
    private Room currentRoom;
    private Room beamer;
    private Set<Room> visited;
    private ArrayList<Room> history;
    private Inventory inventory;
    private MoveCounter moveCounter;
    private boolean playing = true;

    public GameStatus(Room initialRoom){
        inventory = new Inventory();
        visited = new HashSet<>();
        this.moveCounter = new MoveCounter(50);
        history = new ArrayList<>();

        setLocation(initialRoom);
    }

    public String setLocation(Room room){
        history.add(currentRoom);
        currentRoom = room; 
        return recordVisited(room);
    }


    private String recordVisited(Room room){
        String visitedAllRooms = "\nCongrats! You've visited all Rooms";

        visited.add(room);
        
        if (visited.size() == Room.getRoomCounter()){
            String result = visitedAllRooms;
            visitedAllRooms = ""; // should never be shown again!
            return result;
        }
        return "";
    }

    public Room getLocation(){
        return currentRoom;
    }

    /**
    *  Lets the player go back a number of steps
    *  <p>
    *  Returns true and moves the player back to the selected room, if the stepsBack range is in bound.
    *  Returns false if stepsBack is not applic
    *
    * @param  stepsBack  the number of steps to go back in the history
    * @return            true if the process succeeded, false if it failed
    */
    public boolean goBack(int stepsBack){
        if (history.size() <= stepsBack || 1 > stepsBack)
            return false;
        
        currentRoom = history.get(history.size()-stepsBack);

        for (int i = 0; i < stepsBack; i++) {
            history.remove(history.size()-1);
        }

        return true;
    }

    public void chargeBeamer(){
        beamer = currentRoom;
    }

    public boolean fireBeamer(){
        if (beamer == null) return false;
        setLocation(beamer);
        beamer = null;
        return false;
    }

    public String getLocationDescription(){
        return "You are " +currentRoom.getDescription();
    }

    public void quit(){playing = false;}

    public boolean isPlaying(){return playing;}

    public void addItemToInventory(Item item){inventory.add(item);}

    public String getInventoryDescription(){return "Your inventory:\n"+inventory.getDescription();}

    public Inventory getInventory(){return inventory;}

    public int maxCarryWeight() {
        // 20kg
        return 20000;
    }
}
