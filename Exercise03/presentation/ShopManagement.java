package Exercise03.presentation;

import Exercise03.entity.Categories;
import Exercise03.entity.Product;

import java.util.Scanner;

public class ShopManagement {
//    Biến toàn cục (golbal) - lưu trữ thông tin danh mục
    static Categories[] arrCategories = new Categories[100];
    static Product[] arrProducts = new Product[100];
    static int indexCategory = 0;
    static int indexProduct = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("******************SHOP MENU*******************");
            System.out.println("1. Quản lý danh mục sản phẩm");
            System.out.println("2. Quản lý sản phẩm");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    categoriesMenu(scanner);
                    break;
                case 2:
                    productMenu(scanner);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1 - 3.");
            }
        } while (true);
    }

    public static void categoriesMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("********************CATEGORIES MENU***********");
            System.out.println("1. Nhập thông tin các danh mục");
            System.out.println("2. Hiển thị thông tin các danh mục");
            System.out.println("3. Cập nhật thông tin danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Cập nhật trạng thái danh mục");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng danh mục: ");
                    int n = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < n; i++) {
                        Categories category = new Categories();
                        category.setCatalogId(indexCategory + 1);
                        category.inputData(scanner);
                        arrCategories[indexCategory++] = category;
                    }
                    break;
                case 2:
                    for (int i = 0; i < indexCategory; i++) {
                        arrCategories[i].displayData();
                    }
                    break;
                case 3:
                    System.out.print("Nhập mã danh mục cần cập nhật: ");
                    int updateId = Integer.parseInt(scanner.nextLine());
                    boolean foundUpdate = false;
                    for (int i = 0; i < indexCategory; i++) {
                        if (arrCategories[i].getCatalogId() == updateId) {
                            arrCategories[i].inputData(scanner);
                            foundUpdate = true;
                            break;
                        }
                    }
                    if (!foundUpdate) {
                        System.out.println("Không tìm thấy mã danh mục.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã danh mục cần xóa: ");
                    int deleteId = Integer.parseInt(scanner.nextLine());
                    boolean canDelete = true;
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProducts[i].getCatalogId() == deleteId) {
                            canDelete = false;
                            break;
                        }
                    }
                    if (!canDelete) {
                        System.out.println("Không thể xóa danh mục vì đang chứa sản phẩm.");
                        break;
                    }
                    int deleteIndex = -1;
                    for (int i = 0; i < indexCategory; i++) {
                        if (arrCategories[i].getCatalogId() == deleteId) {
                            deleteIndex = i;
                            break;
                        }
                    }
                    if (deleteIndex != -1) {
                        for (int i = deleteIndex; i < indexCategory - 1; i++) {
                            arrCategories[i] = arrCategories[i + 1];
                        }
                        arrCategories[--indexCategory] = null;
                        System.out.println("Xóa danh mục thành công.");
                    } else {
                        System.out.println("Không tìm thấy mã danh mục.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập mã danh mục cần cập nhật trạng thái: ");
                    int statusId = Integer.parseInt(scanner.nextLine());
                    boolean updated = false;
                    for (int i = 0; i < indexCategory; i++) {
                        if (arrCategories[i].getCatalogId() == statusId) {
                            arrCategories[i].setCatalogStatus(!arrCategories[i].isCatalogStatus());
                            updated = true;
                            System.out.println("Cập nhật trạng thái thành công.");
                            break;
                        }
                    }
                    if (!updated) {
                        System.out.println("Không tìm thấy mã danh mục.");
                    }
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1 - 6.");
            }
        } while (true);
    }

    public static void productMenu(Scanner scanner) {
        int choice;
        do {
            System.out.println("*******************PRODUCT MANAGEMENT*****************");
            System.out.println("1. Nhập thông tin các sản phẩm");
            System.out.println("2. Hiển thị thông tin các sản phẩm");
            System.out.println("3. Sắp xếp các sản phẩm theo giá");
            System.out.println("4. Cập nhật thông tin sản phẩm theo mã sản phẩm");
            System.out.println("5. Xóa sản phẩm theo mã sản phẩm");
            System.out.println("6. Tìm kiếm các sản phẩm theo tên sản phẩm");
            System.out.println("7. Tìm kiếm sản phẩm trong khoảng giá a – b");
            System.out.println("8. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Nhập số lượng sản phẩm: ");
                    int m = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < m; i++) {
                        Product product = new Product();
                        product.inputData(scanner);
                        arrProducts[indexProduct++] = product;
                    }
                    break;
                case 2:
                    for (int i = 0; i < indexProduct; i++) {
                        arrProducts[i].displayData();
                    }
                    break;
                case 3:
                    for (int i = 0; i < indexProduct - 1; i++) {
                        for (int j = i + 1; j < indexProduct; j++) {
                            if (arrProducts[i].getPrice() > arrProducts[j].getPrice()) {
                                Product temp = arrProducts[i];
                                arrProducts[i] = arrProducts[j];
                                arrProducts[j] = temp;
                            }
                        }
                    }
                    System.out.println("Đã sắp xếp sản phẩm theo giá.");
                    break;
                case 4:
                    System.out.print("Nhập mã sản phẩm cần cập nhật: ");
                    String updateCode = scanner.nextLine();
                    boolean found = false;
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProducts[i].getProductId().equalsIgnoreCase(updateCode)) {
                            arrProducts[i].inputData(scanner);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;
                case 5:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    String delCode = scanner.nextLine();
                    int delIndex = -1;
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProducts[i].getProductId().equalsIgnoreCase(delCode)) {
                            delIndex = i;
                            break;
                        }
                    }
                    if (delIndex != -1) {
                        for (int i = delIndex; i < indexProduct - 1; i++) {
                            arrProducts[i] = arrProducts[i + 1];
                        }
                        arrProducts[--indexProduct] = null;
                        System.out.println("Xóa sản phẩm thành công.");
                    } else {
                        System.out.println("Không tìm thấy sản phẩm.");
                    }
                    break;
                case 6:
                    System.out.print("Nhập tên sản phẩm cần tìm: ");
                    String keyword = scanner.nextLine().toLowerCase();
                    for (int i = 0; i < indexProduct; i++) {
                        if (arrProducts[i].getProductName().toLowerCase().contains(keyword)) {
                            arrProducts[i].displayData();
                        }
                    }
                    break;
                case 7:
                    System.out.print("Nhập giá tối thiểu: ");
                    float min = Float.parseFloat(scanner.nextLine());
                    System.out.print("Nhập giá tối đa: ");
                    float max = Float.parseFloat(scanner.nextLine());
                    for (int i = 0; i < indexProduct; i++) {
                        float price = arrProducts[i].getPrice();
                        if (price >= min && price <= max) {
                            arrProducts[i].displayData();
                        }
                    }
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng chọn từ 1 - 8.");
            }
        } while (true);
    }
}
