import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


//Round 1
//49 too low.
//Round 2

class AOC8{
    public static void main(String[] args) throws IOException {
        //Setup Code
        int[] letterFreq = new int[4];
        List<String[]> codesMain = new ArrayList<String[]>();

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
        codesMain.add(input.split(" \\| "));
        }

        String[] codesPart1 = new String[codesMain.size()*4];
        for (int i = 0; i < codesMain.size(); i++ ) {
            System.out.println(codesMain.get(i)[1]);
            String[] subInput = codesMain.get(i)[1].split("\\s+");
            for(int j = 0; j < 4; j++) {
                System.out.print(i*4+j);
                System.out.println(subInput[j]);
                codesPart1[i*4+j] = subInput[j];
            }
        }
        //Letter Freq Key 0:1; 1:4; 2:7; 3:8
        for (int i = 0; i < codesPart1.length; i++) {
            System.out.println("Sup2: "+codesPart1[i]);
            if(codesPart1[i]==null) continue;
            int len = codesPart1[i].length();
            switch(len) {
                case 2: letterFreq[0]++;
                // System.out.println(codesPart1[i]);
                break;
                case 4: letterFreq[1]++;
                // System.out.println(codesPart1[i]);
                break;
                case 3: letterFreq[2]++;
                // System.out.println(codesPart1[i]);
                break;
                case 7: letterFreq[3]++;
                // System.out.println(codesPart1[i]);
                break;
                default: break;
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