package zuul.server.world;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import zuul.server.items.Inventory;
import zuul.server.items.Item;
import zuul.server.items.Equippables;


public class Player {
  private static final int maxCarryWeight = 22000;
  private HashMap<String, Equippables> equippedItems;
  private Inventory inventory;
  private Room currentRoom;
  private Room beamer;
  private Set<Room> visited;
  private ArrayList<Room> history;

  public Player(Room initialRoom){
    equippedItems = new HashMap<String, Equippables>();
    equippedItems.put("Helmet", null);
    equippedItems.put("Breastplate", null);
    equippedItems.put("Gloves", null);
    equippedItems.put("Leggings", null);
    equippedItems.put("Boots", null);
    equippedItems.put("Hand", null);
    equippedItems.put("Off-hand", null);
    inventory = new Inventory();
    visited = new HashSet<>();
    history = new ArrayList<>();
    setLocation(initialRoom);
  }

  public String setLocation(Room room){
    history.add(currentRoom);
    currentRoom = room; 
    return recordVisited(room);
  }

  private String recordVisited(Room room){
    String visitedAllRooms = "\nCongrats! You've visited all Rooms\n";

    visited.add(room);
    
    if (visited.size() == Room.getRoomCounter()){
      String result = visitedAllRooms;
      visitedAllRooms = ""; // should never be shown again!
      return result;
    }
    return "";
  }

  public boolean addItemToInventory(Item pickedUpItem){
    if (inventory.getWeight()+pickedUpItem.getWeight() > maxCarryWeight){
      return false;
    }else{
      inventory.add(pickedUpItem);

      return true;
    }
  }

  public boolean equipItem(Equippables toEquip){

    if(equippedItems.get(toEquip.getSlot())!= null){

      inventory.add(equippedItems.get(toEquip.getSlot()));
      equippedItems.put(toEquip.getSlot(),toEquip);
      inventory.remove(toEquip.getName());
      return true;

    }else if(equippedItems.get(toEquip.getSlot())== null){

      equippedItems.put(toEquip.getSlot(),toEquip);
      inventory.remove(toEquip.getName());
      return true;

    }else{

      return false;
    }
  }

  /**
  *  Lets the player go back a number of steps
  *  <p>
  *  Returns true and moves the player back to the selected room, if the stepsBack range is in bound.
  *  Returns false if stepsBack is not applic
  
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
  
  public Inventory getInventory() {
    return inventory;
  }

  public Room getLocation(){
    return currentRoom;
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

  public int getMaxCarryWeight(){
    return maxCarryWeight;
  }
}
