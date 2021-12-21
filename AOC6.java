import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Round 1
//365131 is right!

//Round 2
//1041836936 is too low

class AOC6{
    public static void main(String[] args) throws IOException {
        int NUMBER_OF_DAYS = 256;
        //Setup Code
        long[] arrayOfAges = new long[9];
        long totalCount = 0;

        File file = new File("AOC6Lanternfish.txt");
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
        String[] fish = input.split(",");
        
        //Take a snapshot of all fish of all ages at t=0
        for(int i=0; i< fish.length; i++) {
            arrayOfAges[Integer.parseInt(fish[i])]++;
        }

        //Let time pass
        for(int i = 0; i<NUMBER_OF_DAYS; i++) {
            long temp = arrayOfAges[0];
            for(int j = 0; j < (arrayOfAges.length-1); j++) {
                arrayOfAges[j] = arrayOfAges[j+1];
            }
            arrayOfAges[6]+=temp;
            arrayOfAges[8]=temp;
        }

        for(int i=0;i<arrayOfAges.length;i++){
            totalCount+=arrayOfAges[i];    
        }
        System.out.println("Total Count: " + totalCount);
        br.close();
    }
}

//Instantiate a grid of zeros
//Draw lines on grid
    //Handle Horizontal Lines
    //Handle Vertical Lines

//Iterate through whole grid and find where grid[x][y]>1
    //Add one to the total count
//Print total count