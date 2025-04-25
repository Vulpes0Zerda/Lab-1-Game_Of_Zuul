package zuul;

import zuul.world.Player;
import zuul.world.Room;

public class GameStatus
{
    private Player currentPlayer;
    private boolean playing = true;
    
    public GameStatus(Room initialRoom){
        currentPlayer = new Player(initialRoom);
    }


    public void stopPlaying(){playing = false;}

    public boolean isPlaying(){return playing;}

    public Player getPlayer(){
        return currentPlayer;
    }
}
