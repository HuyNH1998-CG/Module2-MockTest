import java.util.Scanner;

public class Menu {
    public static void menu() {
        while (true) {
            System.out.println("---- CHƯƠNG TRÌNH QUẢN LÝ SINH VIÊN ----");
            System.out.println("Chọn chức năng theo số (để tiếp tục");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Sắp xếp");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
            System.out.println("Chọn chức năng:");
            Scanner input = new Scanner(System.in);
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> StudentManagement.show();
                case 2 -> StudentManagement.add();
                case 3 -> StudentManagement.update();
                case 4 -> StudentManagement.delete();
                case 5 -> StudentManagement.sort();
                case 6 -> StudentManagement.readFromFile();
                case 7 -> StudentManagement.writeToFile();
                case 8 -> System.exit(0);
            }
        }
    }
}
