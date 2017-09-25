/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maze;

/**
 *
 * @author Novin Pendar
 */
public class QueueAlgorithm {

    private final int[][] matrix;
    private final int row;
    private final int column;
    private List list;
    private int pathCounter;

    public QueueAlgorithm(int[][] matrix, int row, int column) {
        this.row = row;
        this.column = column;
        this.matrix = matrix;
        list = new List();
        pathCounter = 0;
        search(1, 1);
    }

    private void search(int X, int Y) {
        matrix[Y][X] = 2;
        pathCounter++;
        LinkList linkList = new LinkList(X, Y);
        list.enqueue(linkList);
        if (Y != (row - 2) || X != (column - 2)) {
            int path = findPath(linkList);
            if (path == 1) {
                search(X, Y + 1);
            } else if (path == 2) {
                search(X + 1, Y);
            } else if (path == 3) {
                search(X, Y - 1);
            } else if (path == 4) {
                search(X - 1, Y);
            } else if (path == 0) {
                matrix[Y][X] = 3;
                returnPath();
            }
        } else {
            print();
        }
    }

    /*
     return integer from 0 to 4
     0 means there is no poth
     1 means there is path from bottom element
     2 means there is path from right element
     3 means there is path from top element
     4 means there is path from left element
     */
    private int findPath(LinkList linkList) {
        int answer = 0;
        if (matrix[linkList.getY() + 1][linkList.getX()] == 0) {
            answer = 1;
            return answer;
        } else if (matrix[linkList.getY()][linkList.getX() + 1] == 0) {
            answer = 2;
            return answer;
        } else if (matrix[linkList.getY() - 1][linkList.getX()] == 0) {
            answer = 3;
            return answer;
        } else if (matrix[linkList.getY()][linkList.getX() - 1] == 0) {
            answer = 4;
            return answer;
        }
        return answer;
    }

    private void returnPath() {
        int count = 0;
        List list1 = new List();
        LinkList temp;

        while (count != pathCounter - 2) {
            temp = list.dequeue();
            LinkList ll = new LinkList(temp.getX(), temp.getY());
            list1.enqueue(ll);
            count++;
        }
        temp = list.dequeue();
        list = list1;

        pathCounter = pathCounter - 2;
        search(temp.getX(), temp.getY());
        pathCounter = 0;
    }

    private void print() {
        boolean isEmpty = list.printQueue();
        System.out.println();
        if (!isEmpty) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    if (matrix[i][j] == 2) {
                        System.out.print("X");
                    } else if (matrix[i][j] == 3) {
                        System.out.print(0);
                    } else {
                        System.out.print(matrix[i][j]);
                    }
                }
                System.out.println();
            }
        }
    }
}
