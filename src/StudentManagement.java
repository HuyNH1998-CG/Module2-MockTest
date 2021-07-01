import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    public static ArrayList<Student> students = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void add() {
        String id = getID();
        String name = getName();
        String age = getAge();
        String gender = getGender();
        String address = getAddress();
        String averageScore = getAverageScore();
        students.add(new Student(id, name, age, gender, address, averageScore));
    }

    private static String getAverageScore() {
        while (true) {
            try {
                System.out.println("Điểm trung bình");
                String avgScore = input.nextLine();
                if (ScoreRegex.validate(avgScore)) {
                    return avgScore;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Điểm trung bình phải là số");
            }
        }
    }

    private static String getAddress() {
        System.out.println("Địa Chỉ");
        return input.nextLine();
    }

    private static String getGender() {
        while (true) {
            try {
                System.out.println("Giới tính");
                String gender = input.nextLine();
                if (GenderRegex.validate(gender)) {
                    return gender;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Giới tính phải là nam hoặc nữ");
            }
        }
    }

    private static String getAge() {
        while (true) {
            try {
                System.out.println("Tuổi");
                String age = input.nextLine();
                if (AgeRegex.validate(age)) {
                    if (Integer.parseInt(age) < 18 || Integer.parseInt(age) > 70) {
                        throw new AgeException();
                    } else {
                        return age;
                    }
                } else {
                    throw new Exception();
                }
            } catch (AgeException age) {
                System.err.println("Người này quá già hoặc quá trẻ để đi học");
            } catch (Exception e) {
                System.err.println("Tuổi phải là số");
            }
        }
    }

    private static String getName() {
        System.out.println("Tên");
        return input.nextLine();
    }

    private static String getID() {
        System.out.println("Mã sinh viên");
        return input.nextLine();
    }

    public static void show() {
        for (Student student : students) {
            System.out.println(student.diplay());
        }
    }

    public static void update() {
        System.out.println("Nhập mã sinh viên của sinh viên cần thay đổi");
        String idToChange = input.nextLine();
        int index = -1;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentID().equals(idToChange)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            String id = getID();
            String name = getName();
            String age = getAge();
            String gender = getGender();
            String address = getAddress();
            String averageScore = getAverageScore();
            students.set(index, new Student(id, name, age, gender, address, averageScore));
        }
    }

    public static void delete() {
        System.out.println("Nhập mã sinh viên của sinh viên cần xóa");
        String idToDelete = input.nextLine();
        System.out.println("WARNING!!!");
        System.out.println("Bạn có thật sự muốn xóa không");
        System.out.println("1.Có");
        System.out.println("2.Không");
        int choice = Integer.parseInt(input.nextLine());
        if (choice == 1) {
            students.removeIf(student -> student.getStudentID().equals(idToDelete));
        }
    }

    public static void sort() {
        students.sort(new NameSorter());
    }

    public static void readFromFile() {
        students = IOOperator.readFile();
    }

    public static void writeToFile() {
        IOOperator.writeFile();
    }
}
