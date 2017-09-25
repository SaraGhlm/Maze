//Sara Gholami (92222087)

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

import java.util.Scanner;

/**
 *
 * @author Novin Pendar
 */
public class Maze {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter row's count");
        int row = input.nextInt();
        System.out.println("Enter column's count");
        int column = input.nextInt();

        int[][] matrix = new int[row][column];

        for (int i = 0; i < row; i++) {
            matrix[i][0] = 1;
            matrix[i][column - 1] = 1;
        }

        for (int i = 0; i < column; i++) {
            matrix[0][i] = 1;
            matrix[row - 1][i] = 1;
        }

        boolean repeat = true;

        while (repeat) {
            System.out.println("Enter wall Y-coordinate");
            int y = input.nextInt();
            System.out.println("Enter wall X-coordinate");
            int x = input.nextInt();
            matrix[y][x] = 1;
            System.out.println("If want to finish it, enter #");
            input.nextLine();
            String answer = input.nextLine();
            if (answer.equals("#")) {
                repeat = false;
            }
        }
            
        System.out.println("Maze:");
        System.out.println();
        
        for(int i = 0 ; i < row; i++){
            for(int j =0 ; j<column; j++){
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        
        int[][] matrix2 = new int[row][column];
        for(int i = 0 ; i < row ; i++){
            System.arraycopy(matrix[i], 0, matrix2[i], 0, column);
        }
        
        StackAlgorithm sa = new StackAlgorithm(matrix, row, column);
        
        QueueAlgorithm qa = new QueueAlgorithm(matrix2, row, column);
    }

}
