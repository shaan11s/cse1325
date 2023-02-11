import java.util.ArrayList;
import java.util.Scanner;

public class Store{

    private static ArrayList<Product> products = new ArrayList<Product>();
    private static ArrayList<Product> shoppingCart = new ArrayList<Product>();
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        
        
        Taxed.setTaxRate(.0875);
        
        Product Milk = new Taxfree("Milk", 6.98);
        Product Eggs = new Taxfree("Eggs", 5.34);
        Product Cheese = new Taxfree("Cheese", 1.30);
        Product Coconut = new Taxfree("Coconut", 6.75);
        Product Takis = new Taxed("Takis", 2.75);
        Product Jerkey = new Taxed("Jerkey", 1.75);
        Product Cookies = new Taxed("Cookies", 4.50);

        products.add(Milk);
        products.add(Eggs);
        products.add(Cheese);
        products.add(Coconut);
        products.add(Takis);
        products.add(Jerkey);
        products.add(Cookies);

        while(true){
            System.out.println("== WELCOME TO THE BODEGA ==\n\n");
            System.out.println(products);
            System.out.println("\n\n== YOUR CART ==\n\n");
            System.out.println(shoppingCart);
            System.out.println("\n\n");
            String input = myScanner.nextLine();
            if(input.equals("1")){
                shoppingCart.add(Milk);
            }
            if(input.equals("2")){
                shoppingCart.add(Eggs);
            }
            if(input.equals("3")){
                shoppingCart.add(Cheese);
            }
            if(input.equals("4")){
                shoppingCart.add(Coconut);
            }
            if(input.equals("5")){
                shoppingCart.add(Takis);
            }
            if(input.equals("6")){
                shoppingCart.add(Jerkey);
            }
            if(input.equals("7")){
                shoppingCart.add(Cookies);
            }
            // else{
            //     myScanner.close();
            //     System.exit(0);
            // }
        }
    }
}