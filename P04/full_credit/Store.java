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

        double orderTotal = 0.00;

        while(true){
            System.out.println("===========================\n");
            System.out.println("== WELCOME TO THE BODEGA ==\n");
            System.out.println("== TODAYS DEALS BELOW!!! ==\n");
            System.out.println("===========================\n\n");
            System.out.println(products);
            System.out.println("\n\n== YOUR CART ==\n\n");
            System.out.println(shoppingCart);
            System.out.println("ORDER TOTAL " + orderTotal);
            System.out.println("\n\n");
            String input = myScanner.nextLine();
            if(input.equals("1")){
                shoppingCart.add(Milk);
                orderTotal+=Milk.price();
            }
            if(input.equals("2")){
                shoppingCart.add(Eggs);
                orderTotal+=Eggs.price();
            }
            if(input.equals("3")){
                shoppingCart.add(Cheese);
                orderTotal+=Cheese.price();
            }
            if(input.equals("4")){
                shoppingCart.add(Coconut);
                orderTotal+=Coconut.price();
            }
            if(input.equals("5")){
                shoppingCart.add(Takis);
                orderTotal+=Takis.price();
            }
            if(input.equals("6")){
                shoppingCart.add(Jerkey);
                orderTotal+=Jerkey.price();
            }
            if(input.equals("7")){
                shoppingCart.add(Cookies);
                orderTotal+=Cookies.price();
            }
            // else{
            //     myScanner.close();
            //     System.exit(0);
            // }
        }
    }
}