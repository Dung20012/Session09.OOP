package Exercise03.entity;

import java.util.Scanner;

public class Categories implements IShop{
    private int catalogId;
    private String catalogName;
    private boolean catalogStatus;

//    Constructor không tham số
    public Categories(){
    }
//    Constructor có tham số
    public Categories(int id){
        this.catalogId = id;
    }
//    Getter và Setter
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }
//    Ghi đè phương thức
    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập tên danh mục: ");
        this.catalogName = scanner.nextLine();
        System.out.println("Trạng thái (true/false): ");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());
    }

    @Override
    public void displayData() {
     System.out.printf("ID: %d - Tên: %s - Trạng thái: %s\n",
             catalogId, catalogName, catalogStatus ? "Hoạt động" : "Không hoạt động");
    }
}
