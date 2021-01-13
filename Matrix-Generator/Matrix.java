import java.util.Random;

public class Matrix{
 
 public static int[][] createMatrix(int rows, int cols, int minValue, int maxValue){
  int[][] matrix = new int[rows][cols];
  Random rd = new Random();
  for(int i=0; i<rows;i++){
    for(int j=0;j<cols;j++)
      matrix[i][j] = minValue + rd.nextInt(maxValue - minValue + 1);}
  
  return matrix;
 }

 public static int[][] transpose(int A[][]){
   int rows = A.length;
   int cols = A[0].length;
   
   int[][] newA = new int[cols][rows];
   
   for(int i=0; i<rows; i++){
     for(int j=0; j<cols;j++)
       newA[j][i] = A[i][j];}
  return newA;
 }

 public static int[][] multiply(int A[][], int B[][]){
  int rowsA = A.length;
  int colsA = A[0].length;
  int rowsB = B.length;
  int colsB = B[0].length;
  
  if(colsA != rowsB){
    System.out.println("Error!!");
    return null;}
  int result[][] = new int[rowsA][colsB];
  for(int i=0; i<rowsA; i++){
    for(int j=0; j<colsB;j++){
      for(int k=0;k<colsA; k++)
        result[i][j] += A[i][k] * B[k][j];}}
  return result;
      
  
 }

 

 // toString is already done for you.
 public static String toString(int A[][]){
  int rows = A.length;
  int cols = A[0].length;
  String s = "Shape = " + String.valueOf(rows) + " x " + String.valueOf(cols) + "\n";
  for (int i = 0; i < rows; i++){
   for (int j = 0; j < cols; j++){
    s += String.valueOf(A[i][j]) + "\t";
    }
    s += "\n";
   }
   return s;
 }

 
 public static void main(String args[]){
  Matrix m = new Matrix();
  
  // test matrix creation A
  int[][] A = m.createMatrix(3, 4, 2, 8);
  System.out.println("\nMatrix A (Randomly initiated): " + m.toString(A));
  
  // test matrix transpose A
  int[][] tA = m.transpose(A);
  System.out.println("Transpose of Matrix A: " + m.toString(tA));

  // test matrix creation B
  int[][] B = m.createMatrix(4, 3, 2, 8);
  System.out.println("Matrix B (Randomly initiated): " + m.toString(B));
  
  // test matrix transpose B
  int[][] tB = m.transpose(B);
  System.out.println("Transpose of Matrix B: " + m.toString(tB));

  // test multiplication
  int[][] result = m.multiply(A,B);
  System.out.println("Result of Matrix Multiplication: " + m.toString(result));
 }

}