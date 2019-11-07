/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.mattw46;

/**
 *
 * @author Matthew Wall
 */
public class App {
    
    public static void main(String[] args) {
        //TrainNetwork tn = new TrainNetwork();
        FactFinder ff = new FactFinder();
        
        System.out.println(ff.Question1());
        System.out.println(ff.Question2());
        System.out.println(ff.Question3());
        System.out.println(ff.Question4());
        System.out.println(ff.Question5());
        System.out.println(ff.Question6());
        System.out.println(ff.Question7());
        System.out.println(ff.Question8());
        System.out.println(ff.Question9());
        System.out.println(ff.Question10());
        
        NetworkGraph ng = new NetworkGraph();
        
        // test graph network
        
        
        System.out.println("Q6 should output 2, output is: " + ng.getPathInLength('C', 'C', 3));
        System.out.println("Q7 should output 3, output is: " + ng.getPathExactLength('A', 'C', 0, 0, 4));
        System.out.println("Q8 should output 9, output is: " + ng.getShortestPath('A', 'C'));
        //System.out.println("Q8 should output 9, output is: " + ng.getShortestPath('B', 'B'));
        // getShortestPath(char start, char end, int shortestPath, int currentSteps)
        
        //ng.getPathExactLength('A', 'C', 0, 0, 4);
        // routes = tn.getPathCountByDistance('A', 'C', 4, routes);
        // getPathExactLength(start, end, pathCount, currentSteps, maxSteps);
    }
}
