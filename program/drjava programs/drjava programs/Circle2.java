public class Circle2
{
public static void main(String[] args)
{
final double PI = 3.14159;
int radius1 = 10;
double area1 = PI * radius1 * radius1;
double circumfrence1 = 2*PI* radius1;
System.out.println("The area of a circle with radius " + radius1 +
" is " + area1);
System.out.println("The circumfrence of a circle with radius " + radius1 +
" is " + circumfrence1);

int radius2 = 20;
double area2 = PI * radius2 * radius2;
double circumfrence2 = 2*PI* radius2;
System.out.println("The area of a circle with radius " + radius2 +
" is " + area2);
System.out.println("The circumfrence of a circle with radius " + radius2 +
" is " + circumfrence2);

System.out.println(" area 1 divided by area 2 equals " + area1/area2);
}
}