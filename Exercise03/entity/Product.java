package Exercise03.entity;

import java.util.Scanner;

public class Product implements IShop{
    private String productId;
    private String productName;
    private float price;
    private int catalogId;

    public Product(){
    }

//    Getter và Setter
    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }
//    Ghi đè phương thức
    @Override
    public void inputData(Scanner scanner) {
        System.out.println("Nhập mã sản phẩm: ");
        this.productId = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm: ");
        this.productName = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        this.price = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập mã danh mục sản phẩm: ");
        this.catalogId = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public void displayData() {
        System.out.printf("ID: %s - Tên: %s - Giá: $.2f - Danh mục %d\n",
                productId, productName, price, catalogId);
    }
}
