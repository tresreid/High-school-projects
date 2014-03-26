public class Student
{

  
  /////////////////////////////////////////////
  // fields
  private String name;
  private double[] gradeArray;
  
  // this works, too
  //private double gradeArray[];
  
  //////////////////////////////////////////////
  // constructors
  
  // this is the default constructor, that would get added by the compiler
  //  if you don't create any of your own; once you create some others, then this
  //  one has to be added if you want a no-argument constructor
  //
  public Student() {}
  
  public Student (String theName)
  {
    this.name = theName;
  }
  
  // we're just storing the reference to an array in the field
  //
  public Student (String theName, double[] theGradeArray)
  {
    this.name = theName;
    //this.gradeArray = theGradeArray;
    this.gradeArray = theGradeArray.clone();
  }
  
  //////////////////////////////////////////////
  // methods
  public String toString()
  {
    String s;
    
    s = "Student object named " + this.name +
      "\nGrades: ";
    if (this.gradeArray != null) {
      for (double grade : this.gradeArray) {
        s = s + grade + " ";
      }
    }
    s = s + "\nAverage: " + this.getAverage();

    return s;
  }

  public double getAverage()
  {
    double totPoints = 0;
    double numGrades = 0;
    double avg = 0;
    
    if (this.gradeArray != null) {
      for (double grade : this.gradeArray) 
      {
        totPoints += grade;
        numGrades++;
      }
    }

    if (numGrades > 0) {
      avg = totPoints / numGrades;
    }
    
    return avg;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public void setName(String newName)
  {
    this.name = newName;
  }
  
  // doing it this way returns a pointer to gradeArray inside the object; so programs on the
  //   outside could end up changing data on the inside
  //
  //public double[] getGrades()
  //{
  //  return this.gradeArray;
  //}
  
  // this way gives the caller a copy of the data, so they can do what they want with it
  //
  public double[] getGrades()
  {
    return this.gradeArray.clone();
  }
  
} // end of class Student; put methods before this
