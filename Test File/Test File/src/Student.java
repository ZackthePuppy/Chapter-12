import java.io.*;
public class Student implements Serializable {


    private String stuName;
    private double stuGrade;
    private int testing;

    /**
     * constructor
     * pre: none
     * post: A Student object has been created.
     * Student data has been initialized with parameters.
     */
    public Student(String name, double grade) {
        stuName = name;
        stuGrade = grade;
    }
    public Student (){
        
    }

    
    public void setTry(int x) {
        this.testing = x;
    }
 /**
 * Creates a string representing the student object
 * pre: none
 * post: A string representing the student object 
 * has been returned.
 */
 public String toString() {
 String stuString;
 
 stuString = stuName + " grade: " + stuGrade;
 return (stuString);
 }
}

