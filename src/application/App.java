package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import entities.UsedProduct;
import entities.ImportedProduct;
import entities.Product;
public class App {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Product> list = new ArrayList<>();

        System.out.print("Enter the number of product: ");
        int n = sc.nextInt();

        for (int i=0; i< n; i++) {
            System.out.println("Product #" + (i+1) + " data: ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
             if ( ch == 'c') {
                Product prod = new Product(name, price);
                list.add(prod);    
             }
             else if (ch == 'u') {
                System.out.print("Manufacture date (DD/MM/AAAA): ");
                LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                
                Product prod = new UsedProduct(name, price, date);
                list.add(prod);
             }
             else {
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();

                Product prod = new ImportedProduct(name, price, customsFee);
                list.add(prod);
             }
        }
        System.out.println();
        System.out.println("PRICE TAGS:");
        for (Product prod : list) {
            System.out.println(prod.priceTag());
        }

        sc.close();
    }
}
