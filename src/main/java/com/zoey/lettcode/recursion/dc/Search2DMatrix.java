package com.zoey.lettcode.recursion.dc;

public class Search2DMatrix {

    // think like a BST, but it is not actually
    // 这个最重要的还是这个矩阵很特殊，每一行都是ascending and 每一个列都是ascending
    public boolean searchMatrix1(int[][] matrix, int target) {

        //|| matrix[0].length == 0 去掉了多余的条件
        // || matrix.length == 0 // 去掉了多余的限制条件
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0)                      return false;
        // 长度
        int n = matrix.length;
        // 矩阵宽度
        int m = matrix[0].length;
        // 从右上角开始
        int rowIndex = 0, colIndex = m - 1;
        while(rowIndex < n && colIndex >= 0) {
            if (matrix[rowIndex][colIndex] == target) return true;
            else if (target < matrix[rowIndex][colIndex]) colIndex --;
            else rowIndex ++;
        }
        return false;
    }

    // 这道题也可作为divide and conquer的一个paradigm,我还不会写。。
    public boolean searchMatrix(int[][] matrix, int target) {
        // edge case
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // 注意这里length - 1
        return helper(matrix, target, 0, matrix.length-1,0, matrix[0].length-1);
    }


    public boolean helper(int[][] matrix, int target, int rowUpIndex, int rowDownIndex, int colLeftIndex, int colRightIndex) {

        // Base case
        // 1.什么时候会出现呢？
        if (rowUpIndex > rowDownIndex || colLeftIndex > colRightIndex) {
            return false;
        }
        // 剩下最后一个元素
        if (rowUpIndex == rowDownIndex && colLeftIndex == colRightIndex) {
            return matrix[rowUpIndex][colLeftIndex] == target;
        }
        int midRow = (rowDownIndex + rowUpIndex)/2;
        int midCol = (colLeftIndex + colRightIndex)/2;
        // System.out.println("midRow = " + midRow + ", midCol = " + midCol);

        if (matrix[midRow][midCol] < target) {
            // 这个时候有两个方向符合要求，mid的右半部分plusmid的左下半部分
            return helper(matrix, target, rowUpIndex,rowDownIndex,midCol+1,colRightIndex)
                    || helper(matrix, target, midRow+1,rowDownIndex,colLeftIndex,midCol);
        } else if (matrix[midRow][midCol] > target){
            // 这个时候也是有两个方向符合要求，可继续探寻，左半部分及右上部分
            return helper(matrix, target, rowUpIndex,midRow-1,colLeftIndex,colRightIndex)
                    || helper(matrix, target, midRow,rowDownIndex,colLeftIndex,midCol-1);
        }
        // 找到了target, for example, when target equals "9"
        return true;
    }

    // 一个二分查找 from me
    public boolean searchMatrix2(int[][] matrix, int target) {
        for(int i = 0; i < matrix.length; i ++) {
            // System.out.println("i = " + i);
            int startIndex = 0;
            int endIndex = matrix[i].length -1;
            while (startIndex <= endIndex) {
                // System.out.println("startIndex" + startIndex + "endIndex" + endIndex);
                // if (target < matrix[i][startIndex] && target <matrix[i][endIndex]) return false;
                if (target == matrix[i][startIndex] || target ==matrix[i][endIndex]) return true;
                else if (target > matrix[i][startIndex] && target <matrix[i][endIndex]) {
                    int middle = (startIndex + endIndex)/2;
                    if (target == matrix[i][middle]) return true;
                    if (target > matrix[i][middle]) startIndex = middle+1;
                    else endIndex = middle-1;
                }
                else break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Search2DMatrix matrix = new Search2DMatrix();
        int[][] nums = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        boolean res = matrix.searchMatrix(nums,5);
        int[][] test = {{5}};
        boolean res1 = matrix.searchMatrix(test,5);
        System.out.println("res = " + res);
        System.out.println("res1 = " + res1);


        // Want to test the difference between matrix == null and matrix.length == 0
        int[][] t = {{}}; // So it has an element...
        System.out.println("The length of matrix = " + t.length); // 1
        System.out.println("The length of matrix = " + t[0].length); // 0
        System.out.println("Is t null matrix: " + (t == null));

        int[][] t1 = {}; // This matrix is null
        System.out.println("The length of t1 matrix = " + t1.length); // 0
        // System.out.println("The length of t1 matrix = " + t1[0].length); // ArrayIndexOutOfBounds
        System.out.println("Is t1 null matrix: " + (t1 == null));

        int[][] t2 = null;
        System.out.println("Is t2 null matrix: " + (t2 == null)); // null

        // How about one dimo array
        int[] t3 = {};
        // System.out.println("The length of the array = " + t3.length);

    }
}
