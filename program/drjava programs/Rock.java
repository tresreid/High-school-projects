import java.util.Scanner;
import java.util.Random;
public class Rock
{
public static void main(String[] args)
{ while (1==1){
String personPlay; //User's play -- "R", "P", or "S"
String computerPlay; //Computer's play -- "R", "P", or "S"
int computerInt; //Randomly generated number used to determine
//computer's play
Scanner scan = new Scanner(System.in);
Random generator = new Random();
//Get player's play -- note that this is stored as a string
// code goes below here
System.out.println("Please input your play (R,P,S,L,SP)");
personPlay=scan.next();                  
//Make player's play uppercase for ease of comparison
// code goes below here
personPlay=personPlay.toUpperCase();
//Generate computer's play (0,1,2)
// code goes below here
computerInt=generator.nextInt(5);
if(computerInt==0){computerPlay="Rock";}
else if(computerInt==1){computerPlay="Scissors";}
else if(computerInt==2){computerPlay="Paper";}
else if(computerInt==3){computerPlay="Lizard";}
else{computerPlay="Spock";}
//Translate computer's randomly generated play to string
// complete the switch statement below
  if (personPlay.equals("R")){
      switch (computerInt)
{
        case 0: System.out.println(personPlay+" IS "+computerPlay+"! Draw Game");break;
        case 1: System.out.println(personPlay+" Beats "+computerPlay+"! You Win!");break;
        case 2: System.out.println(personPlay+" Doesn't Beat "+computerPlay+"! Draw Game");break;
        case 3: System.out.println(personPlay+" Doesn't Beat "+computerPlay+"! Draw Game");break;
        case 4: System.out.println(personPlay+" is Beaten by "+computerPlay+"! You Lose!");break;
      }}
  else if (personPlay.equals("S")){
      switch (computerInt)
{
        case 0: System.out.println(personPlay+" is Beaten by "+computerPlay+"! You Lose!");break;
        case 1: System.out.println(personPlay+" IS "+computerPlay+"! Draw Game");break;
        case 2: System.out.println(personPlay+" Beats "+computerPlay+"! You Win!");break;
        case 3: System.out.println(personPlay+" Doesn't Beat "+computerPlay+"! Draw Game");break;
        case 4: System.out.println(personPlay+" Doesn't Beat "+computerPlay+"! Draw Game");break;
      }}
  else if (personPlay.equals("P")){
      switch (computerInt)
{
        case 0: System.out.println(personPlay+" Doesn't Beat "+computerPlay+"! Draw Game");break;
        case 1: System.out.println(personPlay+" is Beaten by "+computerPlay+"! You Lose!");break;
        case 2: System.out.println(personPlay+" Is "+computerPlay+"! Draw Game");break;
        case 3: System.out.println(personPlay+" Beats "+computerPlay+"! You Win!");break;
        case 4: System.out.println(personPlay+" Doesn't Beat "+computerPlay+"! Draw Game");break;
          }}
  else if (personPlay.equals("L")){
      switch (computerInt)
{
        case 0: System.out.println(personPlay+" Doesn't Beat "+computerPlay+"! Draw Game");break;
        case 1: System.out.println(personPlay+" Doesn't Beat "+computerPlay+"! Draw Game");break;
        case 2: System.out.println(personPlay+" is Beaten by "+computerPlay+"! You Lose!");break;
        case 3: System.out.println(personPlay+" Is "+computerPlay+"! Draw Game");break;
        case 4: System.out.println(personPlay+" Beats "+computerPlay+"! You Win!");break;
                  }}
  else if (personPlay.equals("SP")){
      switch (computerInt)
{
        case 0: System.out.println(personPlay+" Beats "+computerPlay+"! You Win!");break;
        case 1: System.out.println(personPlay+" Doesn't Beat "+computerPlay+"! Draw Game");break;
        case 2: System.out.println(personPlay+" Doesn't Beat "+computerPlay+"! Draw Game");break;
        case 3: System.out.println(personPlay+" is Beaten by "+computerPlay+"! You Lose!");break;
        case 4: System.out.println(personPlay+" IS "+computerPlay+"! Draw Game");break;
      }}
  else {System.out.println("Your input was invalid bitch");}
}}
}