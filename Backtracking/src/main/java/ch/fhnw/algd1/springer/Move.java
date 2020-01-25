package ch.fhnw.algd1.springer;

public class Move implements Comparable {

    private int x;
    private int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public int compareTo(Object o) {
        if (o == null) return 1;
        Move that = (Move) o;
        Integer.compare(this.getX(), that.getX());
        return 0;
    }
}
