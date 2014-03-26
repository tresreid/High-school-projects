import java.util.ArrayList;
public class programName {
  public static void main(String[] arg){
ArrayList cities = new ArrayList();
cities.add("Atlanta");
cities.add("Boston");
for(int i=1; i< cities.size();i++){
  cities.add(i,"+");
}
System.out.println(cities);
  }
}