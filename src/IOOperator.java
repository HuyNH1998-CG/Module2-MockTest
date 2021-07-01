import java.io.*;
import java.util.ArrayList;

public class IOOperator {
    public static void writeFile(){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Student.csv"));
            String something = "id,name,age,gender,address,average";
            bufferedWriter.write(something);
            for (Student student : StudentManagement.students) {
                bufferedWriter.newLine();
                bufferedWriter.write(student.diplay());
            }
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ArrayList<Student> readFile() {
        ArrayList<Student> list = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Student.csv"));
            String line = bufferedReader.readLine();
            while ((line = bufferedReader.readLine()) != null) {
                String[] arrStr = line.split(",");
                list.add(new Student(arrStr[0], arrStr[1], arrStr[2], arrStr[3], arrStr[4], arrStr[5]));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
}
