package Entitys;

import GameMap.Coordinates;

public abstract class Entity {
    protected String design;
    protected Coordinates coordinates;

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return design;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Entity that = (Entity) obj;
        if (!this.coordinates.equals(that.coordinates))
            return false;
        return this.design.equals(that.design);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = result * 31 + design.hashCode();
        result = result * 31 + coordinates.hashCode();
        return result;
    }
}
