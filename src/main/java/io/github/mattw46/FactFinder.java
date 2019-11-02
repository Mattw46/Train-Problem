/*
 * FactFinder provide methods to obtain information about the train network
 * methods provide access to distances between towns, number of routes as
 * well as max and minimum distances.
 */
package io.github.mattw46;

/**
 *
 * @author Matthew Wall
 */
public class FactFinder {
    
    public FactFinder() {
        TrainNetwork tn = new TrainNetwork();
    }
    
    // Find distance of route A-B-C
    public String Question1() {
        return "Output #1: ";
    }
    
    // Find distance of route A-D
    public String Question2() {
        return "Output #2: ";
    }
    
    // Find distance of route A-D-C
    public String Question3() {
        return "Output #3: ";
    }
    
    // Find distance of route A-E-B-C-D
    public String Question4() {
        return "Output #4: ";
    }
    
    // Find distance of route A-E-D
    public String Question5() {
        return "Output #5: ";
    }
    
    // Find number of trips betwwen C and C with maximum of 3 stops
    public String Question6() {
        return "Output #6: ";
    }
    
    // Find number of trips between A and C with exactly 4 stops
    public String Question7() {
        return "Output #7: ";
    }
    
    // length of shortest route between A and C
    public String Question8() {
        return "Output #8: ";
    }
    
    // length of shortest route between B and B
    public String Question9() {
        return "Output #9: ";
    }
    
    // number of routes between C and C with distance of less than 30
    public String Question10() {
        return "Output #10: ";
    }
}
