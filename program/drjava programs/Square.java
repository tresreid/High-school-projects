// ****************************************************************
// Square.java
//
// Define a Square class with methods to create and read in
// info for a square matrix and to compute the sum of a row,
// a col, either diagonal, and whether it is magic.
//
// ****************************************************************
import java.util.Scanner;
public class Square
{
int[][] square;
int rowsum=0;
int colsum=0;
int dagsum=0;
int odagsum=0;
int size;
//--------------------------------------
//create new square of given size
//--------------------------------------
public Square(int size)
{
  square= new int[size][size];
  this.size=size;
}
//--------------------------------------
//return the sum of the values in the given row
//--------------------------------------
public int sumRow(int row)
{
  for(int r=0;r<size;r++){
    rowsum+=square[r][row];
  }
  return rowsum;
}
//--------------------------------------
//return the sum of the values in the given column
//--------------------------------------
public int sumCol(int col)
{
  for(int c=0;c<size;c++){
    colsum+=square[c][col];
}
  return colsum;
}
//--------------------------------------
//return the sum of the values in the main diagonal
//--------------------------------------
public int sumMainDiag()
{
  for(int i=0;i<size;i++){
    dagsum+=square[i][i];
  }
  return dagsum;
}
//--------------------------------------
//return the sum of the values in the other ("reverse") diagonal
//--------------------------------------
public int sumOtherDiag()
{
  for(int j=0;j<size;j++){
    odagsum+=square[size-j-1][j];
  }
  return odagsum;
}
//--------------------------------------
//return true if the square is magic (all rows, cols, and diags have
//same sum), false otherwise
//--------------------------------------
public boolean magic()
{
  if(dagsum!=odagsum){return false;}
  else{ 
    for(int row=0,col=0; row<size;row++,col++){
      if((rowsum/(size))!=dagsum || (colsum/(size))!=dagsum){ return false;}
      }
    return true;
}
}
//--------------------------------------
//read info into the square from the input stream associated with the
//Scanner parameter
//--------------------------------------
public void readSquare(Scanner scan)
{
for (int row = 0; row < square.length; row++)
for (int col = 0; col < square.length; col ++)
square[row][col] = scan.nextInt();
}
//--------------------------------------
//print the contents of the square, neatly formatted
//--------------------------------------
public void printSquare()
{
  System.out.println(square);
}
}