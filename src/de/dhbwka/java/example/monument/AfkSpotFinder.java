package de.dhbwka.java.example.monument;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class AfkSpotFinder {
    private static final List<Position> MONUMENT_POSITIONS = List.of(new Position(377760,-2286208), new Position(377856,-2286080), new Position(377728,-2286016));
    private static final int MONUMENT_SIZE = 58;
    private static final List<Region> MONUMENT_REGIONS = new ArrayList<>();
    static {
        MONUMENT_POSITIONS.forEach(pos-> MONUMENT_REGIONS.add(new Region(new Position(pos.x()+MONUMENT_SIZE/2-1,pos.y()+MONUMENT_SIZE/2-1),new Position(pos.x()-MONUMENT_SIZE/2, pos.y()-MONUMENT_SIZE/2))));
    }
    private static final Region SEARCH_REGION = new Region(new Position(377823,-2286049), new Position(377680,-2286176));
    public static void main(String[] args) {
        AtomicReference<Position> bestPos = new AtomicReference<>(Position.ORIGIN);
        AtomicInteger bestSpawningSpaces = new AtomicInteger();
        SEARCH_REGION.forEach(afkPos->{
            AtomicInteger spawningSpaces = new AtomicInteger(0);
            Region sphere=new Region(new Position(afkPos.x()+130, afkPos.y()+130), new Position(afkPos.x()-130,afkPos.y()-130));
            sphere.stream().filter(pos->pos.distance(afkPos)<=128).filter(pos->MONUMENT_REGIONS.stream().anyMatch(reg->reg.isInside(pos))).forEach(pos->spawningSpaces.getAndIncrement());
            if(spawningSpaces.get()> bestSpawningSpaces.get()){
                bestSpawningSpaces.set(spawningSpaces.get());
                bestPos.set(afkPos);
            }
        });
        System.out.println(bestSpawningSpaces);
        System.out.println(bestPos);
    }

    private record Region(Position positiveCorner, Position negativeCorner)implements Iterable<Position>{
        private boolean isInside(Position pos){
            return pos.x()>=negativeCorner.x()&&pos.y()>=negativeCorner.y()&&pos.x()<=positiveCorner.x()&&pos.y()<=positiveCorner.y();
        }
        @Override
        public Iterator<Position> iterator() {
            return new RegionIterator();
        }

        public Stream<Position> stream() {
            return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED), false);
        }

        private class RegionIterator implements Iterator<Position> {
            private int currentX = negativeCorner.x();
            private int currentY = negativeCorner.y();

            @Override
            public boolean hasNext() {
                return currentY <= positiveCorner.y() && currentX <= positiveCorner.x();
            }

            @Override
            public Position next() {
                Position currentPosition = new Position(currentX, currentY);
                if (currentX < positiveCorner.x()) {
                    currentX++;
                } else {
                    currentX = negativeCorner.x();
                    currentY++;
                }
                return currentPosition;
            }
        }
    }
}
