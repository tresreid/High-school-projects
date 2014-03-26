
public class Test {
  
  
  public static void main(String[] args) { 
    double nextlev;
    double lastlev;
    for(int i=1;i<50;i++){
      nextlev= 75*Math.pow(1.1,i);
      lastlev= 75*Math.pow(1.1,(i-1));
     System.out.println("next level "+i+":"+nextlev); 
     System.out.println("level difference "+i+":"+(nextlev-lastlev)); 
    }
  
}//END OF MAIN METHOD
}

