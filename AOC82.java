import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;

//Round 1
//49 too low.
//Round 2

class AOC82{
    public static void main(String[] args) throws IOException {
        //Setup Code
        int[] letterFreq = new int[4];

        File file = new File("AOC8wires.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return;
        }
        String input = "Initialized";

        while(input!= null) {

        try {
            input = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            br.close();
            return;
        }
        if(input==null) break;
        String [] codesMain = input.split(" \\| ");

        String[] codesPart1 = codesMain[0].split("\\s+");
        //Determine which codes correspond to what
        Hashtable<Integer,String> crossWalk = new Hashtable<Integer,String>();

        //Letter Freq Key 0:1; 1:4; 2:7; 3:8
        for (int i = 0; i < codesPart1.length; i++) {
            int len = codesPart1[i].length();
            switch(len) {
                case 2: 
                crossWalk.put(1, codesPart1[i]);
                break;
                case 4: 
                crossWalk.put(4,codesPart1[i]);
                break;
                case 3: 
                crossWalk.put(7,codesPart1[i]);
                break;
                case 7: letterFreq[3]++;
                crossWalk.put(8,codesPart1[i]);
                break;
                default: 
                break;
            }
        }
        //List<Diff> diffs = new DiffMatchPatch().diffMain("stringend", "stringdiffend");

        for (int i = 0; i < codesPart1.length; i++) {
            int len = codesPart1[i].length();
            switch(len) {
                case 5:
                if(codesPart1[i].contains(Character.toString(crossWalk.get(1).charAt(0))) &&
                        codesPart1[i].contains(Character.toString(crossWalk.get(1).charAt(1)))) {
                    crossWalk.put(3, codesPart1[i]);
                    }
                
                if(codesPart1[i].contains(Character.toString(crossWalk.get(1).charAt(0))) &&
                    !codesPart1[i].contains(Character.toString(crossWalk.get(1).charAt(1)))) {
                crossWalk.put(3, codesPart1[i]);
                }
                break;
                case 4: 
                crossWalk.put(4,codesPart1[i]);
                break;
                case 3: 
                crossWalk.put(7,codesPart1[i]);
                break;
                case 7: letterFreq[3]++;
                crossWalk.put(8,codesPart1[i]);
                break;
                default: 
                break;
            }
        }
    }
        int total = 0;
        for(int i = 0; i < letterFreq.length; i++) {
            total += letterFreq[i];
            // System.out.println(letterFreq[i]);
        }
        System.out.print(total);

        br.close();
    }
}

//Need to create a translation table...
// Dictonary?
//Instantiate a Hashtable
//Come up with rules in the switch statements to link letters with the main sequence
//Use that dictionary to logic out which numbers are which 