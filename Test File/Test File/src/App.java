import java.io.*;
import java.util.Scanner;

public class App implements Serializable {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        // File textFile = new File("C:\\Users\\MikeChan\\Downloads\\Training Java\\Java
        // Projects\\Chapter 10\\Test File\\sample.txt");
        // if (textFile.exists()) {
        // System.out.println("File already exists.");
        // } else {
        // System.out.println("File does not exist.");
        // }





        // File textFile = new File("C:\\Users\\MikeChan\\Downloads\\Training Java\\Java
        // Projects\\Chapter 10\\Test File\\sample.txt");
        // String lineOfText;

        // try {
        // FileReader in = new FileReader(textFile);
        // BufferedReader readFile = new BufferedReader(in);
        // while ((lineOfText = readFile.readLine()) != null) {
        // System.out.println(lineOfText);
        // }
        // readFile.close();
        // in.close();
        // } catch (FileNotFoundException e) {
        // System.out.println("File does not exist or could not be found.");
        // System.err.println("FileNotFoundException: "
        // + e.getMessage());
        // } catch (IOException e) {
        // System.out.println("Problem reading file.");
        // System.err.println("IOException: " + e.getMessage());
        // }












            //FOR STORING AN OBJECT
            File stuFile = new File(
                    "wew.txt");

            try {
                /* write objects */
                FileOutputStream out = new FileOutputStream(stuFile);
                ObjectOutputStream writeStu = new ObjectOutputStream(out);
                FileInputStream in = new FileInputStream(stuFile);
                ObjectInputStream readStu = new ObjectInputStream(in);

                // writeStu.writeObject(new Student("name", 1));
                // writeStu.writeObject(new Student("Tia", 92));
                // System.out.println("Data written to file.");

                /* read objects */
                Student stu1 = (Student) readStu.readObject();
                Student stu90 = (Student) readStu.readObject();

                System.out.println(stu1);
                System.out.println(stu90);

                System.out.println(readStu.readObject());

                // writeStu.writeObject(new Student("MAYK", 87));
                // writeStu.writeObject(new Student("JAYP", 92));
                // writeStu.close();
                // System.out.println("\nData written to file 2nd try.");

                Student stu3 = (Student) readStu.readObject();
                Student stu4 = (Student) readStu.readObject();
                readStu.close();

                System.out.println(stu3);
                System.out.println(stu4);


            } catch (FileNotFoundException e) {
                System.out.println("File could not be found.");
                System.err.println("FileNotFoundException: "
                        + e.getMessage());
            } catch (IOException e) {
                System.out.println("Problem with input/output.");
                System.err.println("IOException: " + e.getMessage());
            } catch (ClassNotFoundException e) {
                System.out.println("Class could not be used to cast object.");
                System.err.println("ClassNotFoundException: "
                        + e.getMessage());
            }














        // //FOR CREATING TEXT INSIDE A FILE
        //     File dataFile = new File ("wew.txt");
        // FileWriter out;
        // BufferedWriter writeFile;
        // Scanner input = new Scanner(System.in);
        // double score;
        // String name;
        
        // try {
        // out = new FileWriter(dataFile);
        // writeFile = new BufferedWriter(out);
        // for (int i = 0; i < 3; i++) {
        // System.out.print("Enter student name: ");
        // name = input.next();
        // System.out.print("Enter test score: ");
        // score = input.nextDouble();
        // writeFile.write(name);
        // writeFile.newLine();
        // writeFile.write(String.valueOf(score));
        // writeFile.newLine();
        // } 
        // writeFile.close();
        // out.close();
        // System.out.println("Data written to file.");
        // } catch (IOException e) {
        // System.out.println("Problem writing to file.");
        // System.err.println("IOException: " + e.getMessage());
        // }













    }

}
