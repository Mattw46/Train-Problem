/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
    
    /* returns link value between start and end
     * 0 is returned where no link exists
     */
    public int getLink(char start, char end) {
        return network[stationIndex.get(start)][stationIndex.get(end)];
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
    
    /* Returns a count of paths found with exact number of stops */
    public int getPathExactLength(char start, char end, int pathCount,
            int currentSteps, int maxSteps) {
        
        
        //System.out.println(start + "->" + end + " at: " + currentSteps);
        
        // check if current station is the destination
        if (start == end) {
            //System.out.println("Start == end");
            // if steps maxSteps met increment pathCount and return
            if (currentSteps == maxSteps) {
                //System.out.println("stop == maxStops: incrementing paths");
                pathCount++;
                return pathCount;
            }    
        }
        
        // if steps > maxSteps return current pathCount, path invalid
        if (currentSteps > maxSteps) {
            //System.out.println("maxSteps exceeded exiting");
            return pathCount;
        }
        
        currentSteps++; // increment steps taken
        
        // get list of next connections
        List<Character> connections = getConnectionsFrom(start);
        // for each connection call method
        for (Character next : connections) {
            pathCount = 
                    getPathExactLength(next, end, pathCount, currentSteps, maxSteps);
        }
        
        return pathCount;
    }
    
    /* Return a count of paths found with length up to defined limit  (wrapper method)*/
    public int getPathInLength(char start, char end, int maxSteps) {
        int pathCount = 0;
        int currentSteps = 1; // 1 accounts for first link
        
        // get list of next connections
        List<Character> connections = getConnectionsFrom(start);
        // for each connection call method
        for (Character next : connections) {
            pathCount = 
                    getPathInLength(next, end, pathCount, currentSteps, maxSteps);
        }
        
        return pathCount;
    }
    
    /* Return a count of paths found with length up to defined limit */
    private int getPathInLength(char start, char end, int pathCount,
            int currentSteps, int maxSteps) {
        
        // check if current station is the destination
        if (start == end) {
            // if steps maxSteps met increment pathCount and return
            if (currentSteps <= maxSteps) {
                pathCount++;
                return pathCount;
            }    
        }
        
        // if steps > maxSteps return current pathCount, path invalid
        if (currentSteps > maxSteps) {
            return pathCount;
        }
        
        currentSteps++; // increment steps taken
        
        // get list of next connections
        List<Character> connections = getConnectionsFrom(start);
        // for each connection call method
        for (Character next : connections) {
            pathCount = 
                    getPathInLength(next, end, pathCount, currentSteps, maxSteps);
        }
        
        return pathCount;
    }
    
    /* Wrapper method for getShortestPath */
    public int getShortestPath(char start, char end) {
        //int shortestLength = 0;
        int shortestPath = 0; // holds current shortestPath
        int currentSteps = 0; 
        int travelled = 0; // Distance travelled
        
        shortestPath = getShortestPath(start, end, shortestPath, currentSteps, travelled);
        
        return shortestPath;
    }
    
    private int getShortestPath(char start, char end, int shortestPath, int currentSteps, int travelled) {
        //System.out.println("Start: " + start + " end: " + end);
        
        // check base case, end reached and travel has occured (distance > 0)
        if (start == end && travelled > 0) { 
            if (travelled < shortestPath) {
                shortestPath = travelled; System.out.println("finished with path: " + travelled);
                return shortestPath;
            }
            else if (shortestPath == 0) { // check if shortestPath is still set to 0
                shortestPath = travelled;
                return shortestPath;
            }
            
        }
        // abort if shortestPath exceeded
        if (travelled > shortestPath && shortestPath != 0) {
            return shortestPath;
        }
        
        // get links
        List<Character> connections = getConnectionsFrom(start);
        
        for (char current : connections) {
            System.out.print(start + "->" + current + "->");
            
            travelled += getLink(start,current);
            shortestPath = getShortestPath(current, end, shortestPath, 0, travelled);
        }
        
        
        /*System.out.println(start + "->" + end + " travelled: " + travelled);
        
        if (start == end) {
            if (shortestPath == 0) {
                shortestPath = travelled;
                return shortestPath;
            }
            else if (travelled < shortestPath) {
                shortestPath = travelled;
                return shortestPath;
            }
            return shortestPath;
        }
        
        // get list of next connections
        List<Character> connections = getConnectionsFrom(start);
        // for each connection call method
        for (Character next : connections) {
            int nextLinkLength = network[stationIndex.get(start)][stationIndex.get(next)];
            if (nextLinkLength == 0) {
                return shortestPath;
            }
            else {
                travelled += nextLinkLength;
            }
            //travelled += network[stationIndex.get(start)][stationIndex.get(next)];
            
            
            shortestPath += 
                    getShortestPath(next, end, shortestPath, currentSteps, travelled);
        }*/
        
        System.out.println(" " + shortestPath);
        
        return shortestPath;
    }
}
