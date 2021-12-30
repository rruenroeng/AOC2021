import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AOC92 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("AOC9-1-Input.txt");
        int count = 0;
        int[][] grid = new int[100][100];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "Initialized";
            for(int i = 0; i < 100; i++) {
                line = br.readLine();
                if(line==null) {
                    return;
                }
                char[] lineArr = line.toCharArray();
                for(int j = 0; j < 100; j++) {
                    grid[j][i] = (lineArr[j]-'0');
                }
            }
        } catch (FileNotFoundException e) {
            throw e;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        //At this point I have an integer grid filled with the numbers from the file.
        for (int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++){ 
                if(isWell(grid,i,j)) {
                    count+=(grid[j][i]+1); 
                    grid[j][i] = -10;
                }
            }
        }

        for (int i = 96; i < 100; i++) {
            System.out.println();
            for(int j = 0; j < 100; j++) {
                System.out.print(grid[j][i]);
            }
        }
        System.out.println();
        for (int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) 
                if(grid[j][i] == -10) {
                    int wellSize = 101 + wellSize(grid,i,j);
                    grid[j][i] = wellSize;
                }
        }

        for (int i = 96; i < 100; i++) {
            System.out.println();
            for(int j = 0; j < 100; j++) {
                if(grid[j][i]>100) {
                    System.out.println(grid[j][i]-100);
                }
            }
        }
        System.out.println(count);
    }

    private static int wellSize(int[][] grid, int i, int j) {
        if(i==-1 || i == grid[0].length || j == -1|| j == grid.length) return 0;
        if(grid[j][i] == 9 || grid[j][i] == -1) return 0;
        int num = grid[j][i];
        if(i!=0 && num<grid[j][i-1]) {
            grid[j][i] = -1;
            return 1 + wellSize(grid, i-1, j);
        }
        if(i!=grid[0].length-1 && num < grid[j][i+1]) {
            grid[j][i] = -1;
            return 1 + wellSize(grid, i+1, j);
        }
        if(j!=0 && num<grid[j-1][i]) {
            grid[j][i] = -1;
            return 1 + wellSize(grid, i, j-1);
        }
        if(j!=grid.length-1 && num < grid[j+1][i]) {
            grid[j][i] = -1;
            return 1 + wellSize(grid, i, j+1);
        }
        return 0;
    }
    

    private static boolean isWell(int[][] grid, int i, int j) {
        int num = grid[j][i];
        if((i==0 || num<grid[j][i-1]) &&
            (i==grid[0].length-1 || num < grid[j][i+1] ) &&
            (j==0 || num<grid[j-1][i] )&&
            (j==grid.length-1 || num < grid[j+1][i])) return true;
        return false;
    }
}

//Scan across grid from beginning to end.
    //Pass i,j to isWell function.
        //if adjacent grid positions are not all greater, then the current spot is not a well.