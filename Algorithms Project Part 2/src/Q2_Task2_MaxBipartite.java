
/**
 * @author Amal
 * @author Rawan
 * @author Mehave
 */

public class Q2_Task2_MaxBipartite {
    //Constructing the applicants and the hospitals arrays 
    
    static String[] ApplicantsList = {"Ahmed", "Mahmoud", "Eman", "Fatimah", "Kamel", "Nojood"};
    static String[] HospitalaList = {"King Abdelaziz University", "King Fahd", "East Jeddah", "King Fahad Armed Forces", "King Faisal Specialist", "Ministry of National Guard"};

  static int M = ApplicantsList.length, N = HospitalaList.length;
    
    //Maximum bipartite matching graph that given in project( N Hospitals, M Applicants ) 
    boolean bipartiteGraph[][] = new boolean[][]{
            {true, true, false, false, false, false},  //{1, 1, 0, 0, 0, 0}
            {false, false, false, false, false, true}, //{0, 0, 0, 0, 0, 1}
            {true, false, false, true, false, false},  //{1, 0, 0, 1, 0, 0}
            {false, false, true, false, false, false}, //{0, 0, 1, 0, 0, 0}
            {false, false, false, true, true, false},  //{0, 0, 0, 1, 1, 0}
            {false, false, false, false, false, true}};//{0, 0, 0, 0, 0, 1}
    
   static int assign[] = new int[N];
    
    /**
     * 
     * @param bpGraph: Create a maximum bipartite matching graph that given in project( Hospitals, Applicants )
     * @return maximum number of matching from applicants to hospitals
     */
    
  int maxBPM(){
            // An array to keep track of the 
            // applicants assigned to hospitals. 
            // The value of assign[i] is the 
            // applicant number assigned to hospital i, 
            // the value -1 indicates nobody is assigned.

            // Initially all hospital are available
            for (int i = 0; i < N; ++i) {
                assign[i] = -1;
            }

            // Count of hospital appointed applicants
            int matchCount = 0;
            for (int u = 0; u < M; u++) {
                // Mark all hospitals as not seen for next applicant.
                boolean seen[] = new boolean[N];
                for (int i = 0; i < N; ++i) {
                    seen[i] = false;
                }

                // Find if the applicant 'u' can appoint 
                if (bipartiteMatching(u, seen, assign)) {
                    matchCount++;
                }
            }
            return matchCount;
        }
   
   /**
     * 
     * @param u : the applicant
     * @param seen : array of hospitals, filled with true value if the hospital position is unavailable, false value if the hospital position is available
     * @param assign : array of appointed applicant with their hospitals
     * @return true if the hospital position is appointed to an applicant, false value if the hospital position is free
     */
     boolean bipartiteMatching (int u, boolean seen[], int assign[]) {
            // Try every hospital one by one
            for (int v = 0; v < N; v++) {
                // If applicant u is interested in hospital v and v is not visited
                if (bipartiteGraph[u][v] && !seen[v]) {

                    // Mark v as visited
                    seen[v] = true;

                    // If hospital 'v' is not assigned to
                    // an applicant OR previously
                    // assigned applicant for hospital v (which
                    // is assign[v]) has an alternate job available.
                    // Since v is marked as visited in the 
                    // above line, assign[v] in the following
                    // recursive call will not get hospital 'v' again
                    if (assign[v] < 0 || bipartiteMatching(assign[v],seen, assign)) {
                        assign[v] = u; //assign hospital v to applicant u
                        return true;
                    }
                }
            }
            return false;
        }

    /**
     * main method
     * @param args 
     */
    public static void main(String[] args) {
       System.out.println("    ********** CPCS324 Project - Question 2 - Task 2 **********");
       Q2_Task2_MaxBipartite Graph = new Q2_Task2_MaxBipartite ();
       
       int MaxAppointNum = Graph.maxBPM();
       System.out.println("\nApplicants" + "                   " + "Hospital");
       System.out.println("-----------------------------------------------------------------");
       
       boolean appointed [] = new boolean [N];
       
        for (int i = 0; i < N; i++) {
            if (assign[i] > -1) {
                System.out.println(ApplicantsList[assign[i]] + "\t     appointed by    " + HospitalaList[i] + " Hospital");
                appointed[assign[i]]=true;
            } 
        }
        System.out.println("-----------------------------------------------------------------");
        
//        System.out.println("\nHospitals and applicants didn't linked\n-------------------------------------");
        
        for (int j = 0; j < N; j++) {
            if (appointed[j] == false) {
                System.out.println("> "+ApplicantsList[j] + " does not appointed by any hospital");
            } 
            if (assign[j] == -1){
                System.out.println("> "+HospitalaList[j] + " does not appoint any applicant");
            }
        }
        //
        System.out.println("-----------------------------------------------------------------");
        System.out.println("> Maximum number of applicants that can get a position in hospital is " + MaxAppointNum);
    }
    
}
