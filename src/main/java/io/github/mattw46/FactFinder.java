/*
 * FactFinder provide methods to obtain information about the train network
 * methods provide access to distances between towns, number of routes as
 * well as max and minimum distances.
 */
package io.github.mattw46;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Matthew Wall
 */
public class FactFinder {
    TrainNetwork tn;
    final String routeError = "NO SUCH ROUTE";
    
    public FactFinder() {
        tn = new TrainNetwork();
    }
    
    // Find distance of route A-B-C
    public String Question1() {
        String returnString = "Output #1: ";
        if (!tn.isValidLink('A', 'B') || !tn.isValidLink('B', 'C')) {
            return returnString + routeError;
        }
        int distance = tn.getLinkDistance('A', 'B');
        distance += tn.getLinkDistance('B', 'C');
        return returnString + distance;
    }
    
    // Find distance of route A-D
    public String Question2() {
        String returnString = "Output #2: ";
        if (!tn.isValidLink('A', 'D')) {
            return returnString + routeError;
        }
        int distance = tn.getLinkDistance('A', 'D');
        return returnString + distance;
    }
    
    // Find distance of route A-D-C
    public String Question3() {
        String returnString = "Output #3: ";
        int distance;
        
        //distance = getDistance('A', char end);
        if (!tn.isValidLink('A', 'B') || !tn.isValidLink('B', 'C')) {
            return returnString + routeError;
        }
        distance = tn.getLinkDistance('A', 'D');
        distance += tn.getLinkDistance('D', 'C');
        return returnString + distance;
    }
    
    // Find distance of route A-E-B-C-D
    public String Question4() {
        String returnString = "Output #4: ";
        if (!tn.isValidLink('A', 'E') || !tn.isValidLink('E', 'B') ||
                !tn.isValidLink('B', 'C') || !tn.isValidLink('C', 'D') ) {
            return returnString + routeError;
        }
        int distance = tn.getLinkDistance('A', 'E');
        distance += tn.getLinkDistance('E', 'B');
        distance += tn.getLinkDistance('B', 'C');
        distance += tn.getLinkDistance('C', 'D');
        return returnString + distance;
    }
    
    // Find distance of route A-E-D
    public String Question5() {
        String returnString = "Output #5: ";
        if (!tn.isValidLink('A', 'E') || !tn.isValidLink('E', 'D')) {
            return returnString + routeError;
        }
        int distance = tn.getLinkDistance('A', 'E');
        distance += tn.getLinkDistance('E', 'D');
        return returnString + distance;
        //return "Output #5: ";
    }
    
    // Find number of trips between C and C with maximum of 3 stops
    public String Question6() {
        int routes = tn.getPathInLength('C', 'C', 3);
        
        if (routes > 0) {
            return "Output #6: " + routes;
        }
        return "Output #6: " + routeError;
    }
    
    // Find number of trips between A and C with exactly 4 stops
    public String Question7() {
        int routes = tn.getPathExactLength('A', 'C', 0, 0, 4);
        
        if (routes > 0) {
            return "Output #7: " + routes;
        }
        return "Output #7: " + routeError;
        //return "Output #7: ";
    }
    
    // length of shortest route between A and C
    public String Question8() {
        int routes = tn.getShortestPath('A', 'C');
        if (routes > 0) {
            return "Output #8: " + routes;
        }
        return "Output #8: " + routeError;
    }
    
    // length of shortest route between B and B
    public String Question9() {
        int routes = tn.getShortestPath('A', 'C');
        if (routes > 0) {
            return "Output #9: " + routes;
        }
        return "Output #9: " + routeError;
    }
    
    // number of routes between C and C with distance of less than 30
    public String Question10() {
        return "Output #10: ";
    }
}
