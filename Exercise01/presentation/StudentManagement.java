package Exercise01.presentation;

import Exercise01.entity.Student;

import java.util.Scanner;

public class StudentManagement {
    //    Biến toàn cục (golbal) - lưu trữ thông tin sinh viên
    static Student[] arrStudent = new Student[100];
    static int currentIndex = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("*****QUẢN LÝ SINH VIÊN*****");
            System.out.println("1. Hiển thị danh sách sinh viên");
            System.out.println("2. Thêm sinh viên");
            System.out.println("3. Cập nhật thông tin sinh viên theo mã sinh viên");
            System.out.println("4. Xóa sinh viên theo mã sinh viên");
            System.out.println("5. Tìm sinh viên theo tên sinh viên");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayListStudent();
                    break;
                case 2:
                    addNewStudent(scanner);
                    break;
                case 3:
                    updateStudent(scanner);
                    break;
                case 4:
                    deleteStudent(scanner);
                    break;
                case 5:
                    searchStudentByName(scanner);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1 - 6");
            }
        } while (true);
    }

    //    Hiển thị tất cả thông tin sinh viên
    public static void displayListStudent() {
        for (int i = 0; i < currentIndex; i++) {
            arrStudent[i].displayData();
        }
        if (currentIndex == 0){
            System.err.println("Danh sách sinh viên trống");
            return;
        }
    }

    //    Thêm sinh viên
    public static void addNewStudent(Scanner scanner) {
        System.out.println("Nhập vào số sinh viên cần nhập thông tin: ");
        int cntStudent = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < cntStudent; i++) {
//            Khởi tạo phần tử có chỉ số curentIndex là đối tượng sinh viên
            arrStudent[currentIndex] = new Student();
//            Gọi phương thức inputData để nhập thông tin cho phần tử currentIndex
            arrStudent[currentIndex].inputData(scanner);
//            Tăng currentIndex lên 1 đơn vị
            currentIndex++;
        }
    }

    public static int findIndexById(String studentId){
        for (int i = 0; i < currentIndex; i++){
            if (arrStudent[i].getStudentId().equals(studentId)){
                return i;
            }
        }
        return  -1;
    }
//    Cập nhật thông tin sinh viên
    public static void updateStudent(Scanner scanner){
        System.out.println("Nhập vào mã sinh viên cần cập nhật thông tin");
        String studentId = scanner.nextLine();
        int indexUpdate = findIndexById(studentId);
        if (indexUpdate == -1){
            System.err.println("Không tồn tại mã sinh viên");
            return;
        }
//        Tiến hành cập nhật
        boolean isExit = true;
        do {
            System.out.println("1. Cập nhật tên sinh viên");
            System.out.println("2. Cập nhật tuổi sinh viên");
            System.out.println("3. Cập nhật chuyên ngành sinh viên");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    System.out.println("Nhập vào tên sinh viên mới: ");
                    arrStudent[indexUpdate].setStudentName(scanner.nextLine());
                    break;
                case 2:
                    System.out.println("Nhập vào tuổi mới của sinh viên: ");
                    arrStudent[indexUpdate].setAge(Integer.parseInt(scanner.nextLine()));
                    break;
                case 3:
                    System.out.println("Nhập vào chuyên ngành mới của sinh viên: ");
                    arrStudent[indexUpdate].setMajor(scanner.nextLine());
                    break;
                case 4:
//                    khi exit = false thì do while sẽ kết thúc
                    isExit = false;
                    break;
                default:
                    System.err.println("Vui lòng nhập từ 1 - 4");
            }
        }while (isExit);
    }

//    Xóa sinh viên theo mã sinh viên
    public static void deleteStudent(Scanner scanner){
        System.out.println("Nhập vào mã sinh viên cần xóa: ");
        String studentId = scanner.nextLine();
        int indexDelete = findIndexById(studentId);
        if (indexDelete == -1){
            System.err.println("Không tồn tại mã sinh viên");
            return;
        }
//        Thực hiện xóa
        for (int i = 0; i < currentIndex; i++){
            arrStudent[i] = arrStudent[i + 1];
        }
        arrStudent[currentIndex - 1] = null; // xóa phần tử cuối
        currentIndex--;
    }

//    Tìm kiếm sinh viên theo tên
    public static void searchStudentByName(Scanner scanner){
        int cntStudent = 0;
        System.out.println("Nhập vào tên sinh viên cần tìm: ");
        String studentName = scanner.nextLine();
        for (int i = 0; i < currentIndex; i++){
            if (arrStudent[i].getStudentName().toLowerCase().contains(studentName.toLowerCase())){
                arrStudent[i].displayData(); // in ra tất cả phần tử tìm thấy
                cntStudent++;
            }
        }
        System.out.printf("Tìm thấy %d sinh viên thỏa mãn điều kiện\n", cntStudent);
    }
}
