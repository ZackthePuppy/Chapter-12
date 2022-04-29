import java.io.Serializable;

public class GradeBook implements Serializable {
    private int grades [] []  = new int [12][5];
    private String[] names = { "ENGLISH:", "FILIPINO:", "MATH:\t", "SCIENCE:", "P.E.:\t" };
    private String[] studName = new String [12];
    private float ave [] = new float [12];

    /**
     * @return int grades [] return the []
     */
    

    public GradeBook (){
    }

    public GradeBook(int grades2, String getnames, String studName2, float ave2, int x, int y) {
        this.grades[x] [y] = grades2;
        this.names [y] = getnames;
        this.studName [x]  = studName2;
        this.ave [x] = ave2;
    }

    public String getStudName(int x) {
        return studName[x];
    }

    public void setStudName(String value, int x){
        this.studName[x] = value;
    }

    public int getGrades(int x, int y) {
        return grades[x][y];
    }

    /**
     * @param [] the [] to set
     */
    public void setGrades(int value, int x, int y) {
        this.grades[x][y] = value;
    }


    public float getAve(int x) {
        return ave[x];
    }

    /**
     * @param [] the [] to set
     */
    public void setAve(float value, int x) {
        this.ave[x] = value;
    }

    /**
     * @return int names return the []
     */
    public String getnames(int x) {
        return names[x];
    }

    /**
     * @param [] the [] to set
     */

     
//  public String toString() {
//     String univString;
    
//     univString = stuName + " grade: " + stuGrade;
//     return (univString);
//     }



}
