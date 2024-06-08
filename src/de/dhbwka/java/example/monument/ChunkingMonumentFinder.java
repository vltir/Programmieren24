package de.dhbwka.java.example.monument;

import java.util.*;

public class ChunkingMonumentFinder {
    private static int MAX_DISTANCE =195;
    private static int CHUNK_SIZE = 1000;

    public static void main(String[] args) {
        //parse positions
        Set<Position> positions = InputParser.parsePositions();
        System.out.printf("%d Monuments parsed%n",positions.size());
        //organize positions into chunks
        Map<ChunkPosition, ArrayList<Position>> monumentTable=new HashMap<>();
        for (Position pos : positions) {
            ChunkPosition chunkPos=new ChunkPosition(pos.x()/1000,pos.y()/1000);
            if (!monumentTable.containsKey(chunkPos))monumentTable.put(chunkPos,new ArrayList<>());
            monumentTable.get(chunkPos).add(pos);
        }
        System.out.printf("loaded Monuments into %d chunks%n",monumentTable.size());
        //create Tuples set of adjacent monuments
        Set<Position.PositionTuple> adjacentPairSet = new HashSet<>();
        monumentTable.forEach((k,v)->{
            //get 3x3 monuments
            List<Position> positions3x3 = new ArrayList<>();
            for (int x = k.x()-1; x < k.x()+1; x++) {
                for (int y = k.y()-1; y < k.y()+1; y++) {
                    ChunkPosition iterateChunk = new ChunkPosition(x,y);
                    if(monumentTable.containsKey(iterateChunk)){
                        positions3x3.addAll(monumentTable.get(iterateChunk));
                    }
                }
            }
            for (Position pos : v) {
                positions3x3.stream().filter(p->(!pos.equals(p))&&pos.distance(p)<=MAX_DISTANCE).forEach(p->adjacentPairSet.add(new Position.PositionTuple(pos, p)));
            }
        });
        System.out.printf("Found %d monument Pairs%n",adjacentPairSet.size());
        //sort monumentPairs by distance to (0,0)
        List<Position.PositionTuple> monumentPairs = new ArrayList<>(adjacentPairSet.stream().toList());
        Collections.sort(monumentPairs);
        System.out.printf("Found closest Monument Pair at x:%d z:%d and at x:%d z:%d%n",monumentPairs.getFirst().pos1().x(),monumentPairs.getFirst().pos1().y(),monumentPairs.getFirst().pos2().x(),monumentPairs.getFirst().pos2().y());
        //Load monument paris into chunks
        Map<ChunkPosition, ArrayList<Position.PositionTuple>>monumentPairTable = new HashMap<>();
        for (Position.PositionTuple posPair : monumentPairs) {
            ChunkPosition chunkPos=new ChunkPosition(posPair.pos1().x()/1000,posPair.pos1().y()/1000);
            if (!monumentPairTable.containsKey(chunkPos))monumentPairTable.put(chunkPos,new ArrayList<>());
            monumentPairTable.get(chunkPos).add(posPair);
        }
        Set<Position.PositionTriple> monumentTriples = new HashSet<>();
        monumentPairTable.forEach((k,v)->{
            //get 3x3 monuments
            List<Position.PositionTuple> positionTuples3x3 = new ArrayList<>();
            for (int x = k.x()-1; x < k.x()+1; x++) {
                for (int y = k.y()-1; y < k.y()+1; y++) {
                    ChunkPosition iterateChunk = new ChunkPosition(x,y);
                    if(monumentPairTable.containsKey(iterateChunk)){
                        positionTuples3x3.addAll(monumentPairTable.get(iterateChunk));
                    }
                }
            }
            //iterate over 3x3 Tuples
            for (Position.PositionTuple posTuple : v) {
                //Triple Monument filter
                positionTuples3x3.stream().filter(p->(!posTuple.equals(p))&&posTuple.distance(p)<=MAX_DISTANCE).forEach(pt->{
                    Set<Position>positionsOfTriple = new HashSet<>();
                    positionsOfTriple.add(pt.pos1());
                    positionsOfTriple.add(pt.pos2());
                    positionsOfTriple.add(posTuple.pos1());
                    positionsOfTriple.add(posTuple.pos2());
                    List<Position>positionsOfTripleList = positionsOfTriple.stream().toList();
                    monumentTriples.add(new Position.PositionTriple(positionsOfTripleList.getFirst(),positionsOfTripleList.get(1),positionsOfTripleList.get(2)));
                });
            }
        });
        System.out.printf("Found %d Monument Triples%n",monumentTriples.size());
        //sort monumentPairs by distance to (0,0)
        List<Position.PositionTriple> sortedTripleMonuments = new ArrayList<>(monumentTriples.stream().toList());
        Collections.sort(sortedTripleMonuments);
        Position.PositionTriple t = sortedTripleMonuments.getFirst();
        System.out.printf("Found closest Monument Triple at x:%d z:%d and at x:%d z:%d and at x:%d z:%d%n",t.pos1().x(),t.pos1().y(),t.pos2().x(),t.pos2().y(),t.pos3().x(),t.pos3().y());
        if(sortedTripleMonuments.size()<20){
            sortedTripleMonuments.forEach(System.out::println);
        }
    }
}
