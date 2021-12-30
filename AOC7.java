import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


//Round 1
//356903 is too high
//405761 is too high
//365839 is too high

//Round 2
//93700048 is too high

class AOC7{
    public static void main(String[] args) throws IOException {
        //Setup Code
        int fuelNeeded = 0;
        int median = 0;

        File file = new File("crabs.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return;
        }
        String input;

        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            br.close();
            return;
        }
        String[] crabs = input.split(",");
        int[] intCrabs = new int[crabs.length];
        
        
        //Take a snapshot of all fish of all ages at t=0
        for(int i=0; i< crabs.length; i++) {
            intCrabs[i] = Integer.parseInt(crabs[i]);
        }
        Arrays.sort(intCrabs);
        if(crabs.length%2==1){
            int medianPosition = (intCrabs.length+1)/2;
            median = intCrabs[medianPosition];
        }
        else{
            int medianPosition = intCrabs.length/2;
            median = (intCrabs[medianPosition]+intCrabs[medianPosition+1])/2;
        }

        System.out.println(median);

        for(int i = 0; i < crabs.length; i++) {
            fuelNeeded+= calculateFuel(Math.abs(Integer.parseInt(crabs[i])-472));
        }

        System.out.println(fuelNeeded);
        br.close();
    }
    private static int calculateFuel(int distance) {
        int total = 0;
        for(int i = distance; i > 0; i--) {
            total += i;
        }
        return total;
    }
}