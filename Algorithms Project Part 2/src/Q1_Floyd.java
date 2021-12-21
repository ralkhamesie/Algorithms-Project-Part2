/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author Amal
 * @author Rawan
 * @author Mehave
 */
public class Q1_Floyd {

    static final int INF = Integer.MAX_VALUE;
    static double totalTime, endTime, startTime;

    public static void main(String args[]) {

        //  A    B    C    D    E    F    G    H    I    J 
        int[][] graph1 = {{0, 10, INF, INF, INF, 5, INF, INF, INF, INF}, // A
        {INF, 0, 3, INF, 3, INF, INF, INF, INF, INF}, // B
        {INF, INF, 0, 4, INF, INF, INF, 5, INF, INF}, // C
        {INF, INF, INF, 0, INF, INF, INF, INF, 4, INF}, // D
        {INF, INF, 4, INF, 0, INF, 2, INF, INF, INF}, // E
        {INF, 3, INF, INF, INF, 0, INF, INF, INF, 2}, // F
        {INF, INF, INF, 7, INF, INF, 0, INF, INF, INF}, // G
        {INF, INF, INF, 4, INF, INF, INF, 0, 3, INF}, // H
        {INF, INF, INF, INF, INF, INF, INF, INF, 0, INF}, // I
        {INF, 6, INF, INF, INF, INF, 8, INF, INF, 0}, // J    
    };
        int n1 = graph1.length;

        int[][] graph2 = {{0, 5, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 8}, // A
        {INF, 0, 11, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // B
        {INF, INF, 0, 9, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 10, INF, INF}, // C
        {INF, INF, INF, 0, 16, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // D
        {INF, INF, INF, INF, 0, 2, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 16, INF, INF, INF}, // E
        {INF, INF, INF, INF, INF, 0, 7, INF, INF, INF, INF, INF, INF, INF, 28, INF, INF, INF, INF, INF}, // F
        {INF, INF, INF, INF, INF, INF, 0, 7, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // G
        {INF, INF, INF, INF, INF, INF, INF, 0, 12, INF, INF, INF, 25, INF, INF, INF, INF, INF, INF, INF}, // H
        {INF, INF, INF, INF, INF, INF, INF, INF, 0, 8, INF, INF, INF, INF, INF, 1, INF, INF, INF, INF}, // I
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // J 
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, 8, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // A
        {INF, INF, INF, 17, INF, INF, INF, INF, INF, INF, 6, 0, INF, INF, INF, INF, INF, INF, INF, INF}, // B
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 4, 0, INF, INF, INF, INF, INF, INF, INF}, // C
        {INF, INF, INF, INF, INF, INF, INF, 4, INF, INF, INF, INF, 7, 0, INF, INF, INF, INF, INF, INF}, // D
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3, 0, INF, INF, INF, INF, INF}, // E
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 20, 0, INF, INF, INF, INF}, // F
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 11, 0, INF, INF, INF}, // G
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 7, 0, INF, INF}, // H
        {INF, 7, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 5, 0, INF}, // I
        {INF, 4, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 11, 0}, // J    
    };

//A  B  C  D  E  F  G  H  I  J  K  L  M   N  O  P  Q  R  S  T
        int n2 = graph2.length;

        int[][] graph3 = {{0, 11, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 17, INF, INF, INF, INF, 7}, // A
        {INF, 0, 15, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 6}, // B
        {INF, INF, 0, 8, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 25, INF, INF}, // C
        {INF, INF, INF, 0, 3, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 32, INF, INF, INF}, // D
        {INF, INF, INF, INF, 0, 24, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 9, INF, INF, INF, INF, INF, INF, INF}, // E
        {INF, INF, INF, INF, INF, 0, 14, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // F
        {INF, INF, INF, INF, INF, INF, 0, 8, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 6, INF, INF, INF, INF, INF, INF, INF, INF}, // G
        {INF, INF, INF, INF, INF, INF, INF, 0, 9, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // H
        {INF, INF, INF, INF, INF, INF, INF, INF, 0, 17, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 8, INF, INF, INF, INF, INF}, // I
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 22, INF, INF, INF, INF, INF, INF, INF, INF, 11, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // J 
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 3, INF, INF, INF, INF, INF, INF, 10, INF, INF, 18, INF, INF, INF, INF, INF, INF, INF, INF}, // A
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 12, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // B
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 32, INF, 9, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // C
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 2, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // D
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 12, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // E
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // F
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3, INF, 17, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // G
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 14, INF, INF, INF, INF, 9, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // H
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 5, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // I
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 8, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // J  

        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 7, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // A
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 48, 0, INF, INF, INF, INF, INF, INF, INF, INF}, // B
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3, 0, INF, INF, INF, INF, INF, INF, INF}, // C
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 8, 0, INF, INF, INF, INF, INF, INF}, // D
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 17, 0, INF, INF, INF, INF, INF}, // E
        {INF, INF, INF, INF, 7, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 21, 0, INF, INF, INF, INF}, // F
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 8, 0, INF, INF, INF}, // G
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 4, 0, INF, INF}, // H
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 12, 0, INF}, // I
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 27, 0},};
        int n3 = graph3.length;

        int[][] graph4 = {{0, 6, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // A
        {INF, 0, 9, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 6, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // B
        {INF, INF, 0, 13, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // C
        {INF, INF, INF, 0, 8, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // D
        {INF, INF, INF, INF, 0, 12, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // E
        {INF, INF, INF, INF, INF, 0, 3, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 9, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // F
        {INF, INF, INF, INF, INF, INF, 0, 13, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 4, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // G
        {INF, INF, INF, INF, INF, INF, INF, 0, 9, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // H
        {INF, INF, INF, INF, INF, INF, INF, INF, 0, 26, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // I
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 17, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 17, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // J 

        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 6, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // A
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 15, INF, INF, INF, INF, INF, INF, 20, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // B
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 9, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // C
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 15, INF, INF, INF, 9, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // D
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, 4, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // E
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // F
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 16, 7, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // G
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // H
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 12, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // I
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 7, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // J  
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 12, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // A
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 15, INF, INF, INF, INF, INF, INF, INF, 6, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // B
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 8, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 15, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // C
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // D
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 16, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // E
        {INF, INF, 4, 8, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 10, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // F
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // G
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 12, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // H
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 7, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // I
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 3, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF},
        {11, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 21, 0, INF, INF, INF, INF, INF, INF, INF, INF, INF}, // A
        {12, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 67, 0, INF, INF, INF, INF, INF, INF, INF, INF}, // B
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 34, 0, INF, INF, INF, INF, INF, INF, INF}, // C
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 12, INF, INF, INF, INF, INF, INF, INF, 54, 0, INF, INF, INF, INF, INF, INF}, // D
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 6, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 23, 0, INF, INF, INF, INF, INF}, // E
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 14, 0, INF, INF, INF, INF}, // F
        {INF, INF, INF, INF, INF, INF, INF, 7, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 22, 0, INF, INF, INF}, // G
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 7, 0, INF, INF}, // H
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 12, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 14, 0, INF}, // I
        {INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 5, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, INF, 5, 0},};

        int n4 = graph4.length;

        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        FloydWarshall(graph4, n4, vertex);

    }

    public static void FloydWarshall(int[][] mat, int n, char[] vertex) {
        //start time
        startTime = System.currentTimeMillis();

        System.out.println("*********************************<< Floyd-Warshall Algorithm >>*************************************\n");
        System.out.println("              The shortest path for each iteration is shown in the matrices below\n");
        // printing D(0) which is equivalent to the adj matrix
        System.out.println("The Weight Matrix\n");
        System.out.print("D(0)=\n\n\t");
        for (int c = 0; c < n; c++) {
            // printing the vertices labels 
            System.out.print(vertex[c] + "\t");
        }
        System.out.println("\n");
        for (int i = 0; i < n; i++) {
            // printing the vertices labels
            System.out.print(vertex[i] + "\t");
            for (int j = 0; j < n; j++) {
                System.out.print((mat[i][j] == INF ? "âˆ‍" : mat[i][j]) + (n - 1 == j ? "\n" : "\t"));
            }
        }
        System.out.println();
        // BEGINNING OF FLOYD ALGORITHM
        for (int i = 0; i < n; i++) {
            System.out.print("\nD(" + (i + 1) + ")=\n\n\t");
            // extra loop for printing the vertices labels (not needed for computations) 
            for (int c = 0; c < n; c++) {
                System.out.print(vertex[c] + "\t");
            }
            System.out.println("\n");
            for (int j = 0; j < n; j++) {
                System.out.print(vertex[j] + "\t");
                for (int k = 0; k < n; k++) {
                    if (mat[j][k] > mat[j][i] + mat[i][k] && mat[j][i] != INF && mat[i][k] != INF) {
                        mat[j][k] = mat[j][i] + mat[i][k];
                    }
                    System.out.print((mat[j][k] == INF ? "âˆ‍" : mat[j][k]) + (n - 1 == k ? "\n" : "\t"));
                }
            }
            System.out.println("");
        }

        //finish time of the algorithm
        endTime = System.currentTimeMillis();
        // calculate run time of Primâ€™s algorithm using PQ
        totalTime = endTime - startTime;
        //print the total time consumed by the algorithm
        System.out.println("Total runtime of Floyd-Warshall Algorithm in Second: " + (totalTime / 1000.0) + " s.");

    }
}
