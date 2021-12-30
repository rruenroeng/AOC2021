import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class AOC8Try2 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("AOC8wires.txt");
        int count = 0;

        String data = "be cfbegad cbdgef fgaecd cgeb fdcge agebfd fecdb fabcd edb | fdgacbe cefdb cefbgd gcbe \n" +
        "edbfga begcd cbg gc gcadebf fbgde acbgfd abcde gfcbed gfec | fcgedb cgb dgebacf gc \n" +
        "fgaebd cg bdaec gdafb agbcfd gdcbef bgcad gfac gcb cdgabef | cg cg fdcagb cbg \n" +
        "fbegcd cbd adcefb dageb afcb bc aefdc ecdab fgdeca fcdbega | efabcd cedba gadfec cb \n" +
        "aecbfdg fbg gf bafeg dbefa fcge gcbea fcaegb dgceab fcbdga | gecf egdcabf bgf bfgea \n" +
        "fgeab ca afcebg bdacfeg cfaedg gcfdb baec bfadeg bafgc acf | gebdcfa ecba ca fadegcb \n" +
        "dbcfg fgd bdegcaf fgec aegbdf ecdfab fbedc dacgb gdcebf gf | cefg dcbef fcge gbcadfe \n" +
        "bdfegc cbegaf gecbf dfcage bdacg ed bedf ced adcbefg gebcd | ed bcgafe cdgba cbgef \n" +
        "gadfb cdbfeg cegd fecab cgb gbdefca cg fgcdab egfdb bfceg | gbdfcae bgc cg cgb \n" +
        "gcafb gcf dcaebfg ecagb gf abcdeg gaef cafbge fdbac fegbdc | fgae cfgab fg bagce \n";

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            //String line;
            //while((line = br.readLine()) != null) {           
            for(String line : data.split("\n") ) {
                String[] lineArr = line.split("\\|");
                //String input = lineArr[0];
                String output = lineArr[1];

                String[] outArr = output.split("\\s+");

                for(String s: outArr){
                    count += s.length() == 2 ? 1: 0;
                    count += s.length() == 3 ? 1: 0;
                    count += s.length() == 4 ? 1: 0;
                    count += s.length() == 7 ? 1: 0;
                }
            }
            System.out.println(count);

            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
