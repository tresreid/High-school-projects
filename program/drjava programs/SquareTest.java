// ****************************************************************
// SquareTest.java
//
// Uses the Square class to read in square data and tell if
// each square is magic.
//
// ****************************************************************
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
public class SquareTest
{
public static void main(String[] args) throws IOException
{
Scanner scan = new Scanner(new File("magicData.txt"));
int count = 1; //count which square we're on
int size = scan.nextInt(); //size of next square
//Expecting -1 at bottom of input file
while (size != -1)
{
  Square magic= new Square(size);
  magic.readSquare(scan);
//create a new Square of the given size
//call its read method to read the values of the square
System.out.println("\n******** Square " + count + " ********");
//print the square
System.out.println(magic);
//print the sums of its rows
for(int row=0;row<size;row++){
System.out.println("row "+row+" = "+(magic.sumRow(row)/(row+1)));
}
//print the sums of its columns
for(int col=0;col<size;col++){
System.out.println("column "+col+" = "+(magic.sumCol(col)/(col+1)));
}
//print the sum of the main diagonal
System.out.println("main diagonal = "+magic.sumMainDiag());                   
//print the sum of the other diagonal
System.out.println("other diagonal = "+magic.sumOtherDiag());                   
//determine and print whether it is a magic square
if(magic.magic()==true){
  System.out.println("This square is magic!");
}
else{System.out.println("This square is not magic");}
//get size of next square
size = scan.nextInt();
}
}
}