import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

//Round 1
//37368 is too high
//5169 was juuuuust right

//Round 2
//19294 is too low

class AOC5{
    public static void main(String[] args) throws IOException {
        //Setup Code
        int[][] grid = new int[1000][1000];
        int totalCount = 0;

        for(int i=0;i<grid.length;i++)
            for(int j=0;j<grid[0].length;j++) {
                grid[i][j]=0;
            }
        System.out.println("Successfully instantiated a grid of zeros");
        File file = new File("thermalInput.txt");
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
            return;
        }
        String input = "Initialized";

        while(input!=null){
            try {
                input = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                br.close();
                return;
            }
            if(input==null) break;
            input = input.replace(" -> ", ",");
            String [] splitInput = input.split(",");
            int x1 = Integer.parseInt(splitInput[0]);
            int y1 = Integer.parseInt(splitInput[1]);
            int x2 = Integer.parseInt(splitInput[2]);
            int y2 = Integer.parseInt(splitInput[3]);
            //Handle Diagonals

            if(x2!=x1&&y1!=y2) {
                int xSource = Math.min(x1, x2);
                int xTarget = Math.max(x1, x2);
                int ySource,yTarget;
                if(xSource == x1) {
                    ySource = y1;
                    yTarget = y2;
                }
                else {
                    ySource = y2;
                    yTarget = y1;
                }
                System.out.println(ySource);
                for(int i = 0; i <= xTarget-xSource; i++) {
                    if(yTarget>ySource) {
                        grid[xSource+i][ySource+i]++;
                    }
                    else {
                        grid[xSource+i][ySource-i]++;
                    }
                }
                System.out.println("I did a diagonal!");
                continue;    
            }
            //Handle Horizontal Lines
            if(x2!=x1) {
                // System.out.println("X1: " +x1+" X2: " +x2);
                int y = y1;
                int xSource = Math.min(x1, x2);
                int xTarget = Math.max(x1, x2);
                for(int i = xSource; i <= xTarget; i++) {
                    grid[i][y]++;
                }
                continue;    
            }
            if(y2!=y1) {
                int x = x1;
                int ySource = Math.min(y1, y2);
                int yTarget = Math.max(y1, y2);
                for(int i = ySource; i <= yTarget; i++) {
                    grid[x][i]++;
                }
                continue;    
            }
        }
        for(int i=0;i<grid.length;i++){
            System.out.println();
            for(int j=0;j<grid[0].length;j++) {
                System.out.print(" " + grid[j][i]);
                if(grid[i][j]>1) {
                    totalCount++;
                }
            }
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