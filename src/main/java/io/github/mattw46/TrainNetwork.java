/*
 * TrainNetwork contains data and methods or access data
 * for the train network.
 */
package io.github.mattw46;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthew Wall
 */
public class TrainNetwork {
    // Map stations (chars) to internal representation
    private final int A = 0;
    private final int B = 1;
    private final int C = 2;
    private final int D = 3;
    private final int E = 4;
    
    char[] indexCharacter = {'A', 'B', 'C', 'D', 'E'};
    
    public final int stationCount = 5;
    
    // Adjacencey matrix to store station links
    private int[][] network;
    
    /* initialise adjacencey matrix with links distance 
     * data is hard coded into the Constructor
     * 0 used where no link exists
    */
    public TrainNetwork() {
        network = new int[stationCount][stationCount];
        
        for (int i = 0; i < stationCount; i++) {
            for (int j = 0; j < stationCount; j++) {
                network[i][j] = 0;
            }
        }
        
        network[A][B] = 5;
        network[B][C] = 4;
        network[C][D] = 8;
        network[D][C] = 8;
        network[D][E] = 6;
        network[A][D] = 5;
        network[C][E] = 2;
        network[E][B] = 3;
        network[A][E] = 7;
    }
    
    /* Convert station to matrix index
     * returns the offset between first station A
     * and station parameter to obtain an index between
     * 0 and 4 inclusive
    */
    private int mapStation(char station) { // convert back to private
        return Math.abs('A' - station);
    }
    
    // test if link from start to end is valid
    public boolean isValidLink(char start, char end) {
        return network[mapStation(start)][mapStation(end)] > 0;
    }
    
    // returns the distance between stations or 0 where no link exists
    public int getLinkDistance(char start, char end) {
        return network[mapStation(start)][mapStation(end)];
    }
    
    // Returns the number of routes with stops less than maxStops
    public int getNumberRoutes(char start, char end, int maxStops) {
        int startIndex = mapStation(start);
        int endIndex = mapStation(end);
        int stops = 0;
        
        return 0;
    }
    
    // return true if path from start to end found in less than max stops
    public boolean validPathUnderMax(char start, char end, int max) {
        int from = mapStation(start);
        int to = mapStation(end);
        int stops = 0;
         
        return findPath(from, to, stops, max);
    }
    
    private boolean findPath(int from, int to, int stopCount, int maxStops) {
        boolean result = false;
        
        // check for base case and return if true
        if (from == to && stopCount <= maxStops) {
            return true;
        }
        
        // get list of connections with from
        System.out.println("get connections from: " + from + " to " + to);
        List<Integer> connections = getIndexFrom(from);
        
        // interate list and check if criteria is met or exceeded
        for (Integer current : connections) {
            //System.out.println("current: " + current + " to " + indexCharacter[to]);
            if (current == to) {
                if (stopCount + 1 <= maxStops) {
                    System.out.println("Found path: " + indexCharacter[from] + " to " + indexCharacter[to]);
                    return true;
                }
                else {
                    return false;
                }
            }
            else if (stopCount + 1 > maxStops) {
                return false;
            }
            
            // recusively check next connections
            //System.out.println("Calling findPath(" + mapStation(current) + " " + to + ")");
            result = findPath(current, to, stopCount + 1, maxStops);
            if (result == true) {
                return result;
            }
            
            return false;
        }
        
        
        
        return false;
    }
    
    // return true if path from start to end if stop count matches stops
    public boolean validPathMatching(char start, char end, int stops) {
        
        return false;
    }
    
    // Returns path length where less than max length
    private int getPathBelowMax(char start, char end, int maxStops) {
        return 0;
    }
    
    // Returns true if path length is exact distance
    private boolean getPathWithLength(char start, char end, int stops) {
        return false;
    }
    
    // Returns list of stations connected to from station
    public List<Character> getConnectionsFrom(char fromStation) {
        List<Character> stations = new ArrayList<Character>();
        int fromIndex = mapStation(fromStation);
        for (int i = 0; i < stationCount; i++) {
            if (network[fromIndex][i] > 0) {
                System.out.println("adding " + indexCharacter[i]);
                stations.add(indexCharacter[i]);
            }
        }
        return stations;
    }
    
    // Returns list of stations connected to from station
    private List<Integer> getIndexFrom(int fromIndex) {
        List<Integer> stations = new ArrayList<Integer>();
        
        for (int i = 0; i < stationCount; i++) {
            if (network[fromIndex][i] > 0) {
                System.out.println("adding " + indexCharacter[i]);
                stations.add(i);
            }
        }
        return stations;
    }
}
