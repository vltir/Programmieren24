package de.dhbwka.java.example.monument;

import java.util.Objects;

public record Position(int x, int y) implements Comparable<Position>{
    public static Position ORIGIN = new Position(0,0);

    public double distance(Position other) {
        long dx = (long) this.x - other.x;
        long dy = (long) this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position position)) return false;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public int compareTo(Position o) {
        return Double.compare(this.distance(ORIGIN), o.distance(ORIGIN));
    }

    public record PositionTuple(Position pos1, Position pos2) implements Comparable<PositionTuple>{

        @Override
        public int compareTo(PositionTuple o) {
            return this.pos1.compareTo(o.pos1);
        }

        public double distance(PositionTuple other){
            double dist = this.pos1.distance(other.pos1);
            dist = Math.min(dist,this.pos1.distance(other.pos2));
            dist = Math.min(dist,this.pos2.distance(other.pos1));
            dist = Math.min(dist,this.pos2.distance(other.pos2));
            return dist;
        }

        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PositionTuple other)) return false;
            return (Objects.equals(pos1, other.pos1) && Objects.equals(pos2, other.pos2)) ||
                    (Objects.equals(pos1, other.pos2) && Objects.equals(pos2, other.pos1));
        }

        @Override
        public int hashCode() {
            // Use a prime number to combine the hash codes
            int prime = 31;
            int hash1 = pos1.hashCode();
            int hash2 = pos2.hashCode();
            return prime * (hash1 + hash2);
        }
    }

    public record PositionTriple(Position pos1, Position pos2, Position pos3) implements Comparable<PositionTriple>{
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof PositionTriple other)) return false;
            return (Objects.equals(pos1, other.pos1) && Objects.equals(pos2, other.pos2) && Objects.equals(pos3, other.pos3)) ||
                    (Objects.equals(pos1, other.pos1) && Objects.equals(pos2, other.pos3) && Objects.equals(pos3, other.pos2)) ||
                    (Objects.equals(pos1, other.pos2) && Objects.equals(pos2, other.pos1) && Objects.equals(pos3, other.pos3)) ||
                    (Objects.equals(pos1, other.pos2) && Objects.equals(pos2, other.pos3) && Objects.equals(pos3, other.pos1)) ||
                    (Objects.equals(pos1, other.pos3) && Objects.equals(pos2, other.pos1) && Objects.equals(pos3, other.pos2)) ||
                    (Objects.equals(pos1, other.pos3) && Objects.equals(pos2, other.pos2) && Objects.equals(pos3, other.pos1));
        }

        @Override
        public int hashCode() {
            // Use a prime number to combine the hash codes
            int prime = 31;
            int hash1 = pos1.hashCode();
            int hash2 = pos2.hashCode();
            int hash3 = pos3.hashCode();
            return prime * (hash1 + hash2 + hash3);
        }

        @Override
        public int compareTo(PositionTriple o) {
            return this.pos1.compareTo(o.pos1);
        }
    }
}
