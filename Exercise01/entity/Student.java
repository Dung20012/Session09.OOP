package Exercise01.entity;

import java.util.Scanner;

public class Student {
//    Attributes
    private String studentId;
    private String studentName;
    private int age;
    private String major;

//    Constructor không tham số
    public Student(){
    }

//    Constructor có tham số
    public Student(String studentId, String studentName, int age, String major) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.age = age;
        this.major = major;
    }

//    Getter và Setter
    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

//    Nhập vào đầy đủ thông tin sinh viên
    public void inputData(Scanner scanner){
        System.out.println("Nhập vào mã sinh viên: ");
        this.studentId = scanner.nextLine();
        System.out.println("Nhập vào tên sinh viên: ");
        this.studentName= scanner.nextLine();
        System.out.println("Nhập vào tuổi sinh viên: ");
        this.age =Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập vào chuyên ngành của sinh viên: ");
        this.major = scanner.nextLine();
    }
//    Phương thức hiển thị thông tin sinh viên
    public void displayData(){
        System.out.printf("Mã SV: %s - Tên SV: %s - TUổi SV: %d - Chuyên ngành: %s\n",
            this.studentId, this.studentName, this.age, this.major);
    }
}
