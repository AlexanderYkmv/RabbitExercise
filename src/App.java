//My approach for this exercise is to make a 2D array. The values in it represent if there is a carrot(1) or if a carrot is missing(0).
//I tried to make it work for different sized squares of carrots, but couldn't. This program returns the 2x2 squares it finds as jumps. 

public class App {
    public static void main(String[] args)  {

        int garden[][] = {
            {
                1, 1, 1, 0, 0, 0,
                1, 1, 1, 0, 0, 0,
                1, 1, 1, 0, 0, 0,
                0, 0, 0, 0, 0, 0,
                0, 0, 0, 1, 1, 0,
                0, 0, 0, 1, 1, 0,

            }
        };
       int res = jumpsMade(garden);
       System.out.println(res);

        
    }

    
        public static int jumpsMade(int[][] garden) {
            int jumps = 0;
            while (sumArray(garden) > 0) {
                int row = -1;
                int col = -1;
                for (int i = 0; i < garden.length; i++) {
                    for (int j = 0; j < garden[i].length; j++) {
                        if (garden[i][j] == 1) {
                            row = i;
                            col = j;
                            break;
                        }
                    }
                    if (row != -1) {
                        break;
                    }
                }
                if (row == -1) {
                    break;
                }
                jumps++;
                eatCarrots(garden, row, col);
            }
            return jumps;
        }
    
        private static void eatCarrots(int[][] garden, int row, int col) {
            for (int i = row; i < garden.length && garden[i][col] == 1; i++) {
                for (int j = col; j < garden[i].length && garden[i][j] == 1; j++) {
                    garden[i][j] = 0;
                }
            }
        }
    
        private static int sumArray(int[][] array) {
            int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    sum += array[i][j];
                }
            }
            return sum;
        }
}

    

