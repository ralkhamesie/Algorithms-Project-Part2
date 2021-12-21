
/**
 * @author Amal
 * @author Rawan
 * @author Mehave
 */

public class Q1_Dijkstra {

    static final int INF = Integer.MAX_VALUE;
    static double totalTime, endTime, startTime;

    public static void main(String[] args) {
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

        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        dijkstra(graph2, 0, vertex);
    }

    public static void dijkstra(int[][] graph, int sourceVertex, char[] vertex) {
        //start time
        startTime = System.currentTimeMillis();

        int vertexCount = graph.length;
        System.out.println(vertexCount + " vertices ");
        boolean[] visitedVertex = new boolean[vertexCount];
        int[] distance = new int[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            visitedVertex[i] = false;
            distance[i] = Integer.MAX_VALUE;
        }
        distance[sourceVertex] = 0; // distance of source vertex to itself is zero

        for (int i = 0; i < vertexCount; i++) {
            //find the neighbouring unvisited vertex having  minimum distance from source vertex
            //for the first time u will be the source vertex and the distance array will be updated with the neighbouring vertex distance of source vertex
            int u = findMinDistance(distance, visitedVertex);

            //u is the row and v is the column
            visitedVertex[u] = true;
            //now update all the neighbour vertex distances
            for (int v = 0; v < vertexCount; v++) {
                //graph[u][v] != 0 -> there should be a direct edge
                if (!visitedVertex[v] && graph[u][v] != 0 && graph[u][v] != INF && (distance[u] + graph[u][v] < distance[v])) {
                    distance[v] = distance[u] + graph[u][v];
                }
            }
        }

        for (int i = 0; i < distance.length; i++) {
            System.out.println(String.format("Distance from source vertex %s to vertex %s is %s\n", vertex[sourceVertex], vertex[i], distance[i]));
        }

        System.out.println("");

        //finish time of the algorithm
        endTime = System.currentTimeMillis();
        // calculate run time of Primâ€™s algorithm using PQ
        totalTime = endTime - startTime;
        //print the total time consumed by the algorithm
        System.out.println("Total runtime of dijkstra Algorithm in Second: " + (totalTime / 1000.0) + " s.");

    }

    private static int findMinDistance(int[] distance, boolean[] visitedVertex) {
        int minDistance = INF;
        int minDistanceVertex = -1;
        for (int i = 0; i < distance.length; i++) {
            //the vertex should not be visited and the distance should be the minimum.
            //this is similar to finding the min element of an array

            if ((!visitedVertex[i]) && distance[i] <= minDistance) {
                minDistance = distance[i];
                minDistanceVertex = i;
            }
        }
        return minDistanceVertex;
    }

}
