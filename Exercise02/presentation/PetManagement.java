package Exercise02.presentation;

import Exercise02.entity.Cat;
import Exercise02.entity.Dog;
import Exercise02.entity.Pet;

import java.util.Scanner;

public class PetManagement {
//    Biến toàn cục (golbal) - lưu trữ thông tin pet
    static Pet[] arrPet = new Pet[100];
    static int currentIndex = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("**********QUẢN LÝ THÚ CƯNG**********");
            System.out.println("1. Hiển thị danh sách thú cưng");
            System.out.println("2. Thêm thú cưng");
            System.out.println("3. Gọi tiếng kêu");
            System.out.println("4. Xóa thú cưng");
            System.out.println("5. Tìm thú cưng theo tên");
            System.out.println("6. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice){
                case 1:
                    displayList();
                    break;
                case 2:
                    addNewPet(scanner);
                    break;
                case 3:
                    speakPet(scanner);
                    break;
                case 4:
                    deletePet(scanner);
                    break;
                case 5:
                    searchPetByName(scanner);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1 - 6");
            }
        }while (true);
    }
//1.    Hiển thị thông tin thú cưng
    public static void displayList(){
        if (currentIndex == 0){
            System.out.println("Danh sách thú cưng trống");
            return;
        }
        for (int i = 0; i < currentIndex; i++){
            arrPet[i].displayData();
        }
    }
//2.    Thêm thú cưng
    public static void addNewPet(Scanner scanner){
        System.out.println("Thêm thú cưng: ");
        System.out.println("1. Thêm chó");
        System.out.println("2. Thêm mèo");
        int type = Integer.parseInt(scanner.nextLine());

        Pet newPet;
        if (type == 1){
            newPet = new Dog();
        }else {
            newPet = new Cat();
        }
        newPet.inputData(scanner);

//        Ktra trùng mã
        for (int i = 0; i < currentIndex; i++){
            if (arrPet[i].getPetId().equals(newPet.getPetId())){
                System.out.println("Mã thú cưng đã tồn tại");
                return;
            }
        }
//        Thm trước rồi tăng currentIndex
        arrPet[currentIndex] = newPet;
        currentIndex++;
        System.out.println("Thêm thú cưng thành công");
    }
//3.    Gọi tiếng kêu thú cưng
    public static void speakPet(Scanner scanner){
        System.out.println("Nhập mã thu cưng cần gọi tiếng: ");
        String id = scanner.nextLine();
        for (int i =0; i <currentIndex; i++){
            if (arrPet[i].getPetId().equals(id)){
                arrPet[i].speak();
                return;
            }
        }
        System.out.println("Không tìm thấy thú cưng");
    }
//4.    Xóa thú cưng
    public static void deletePet(Scanner scanner){
        System.out.println("Nhập mã thú cưng cần xóa: ");
        String id = scanner.nextLine();
        int index = -1;
        for (int i = 0; i < currentIndex; i++){
            if (arrPet[i].getPetId().equals(id)){
                index = i;
                break;
            }
        }
        if (index == -1){
            System.out.println("Không tìm thấy mã thú cưng");
            return;
        }
        for (int i = index; i < currentIndex -1; i++){
            arrPet[i] = arrPet[i + 1];
        }
        arrPet[currentIndex - 1] = null;
        currentIndex --;
        System.out.println("Xóa thành công");
    }
//    5. Tìm thú cưng theo tên
    public static void searchPetByName(Scanner scanner){
        System.out.println("Nhập tên thú cưng cần tìm: ");
        String name = scanner.nextLine().toLowerCase();
        int count = 0;
        for (int i = 0; i<currentIndex; i++){
            if (arrPet[i].getPetName().toLowerCase().contains(name)){
                arrPet[i].displayData();
                count++;
            }
        }
        System.out.println("Tìm thấy " + count + " thú cưng");
    }
}
