package zuul;

import zuul.world.Player;
import zuul.world.Room;

public class GameStatus
{

    private Player currentPlayer;
    private MoveCounter moveCounter;

    private boolean playing = true;

    public GameStatus(Room initialRoom){
        currentPlayer = new Player(initialRoom);
        this.moveCounter = new MoveCounter(50);
    }


    public void stopPlaying(){playing = false;}

    public boolean isPlaying(){return playing;}

    public Player getPlayer(){
        return currentPlayer;
    }
}
