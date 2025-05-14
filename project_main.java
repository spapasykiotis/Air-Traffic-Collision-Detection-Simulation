import static java.lang.Math.abs;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class project_main {
    private static double analyzeCoordinate(airplane[] plane, int N, int limit, Comparator<airplane> comparator, String coordinateName) {
    
    // Sort planes by the specified coordinate
    Arrays.sort(plane, comparator);
    
    /* Print the sorted list
    System.out.println("Sorted by " + coordinateName + " airplanes list: ");
    for (int i = 0; i < N; i++) {
        System.out.print("(" + plane[i].x + "," + plane[i].y + "," + plane[i].z + ")" + " , ");
    }
    System.out.println("\n");
    */

    int L = 0;
    int R = N - 1;
    double warnings = 0;

    // Find initial cluster
    while (L < N - 1 && abs(getCoordinateValue(plane[L], coordinateName) - 
                         getCoordinateValue(plane[L + 1], coordinateName)) > limit) {
        L++;
    }

    // Analyze clusters
    while (L < R) {
        if (abs(getCoordinateValue(plane[L], coordinateName) - 
               getCoordinateValue(plane[R], coordinateName)) <= limit) {
            
            System.out.println("Chance of impact for airplanes included in [" + L + "," + R + "] (" + 
                             coordinateName + " limit) \n");
            System.out.println("First airplane ID is : " + plane[L].ID + 
                             ", last plane ID is : " + plane[R].ID + " \n");
            
            warnings += (R - L == 1) ? 1 : ((Math.pow(R - L, 2) + (R - L)) / 2);

            L = R;
            R = N - 1;
            
            if (L < N - 1 && abs(getCoordinateValue(plane[L], coordinateName) - 
                                getCoordinateValue(plane[L + 1], coordinateName)) > limit) {
                L++;
            }
        } else {
            R--;
        }
    }
    
    return warnings;
}

private static int getCoordinateValue(airplane plane, String coordinate) {
    switch(coordinate) {
        case "X": return plane.x;
        case "Y": return plane.y;
        default: return 0;
    }
}
    public static void main(String[] args) {

        int limit_y = 300;
        int limit_x = 600;
        //int L, R;
        double xwarnings ;
        double ywarnings ;
        double totalwarnings = 0;
        double warnings;
        long sumtime = 0;

        Random rand = new Random();     // τυχαιο αντικειμενο
        int N = 100;                    // TEST,παραγωγη τυχαιου N (airplanes): rand.nextInt(41) + 10;
        int T = rand.nextInt(11)+10; //Τυχαιο Τ πληθος επαναληψεων κωδικα 
        
        
        
        System.out.println("There are " + N + " airplanes \n");         //Βοηθητικη εκτυπωση
        System.out.println(T+" Discrete times will be checked \n");     //Βοηθητικη εκτυπωση

        airplane[] plane; // Δηλωση μεταβλητης 'plane' τυπου airplane array.
        plane = new airplane[N]; // creates slots to hold N airplanes.
         for (int i = 0; i < N; i++) {
            plane[i] = new airplane(i); // Δημιουργια καθε ξεχωριστου αεροπλανου με τυχαιες συντεγμενες x,y,z απο τον constructor).
        }
         
/*
        plane[0] = new airplane(100, 100, 100);
        plane[1] = new airplane(300, 300, 300);
        plane[2] = new airplane(50, 50, 50);
        plane[3] = new airplane(700, 700, 700);            // TEST CODE
        plane[4] = new airplane(900, 900, 900);
        plane[5] = new airplane(200, 200, 200);
        plane[6] = new airplane(405, 405, 405);
        plane[7] = new airplane(4761, 4761, 4761);
        plane[8] = new airplane(563, 563, 563);
        plane[9] = new airplane(4777, 4777, 4777);

*/      
        System.out.println("Original airplanes list: ");
        for (int i = 0; i < N; i++) {
            System.out.print("(" + plane[i].x + "," + plane[i].y + "," + plane[i].z + ")" + " , ");
        }
        
        
        System.out.println("\n Simulation starts \n"); 
      
        Instant simstart = Instant.now();
        simulation[] warn;
        warn = new simulation[T]; // creates slots to hold T warnings.


        // Simulation start

        for(int t=0;t<T;t++){
        
        Instant start = Instant.now(); //Εναρξη χρονομετρησης απο την ταξινομιση(για μια χρονικη στιγμη).
        warn[t] = new simulation(); // Δημιουργια καθε ξεχωριστου warning με μηδενικες τιμες απο τον constructor.
        warnings = 0;               //Reset warnings value.

        // Analyze airspace
        xwarnings = analyzeCoordinate(plane, N, limit_x, new sortbyX(), "X");
        ywarnings = analyzeCoordinate(plane, N, limit_y, new sortbyY(), "Y");

        // Simulation end
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis(); // Αποτελεσμα χρονομετρησης

        //Collecting Statistics
        warnings = xwarnings + ywarnings;
        System.out.println("");//TEST CODE
        System.out.println("Step "+t+" X limit warnings " + xwarnings + " \n");
        System.out.println("Step "+t+" Y limit warnings " + ywarnings + " \n");
        System.out.println("Step "+t+" total warnings " + warnings + " \n");
        System.out.println("Step "+t+" time elaspsed for calculation " + timeElapsed + " ms \n");
        
        // Save results
        warn[t].setTimeElapsed(timeElapsed);
        warn[t].setXwarning(xwarnings);
        warn[t].setYwarning(ywarnings);
        warn[t].setAllwarnings(xwarnings+ywarnings);
        totalwarnings += xwarnings + ywarnings;
        sumtime+=timeElapsed;
     
        // Randomize aiplane coordinates for next step
        if(t==T-1){
            break;              //Να μην κανει ενα περιττο βημα.
        }
        
        for(int i=0;i<N;i++){
            plane[i].setX(plane[i].x + rand.nextInt(1000));
            plane[i].setY(plane[i].y + rand.nextInt(1000));
            plane[i].setZ(plane[i].z + rand.nextInt(50));
            if(plane[i].getY() > 35000){    // Ελεγχος για μεγιστο υψος (35000)
                plane[i].setY(35000);
            }
        }
       
        }
   
        // Εξοδος προσομοιωσης
        Instant simfinish = Instant.now();
        long totaltimeElapsed = Duration.between(simstart, simfinish).toMillis();       //Χρονος εκτελεσης προσομοιωσης.
        long avgtime = sumtime/T;                                                       //Μεσος χρονος εκτελεσης βηματος t.
        
        System.out.println("Total simulation time : " +totaltimeElapsed+ " ms \n");
        System.out.println("Total siμulation warnings : "+totalwarnings+ " \n");
        System.out.println("Average calculation time per step : "+avgtime+ " ms \n");
        
    }
}
