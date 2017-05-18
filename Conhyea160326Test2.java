
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Conhyea160326Test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        String studData;
        String fName;
        String lName;
        double[] test = new double[6];
        double[] course = new double[6];
        double[] total = new double[6];
        String[] grade = new String[6];
        double sum = 0;
        double[] avg = new double[13];
        String[] StudNewData = new String[13];
        int n = 0;

        try {

            File file = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\TEST2\\score.txt");
            File file2 = new File("C:\\Users\\Admin\\Documents\\NetBeansProjects\\TEST2\\StudentResult.txt");

            BufferedReader b = new BufferedReader(new FileReader(file));
            BufferedWriter w = new BufferedWriter(new FileWriter(file2));

            String readLine = "";

            System.out.println("Reading file using Buffered Reader");

            while ((readLine = b.readLine()) != null) {

                studData = readLine;
                String[] splited = studData.split("\\s+");
                fName = splited[0];
                lName = splited[1];
                int y = 2;
                for (int i = 0; i < test.length; i++) {
                    test[i] = Double.parseDouble(splited[y]);
                    course[i] = Double.parseDouble(splited[y + 1]);
                    y = y + 2;
                }
                sum = 0;
                for (int i = 0; i < total.length; i++) {
                    total[i] = (Math.floor(test[i] * 70 / 100) + Math.floor(course[i] * 30 / 100));
                    sum += total[i];
                    grade[i] = gradeScore(total[i]);
                }
                avg[n] = Math.round((sum / 6)*100.0 )/100.0;
                 StudNewData[n] = fName + " " + lName;
                for (int i = 0; i < test.length; i++) {
                    StudNewData[n] += " " + Double.toString(test[i]) + " " + Double.toString(course[i]) + " " + Double.toString(total[i]) + " " + grade[i];
                }
                StudNewData[n] += " " + sum + " " + avg[n];
                

                System.out.println(StudNewData[n]);
                n++;

            }
            
            
            String SortStudNewData[] = bubbleSort(avg,StudNewData);
           for(int i= (SortStudNewData.length- 1); i > -1;i--){ 
            w.write(SortStudNewData[i]);
            w.newLine();
            System.out.println("Success...");
           }
            w.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String gradeScore(double total) {
        String grade = "";
        if (total > 90) {
            grade = "A+";
        } else if (total >= 80 && total < 90) {
            grade = "A";
        } else if (total >= 70 && total < 80) {
            grade = "A-";
        } else if (total >= 60 && total < 70) {
            grade = "B";
        } else if (total >= 50 && total < 60) {
            grade = "C";
        } else if (total >= 40 && total < 50) {
            grade = "D";
        } else if (total >= 35 && total < 40) {
            grade = "E";
        } else if (total < 35) {
            grade = "F";
        }
        return grade;
    }
    private static String[] bubbleSort(double[] avg,String[] data) {
    int n = avg.length;
    double temp = 0;
    String tempStr = "";

    for(int i=0; i < n; i++){
        for(int j=1; j < (n-i); j++){

            if(avg[j-1] > avg[j]){
                //swap the elements!
                temp = avg[j-1];
                tempStr = data[j-1];
                
                avg[j-1] = avg[j];
                data[j-1] = data[j];
                avg[j] = temp;
                data[j] = tempStr;
                
               
            }
        }
    }
    return data;
}
}
    
    

