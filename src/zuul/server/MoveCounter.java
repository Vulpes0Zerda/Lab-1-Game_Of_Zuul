package zuul.server;

public class MoveCounter {
    private int movesLeft;

    public MoveCounter(int startMoves) {
        this.movesLeft = startMoves;
    }
    public void decrement() {
        movesLeft --;
    }
    public int getMovesLeft() {
        return movesLeft;
    }
    public boolean isGameOver() {
        return movesLeft <= 0;
    }
}
