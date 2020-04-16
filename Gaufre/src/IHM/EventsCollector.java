package IHM;

public interface EventsCollector {
    boolean mouseClick(int l, int c);
    boolean endGame();
    void changeGameBoard(Board b);
    void sendPlayerCurrent();
    void playerChange(int index);
}
