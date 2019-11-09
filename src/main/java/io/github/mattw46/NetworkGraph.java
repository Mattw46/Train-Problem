/*
 * NetworkGraph contains the adjacencey matrix which stores the data.
 * also provides methods to access data
 */
package io.github.mattw46;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Matthew Wall
 */
public class NetworkGraph {
    private final char[] indexCharacter = {'A', 'B', 'C', 'D', 'E'};
    public final int stationCount = 5;
    
    // Adjacencey matrix to store station links
    private int[][] network;
    
    private Map<Character,Integer> stationIndex;
    
    public NetworkGraph() {
        // initialise array
        network = new int[stationCount][stationCount];
        for (int i = 0; i < stationCount; i++) {
            for (int j = 0; j < stationCount; j++) {
                network[i][j] = 0;
            }
        }
        
        stationIndex = new HashMap<Character,Integer>();
        stationIndex.put('A', 0);
        stationIndex.put('B', 1);
        stationIndex.put('C', 2);
        stationIndex.put('D', 3);
        stationIndex.put('E', 4);
        
        // add station links
        network[stationIndex.get('A')][stationIndex.get('B')] = 5;
        network[stationIndex.get('B')][stationIndex.get('C')] = 4;
        network[stationIndex.get('C')][stationIndex.get('D')] = 8;
        network[stationIndex.get('D')][stationIndex.get('C')] = 8;
        network[stationIndex.get('D')][stationIndex.get('E')] = 6;
        network[stationIndex.get('A')][stationIndex.get('D')] = 5;
        network[stationIndex.get('C')][stationIndex.get('E')] = 2;
        network[stationIndex.get('E')][stationIndex.get('B')] = 3;
        network[stationIndex.get('A')][stationIndex.get('E')] = 7;
    }
    
    /* Returns the distance between two directly connected stations */
    public int getLinkDistance(char start, char end) {
        return network[stationIndex.get(start)][stationIndex.get(end)];
    }
    
    /* Return true if valid link between start and end */
    public boolean isValidLink(char start, char end) {
        return network[stationIndex.get(start)][stationIndex.get(end)] > 0;
    }
    
    /* Returns a list of stations with connects to from parameter */
    public List<Character> getConnectionsFrom(char from) {
        List<Character> stops = new ArrayList<Character>();
        
        int fromIndex = stationIndex.get(from);
        for (int i = 0; i < 5; i++) {
            if (network[fromIndex][i] > 0) {
                stops.add(indexCharacter[i]);
            }
        }
        return stops;
    }
   
}