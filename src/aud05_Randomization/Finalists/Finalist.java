package aud05_Randomization.Finalists;

import java.util.Objects;

public class Finalist {
    private int id;
    public Finalist(int id){
        this.id=id;
    }

    @Override
    public String toString() {
        return String.format("Finalist %d",id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Finalist finalist = (Finalist) o;
        return id == finalist.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

