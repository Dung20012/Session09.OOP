package Exercise02.entity;

import java.util.Scanner;

public abstract class Pet {
//    Lớp trừu tượng
    protected String petId;
    protected String petName;
    protected int age;
//    Constructor không tham số
    public Pet(){
    }
//    Constructor có tham số
    public Pet(String petId, String petName, int age) {
        this.petId = petId;
        this.petName = petName;
        this.age = age;
    }
//    Getter và Setter
    public String getPetId() {
        return petId;
    }

    public void setPetId(String petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
//    Nhập đầy đủ thông tin thú cưng
    public void inputData(Scanner scanner){
        System.out.println("Nhập vào mã thú cưng (bắt đầu bằng C hoặc D + 3 số) : ");
        this.petId = scanner.nextLine();
        System.out.println("Nhập vào tên thú cưng (20 - 50 ký tự)");
        this.petName = scanner.nextLine();
        System.out.println("Nhập tuổi thú cưng (>0): ");
        this.age = Integer.parseInt(scanner.nextLine());
    }
//        Phương thức hiển thị thông tin thú cưng
    public void displayData(){
        System.out.printf("Mã: %s - Tên: %s - Tuổi %d\n",petId,petName,age);
    }

    public abstract void speak(); // phương thức kế thừa
}
