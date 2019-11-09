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
    NetworkGraph ng;
    
    /* initialise adjacencey matrix with links distance 
     * data is hard coded into the Constructor
     * 0 used where no link exists
    */
    public TrainNetwork() {
        ng = new NetworkGraph();
    }
    
    // test if link from start to end is valid
    public boolean isValidLink(char start, char end) {
        return ng.isValidLink(start, end);
    }
    
    // returns the distance between stations or 0 where no link exists
    public int getLinkDistance(char start, char end) {
        return ng.getLinkDistance(start, end);
    }
    
    // return true if path from start to end found in less than max stops
    public boolean validPathUnderMax(char start, char end, int max) {
        int stops = 0;
         
        return findPath(start, end, stops, max);
    }
    
    private boolean findPath(char from, char to, int stopCount, int maxStops) {
        boolean result = false;
        
        // check for base case and return if true
        if (from == to && stopCount <= maxStops) {
            return true;
        }
        
        // get list of connections with from
        List<Character> connections = ng.getConnectionsFrom(from);
        
        // interate list and check if criteria is met or exceeded
        for (Character current : connections) {
            if (current == to) {
                if (stopCount + 1 <= maxStops) {
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
            result = findPath(current, to, stopCount + 1, maxStops);
            if (result == true) {
                return result;
            }
            
            return false;
        }
        
        return false;
    }
    
    // return number of paths with length up to targetStops
    public int getPathCountByDistance(char start, char end, int targetStops, int routes) {
        //int from = mapStation(start);
        //int to = mapStation(end);
        int paths = 0;
        
        List<Character> connections = ng.getConnectionsFrom(start);
        
        for (Character link : connections) {
            if (findPathXsteps(link, end, targetStops, 1)) {
                paths++;
            }
        }
        
        return paths;
    }
    
    // return true if path found of length of target length
    private boolean findPathXsteps(char from, char to, int target, int currentDistance) {
        
        boolean result = false;
        // check base case
        if (currentDistance > target) {
            return false;
        }
        if (currentDistance == target && from == to) {
            return true;
        }
        
        List<Character> connections = ng.getConnectionsFrom(from);
        
        for (Character link : connections) {
            result = findPathXsteps(link, to, 4, currentDistance + 1);
        }
        
        return result;
          
    }
    
    // wrapper class
    public int getDistance(char start, char end) {
        return getDistance(start, end, 0);
    }
    
    // get distance from start to end
    private int getDistance(char start, char end, int length) {
        if (start == end) {
            return length;
        }
        
        List<Character> connections = ng.getConnectionsFrom(end);
        
        for (Character current : connections) {
            if (ng.isValidLink(start, current)) {
                length += ng.getLinkDistance(start,end);
                getDistance(current, end, length);
            }
        }
        return 0;
    }
    
    
    private int getPathLength(char from, char to, int length) {
        
        List<Character> connections = ng.getConnectionsFrom(from);
        for (Character link : connections) {
            length++;
            length += getPathLength(link,to,length);
        }
        return length;
    }
    
    
    /* Returns a count of paths found with exact number of stops */
    public int getPathExactLength(char start, char end, int pathCount,
            int currentSteps, int maxSteps) {
        
        // check if current station is the destination
        if (start == end) {
            // if steps maxSteps met increment pathCount and return
            if (currentSteps == maxSteps) {
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
        List<Character> connections = ng.getConnectionsFrom(start);
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
        List<Character> connections = ng.getConnectionsFrom(start);
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
        List<Character> connections = ng.getConnectionsFrom(start);
        // for each connection call method
        for (Character next : connections) {
            pathCount = 
                    getPathInLength(next, end, pathCount, currentSteps, maxSteps);
        }
        
        return pathCount;
    }
    
    /* Wrapper method for getShortestPath */
    public int getShortestPath(char start, char end) {
        int shortestPath = 0; // holds current shortestPath
        int currentSteps = 0; 
        int travelled = 0; // Distance travelled
        
        shortestPath = getShortestPath(start, end, shortestPath, currentSteps, travelled);
        
        return shortestPath;
    }
    
    private int getShortestPath(char start, char end, int shortestPath, int currentSteps, int travelled) {
        
        // check base case, end reached and travel has occured (distance > 0)
        if (start == end && travelled > 0) { 
            if (travelled < shortestPath) {
                shortestPath = travelled; 
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
        List<Character> connections = ng.getConnectionsFrom(start);
        
        for (char current : connections) {
            //System.out.print(start + "->" + current + "->");
            
            travelled += ng.getLinkDistance(start,current);
            shortestPath = getShortestPath(current, end, shortestPath, 0, travelled);
        }
        
        return shortestPath;
    }
}
