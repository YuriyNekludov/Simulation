package GameMap;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Coordinates that = (Coordinates) obj;
        return this.x == that.x && this.y == that.y;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + y;
        result = result * 31 + x;
        return result;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }
}
