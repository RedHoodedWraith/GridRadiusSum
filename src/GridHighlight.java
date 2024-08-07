/**
 * Grid Highlight Sum Problem
 * @author Asami De Almeida
 */

public class GridHighlight {

    int[][] grid = buildGrid(10);
    static final int grid_radius = 1;

    public int sumSurround(int n) {

        // Returns -1 if input value is invalid
        if(n < 1 || n > 100) {
            return -1;
        }

        // Array Co-ordinates for found number
        int x = -1, y = -1;
        // Find core number
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == n) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        // The total numbers to include in the sum is the grid radius multiplied by two and one added to it,
        // then squared
        int numbers_to_highlight = ((int) Math.pow(((grid_radius*2)+1),2));
        // xi, yi are the calculated indices to check in the grid;
        // sum_elm is the element to append to the to_sum array;
        // tsi is the current index for to_sum
        int xi, yi, sum_elm, tsi = 0;
        int[] to_sum = new int[numbers_to_highlight];
        for (int i = -grid_radius; i <= grid_radius; i++) {
            for (int j = -grid_radius; j <= grid_radius; j++) {
                xi = x+i;
                yi = y+j;

                if(xi < 0 || xi > grid.length -1 || yi < 0 || yi > grid.length - 1) {
                    sum_elm = 0;
                } else {
                    sum_elm = grid[xi][yi];
                }

                to_sum[tsi] = sum_elm;
                tsi++;
            }
        }

        // Calculates the sum
        int sum = 0;
        for (int j : to_sum) {
            sum += j;
        }
        return sum;
    }


    public static int[][] buildGrid(int n) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = j+1+(i*10);
            }
        }
        return grid;
    }

    public void printGrid(int[][] grid) {
        for (int[] i : grid) {
            for (int j = 0; j < i.length; j++) {
                System.out.print(i[j] + " ");
                if (j == i.length - 1) {
                    System.out.println();
                }
            }
        }
    }

    public static void main(String... args) {
        GridHighlight gh = new GridHighlight();
        int val = 11;
        gh.printGrid(gh.grid);
        System.out.println();
        System.out.println("sumSurround(" + val + ") = " + gh.sumSurround(val));
    }

}